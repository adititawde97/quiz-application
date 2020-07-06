package com.example.mcacetquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Result extends AppCompatActivity {

    public static ArrayList<AllQuestionsClass> actual_list;
    public static ArrayList<AllQuestionsClass> answer_list;
    int marks;
    TextView text_final_score;
    ListView list;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        list = (ListView) findViewById(R.id.my_list);
        text_final_score = (TextView) findViewById(R.id.text_final_score);

        marks=0;
        actual_list =  (ArrayList<AllQuestionsClass>)getIntent().getSerializableExtra("ACTUAL_LIST");
        answer_list =  (ArrayList<AllQuestionsClass>)getIntent().getSerializableExtra("ANSWERS_LIST");

        for(int i=0;i<actual_list.size();i++)
        {
            if(actual_list.get(i).getanswer().toLowerCase().equals(answer_list.get(i).getanswer().toLowerCase()))
            {
                marks++;
            }

        }
        text_final_score.setText(""+marks+"/"+(actual_list.size()));

        adapter = new CustomAdapter();
        list.setDividerHeight(2);
        list.setAdapter(adapter);
    }


    class CustomAdapter extends BaseAdapter {
        LayoutInflater mInflater;

        public CustomAdapter() {
            mInflater = (LayoutInflater)getApplication().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return actual_list.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.custom_question_list_item, parent, false);
                holder = new ViewHolder();
                holder.text_question_no = (TextView) convertView.findViewById(R.id.text_question_no);
                holder.txt_question_name = (TextView) convertView.findViewById(R.id.txt_question_name);
                holder.txt_option_a = (TextView) convertView.findViewById(R.id.txt_option_a);
                holder.txt_option_b = (TextView) convertView.findViewById(R.id.txt_option_b);
                holder.txt_option_c = (TextView) convertView.findViewById(R.id.txt_option_c);
                holder.txt_option_d = (TextView) convertView.findViewById(R.id.txt_option_d);
                holder.txt_actual_answer = (TextView) convertView.findViewById(R.id.txt_actual_answer);
                holder.txt_your_answer = (TextView) convertView.findViewById(R.id.txt_your_answer);
                convertView.setTag(holder);
            }
            else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.text_question_no.setText("Q"+(position+1)+")");
            holder.txt_question_name.setText(actual_list.get(position).getQuestion_name());
            holder.txt_option_a.setText("a) "+actual_list.get(position).getOption_a());
            holder.txt_option_b.setText("b) "+actual_list.get(position).getOption_b());
            holder.txt_option_c.setText("c) "+actual_list.get(position).getOption_c());
            holder.txt_option_d.setText("d) "+actual_list.get(position).getOption_d());
            holder.txt_actual_answer.setText("Correct Ans : "+actual_list.get(position).getanswer());
            holder.txt_your_answer.setText("Your Ans: "+answer_list.get(position).getanswer());


            return convertView;
        }


    }
    public static class ViewHolder {

        public TextView text_question_no;
        public TextView txt_question_name;
        public TextView txt_option_a;
        public TextView txt_option_b;
        public TextView txt_option_c;
        public TextView txt_option_d;
        public TextView txt_actual_answer;
        public TextView txt_your_answer;

    }
}

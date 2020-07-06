package com.example.mcacetquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class QuizQuestionsActivity extends AppCompatActivity {

    public static ArrayList<AllQuestionsClass> actual_list; // done
    public static ArrayList<AllQuestionsClass> answer_list; // done

    Resources res;

    public static String[] question_name, option_a, option_b, option_c,option_d,answer;

    public static int iterator; // done

    Button btn_next,btn_prev,btn_submit;
    TextView text_question_no,txt_question_name;
    RadioGroup rg_options;
    RadioButton rb_option_a,rb_option_b,rb_option_c,rb_option_d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_quiz_questions);


        btn_next = findViewById(R.id.btn_next);
        btn_prev =  findViewById(R.id.btn_prev);
        btn_submit =  findViewById(R.id.btn_submit);
        text_question_no =  findViewById(R.id.text_question_no);
        txt_question_name = findViewById(R.id.txt_question_name);
        rg_options = findViewById(R.id.rg_options);
        rb_option_a = findViewById(R.id.rb_option_a);
        rb_option_b = (RadioButton) findViewById(R.id.rb_option_b);
        rb_option_c = (RadioButton) findViewById(R.id.rb_option_c);
        rb_option_d = (RadioButton) findViewById(R.id.rb_option_d);

        iterator=0;

        actual_list = new ArrayList<>();
        answer_list = new ArrayList<>();


        res = getResources();

        question_name = res.getStringArray(R.array.question_name);
        option_a = res.getStringArray(R.array.option_a);
        option_b = res.getStringArray(R.array.option_b);
        option_c = res.getStringArray(R.array.option_c);
        option_d = res.getStringArray(R.array.option_d);
        answer = res.getStringArray(R.array.answer);

        for (int i = 0; i < question_name.length; i++) {
            AllQuestionsClass obj = new AllQuestionsClass(question_name[i], option_a[i], option_b[i], option_c[i],option_d[i],answer[i]);
            actual_list.add(obj);
        }
        for (int i = 0; i < question_name.length; i++) {
            AllQuestionsClass obj = new AllQuestionsClass(question_name[i], option_a[i], option_b[i], option_c[i],option_d[i],"");
            answer_list.add(obj);
        }

        text_question_no.setText("Q"+(iterator+1)+")");
        txt_question_name.setText(actual_list.get(iterator).getQuestion_name());
        rb_option_a.setText(actual_list.get(iterator).getOption_a());
        rb_option_b.setText(actual_list.get(iterator).getOption_b());
        rb_option_c.setText(actual_list.get(iterator).getOption_c());
        rb_option_d.setText(actual_list.get(iterator).getOption_d());


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(iterator==actual_list.size()-1)
                {
                    Toast.makeText(getApplicationContext(),"No Further questions",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    rg_options.clearCheck();
                    iterator++;
                    text_question_no.setText("Q"+(iterator+1)+")");
                    txt_question_name.setText(actual_list.get(iterator).getQuestion_name());
                    rb_option_a.setText(actual_list.get(iterator).getOption_a());
                    rb_option_b.setText(actual_list.get(iterator).getOption_b());
                    rb_option_c.setText(actual_list.get(iterator).getOption_c());
                    rb_option_d.setText(actual_list.get(iterator).getOption_d());

                    if(answer_list.get(iterator).getanswer()!="")
                    {
                        if(rb_option_a.getText().toString()==answer_list.get(iterator).getanswer())
                        {
                            rg_options.check(R.id.rb_option_a);

                        }
                        else if(rb_option_b.getText().toString()==answer_list.get(iterator).getanswer())
                        {
                            rg_options.check(R.id.rb_option_b);

                        }
                        else if(rb_option_c.getText().toString()==answer_list.get(iterator).getanswer())
                        {
                            rg_options.check(R.id.rb_option_c);

                        }
                        else if(rb_option_d.getText().toString()==answer_list.get(iterator).getanswer())
                        {
                            rg_options.check(R.id.rb_option_d);

                        }
                        else
                        {

                        }

                    }
                    else
                    {
                        rg_options.clearCheck();
                    }

                   // Toast.makeText(getApplicationContext(),"Answer that you marked: "+answer_list.get(iterator).getanswer(),Toast.LENGTH_SHORT).show();
                }


            }
        });

        btn_prev.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                if(iterator<=0)
                {
                    Toast.makeText(getApplicationContext(),"No Further questions",Toast.LENGTH_LONG).show();

                }
                else
                {
                    rg_options.clearCheck();
                    iterator--;
                    text_question_no.setText("Q"+(iterator+1)+")");
                    txt_question_name.setText(actual_list.get(iterator).getQuestion_name());
                    rb_option_a.setText(actual_list.get(iterator).getOption_a());
                    rb_option_b.setText(actual_list.get(iterator).getOption_b());
                    rb_option_c.setText(actual_list.get(iterator).getOption_c());
                    rb_option_d.setText(actual_list.get(iterator).getOption_d());


                    if(answer_list.get(iterator).getanswer()!="")
                    {
                        if(rb_option_a.getText().toString()==answer_list.get(iterator).getanswer())
                        {
                            rg_options.check(R.id.rb_option_a);
                        }
                        else if(rb_option_b.getText().toString()==answer_list.get(iterator).getanswer())
                        {
                            rg_options.check(R.id.rb_option_b);
                        }
                        else if(rb_option_c.getText().toString()==answer_list.get(iterator).getanswer())
                        {
                            rg_options.check(R.id.rb_option_c);
                        }
                        else if(rb_option_d.getText().toString()==answer_list.get(iterator).getanswer())
                        {
                            rg_options.check(R.id.rb_option_d);
                            //rb_option_d.setSelected(true);
                            Toast.makeText(getApplicationContext(),"Option D",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {

                        }

                    }
                    else
                    {
                        rg_options.clearCheck();
                    }
                }
                //Toast.makeText(getApplicationContext(),"Answer that you marked: "+answer_list.get(iterator).getanswer(),Toast.LENGTH_SHORT).show();

            }
        });

        rg_options.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==rb_option_a.getId())
                {
                    answer_list.get(iterator).setanswer(rb_option_a.getText().toString());
                    //Toast.makeText(getApplicationContext(),"Option A Selected",Toast.LENGTH_SHORT).show();
                }
                else if(checkedId==rb_option_b.getId())
                {
                    answer_list.get(iterator).setanswer(rb_option_b.getText().toString());
                    //Toast.makeText(getApplicationContext(),"Option B Selected",Toast.LENGTH_SHORT).show();
                }
                else if(checkedId==rb_option_c.getId())
                {
                    answer_list.get(iterator).setanswer(rb_option_c.getText().toString());
                    //Toast.makeText(getApplicationContext(),"Option C Selected",Toast.LENGTH_SHORT).show();
                }
                else if(checkedId==rb_option_d.getId())
                {
                    answer_list.get(iterator).setanswer(rb_option_d.getText().toString());
                    //Toast.makeText(getApplicationContext(),"Option D Selected",Toast.LENGTH_SHORT).show();
                }
                else
                {

                }
            }
        });




        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), Result.class);
                i.putExtra("ANSWERS_LIST", answer_list);
                i.putExtra("ACTUAL_LIST", actual_list);
                startActivity(i);
                //Toast.makeText(getApplicationContext(),"This is my Toast message!",Toast.LENGTH_LONG).show();
            }
        });
    }
}

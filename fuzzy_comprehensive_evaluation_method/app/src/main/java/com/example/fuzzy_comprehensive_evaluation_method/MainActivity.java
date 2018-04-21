package com.example.fuzzy_comprehensive_evaluation_method;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editText1,editText2,editText3,editText4,editTest6;
    private Button button1,button2,button3,button4,button5,button6;
    private TextView textView5;
    int factor_number = 0,level_number = 0,kind = 0,mkind = 0;
    int i = 0,j = 0,submitcount = 0;
    double[][] r;
    double answer = 0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        editText1 = (EditText) findViewById(R.id.edit_text1);
        button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(this);

        editText2 = (EditText) findViewById(R.id.edit_text2);
        button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(this);

        editText3 = (EditText) findViewById(R.id.edit_text3);
        button3 = (Button) findViewById(R.id.button_3);
        button3.setOnClickListener(this);

        editTest6 = (EditText) findViewById(R.id.edit_text6);
        button6 = (Button) findViewById(R.id.button_6);
        button6.setOnClickListener(this);

        editText4 = (EditText) findViewById(R.id.edit_text4);
        button4 = (Button) findViewById(R.id.button_4);
        button4.setOnClickListener(this);

        textView5 = (TextView) findViewById(R.id.text_view5);
        button5 = (Button) findViewById(R.id.button_5);
        button5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId()) {
            case R.id.button_1:
                String input_factor_number = editText1.getText().toString();
                factor_number = Integer.parseInt(input_factor_number);
                break;
            case R.id.button_2:
                String input_level_number = editText2.getText().toString();
                level_number = Integer.parseInt(input_level_number);
                r = new double[factor_number][level_number];
                break;
            case R.id.button_3:
                String input_kind = editText3.getText().toString();
                kind = Integer.parseInt(input_kind);
                break;
            case R.id.button_6:
                String input_mkind = editTest6.getText().toString();
                mkind = Integer.parseInt(input_mkind);
                break;
            case R.id.button_4:
                if (mkind == 1)
                {
                    double temp = 0.000000;
                    String edithint;
                    if (submitcount < factor_number * level_number) {
                        String s = editText4.getText().toString();
                        temp = Double.parseDouble(s);
                        r[i][j] = temp;
                        if (j == (level_number - 1)) {
                            i++;
                            j = 0;
                        } else if (j < (level_number - 1)) {
                            j++;
                        }
                        submitcount++;
                    }
                    editText4.setText("");
                    edithint = "please input r[" + i + "]" + "[" + j + "]: ";
                    editText4.setHint(edithint);
                }
                else
                {
                    double temp = 0.000000;
                    String edithint;
                    if (submitcount < factor_number * 4) {
                        String s = editText4.getText().toString();
                        temp = Double.parseDouble(s);
                        r[i][j] = temp;
                        if (j == 3) {
                            i++;
                            j = 0;
                        } else if (j < 3) {
                            j++;
                        }
                        submitcount++;
                    }
                    editText4.setText("");
                    edithint = "please input r[" + i + "]" + "[" + j + "]: ";
                    editText4.setHint(edithint);
                }
                break;
            case R.id.button_5:
                first_order(factor_number,level_number,r,kind);
                textView5.setText(String.valueOf(answer));
            default:
                break;
        }
    }

    public void first_order(int factor_number,int level_number,double[][] r,int kind)
    {
        //double answer = 0.0;
        First_order_fuzzy_decision A = new First_order_fuzzy_decision(factor_number,level_number,r,kind,mkind);
        answer = A.countscore();
    }
}

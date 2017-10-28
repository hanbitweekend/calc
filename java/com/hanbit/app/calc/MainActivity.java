package com.hanbit.app.calc;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText num1_et = findViewById(R.id.num1_et);
        final EditText num2_et = findViewById(R.id.num2_et);
        final TextView result_tv = findViewById(R.id.result_tv);
        final Context ctx = MainActivity.this;

        findViewById(R.id.plus_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sNum1 = num1_et.getText().toString();
                String sNum2 = num2_et.getText().toString();
                CalcBean b = new CalcBean();
                b.setNum1(sNum1);
                b.setNum2(sNum2);
                result = new Plus() {
                    @Override
                    public String execute(CalcBean numbers) {
                        return String.valueOf(Integer.parseInt(numbers.getNum1())
                                + Integer.parseInt(numbers.getNum2()));
                    }
                }.execute(b);


            }
        });
        findViewById(R.id.minus_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        findViewById(R.id.multi_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        findViewById(R.id.divide_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        findViewById(R.id.equal_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result_tv.setText("계산 결과: "+result);
            }
        });
    }
    private interface Plus{public String execute(CalcBean numbers); }
    private interface Minus{public String execute(CalcBean numbers); }
    private interface Multi{public String execute(CalcBean numbers); }
    private interface Divid{public String execute(CalcBean numbers); }
    private class CalcBean{
        private String num1;
        private String num2;

        public String getNum1() {
            return num1;
        }

        public void setNum1(String num1) {
            this.num1 = num1;
        }

        public String getNum2() {
            return num2;
        }

        public void setNum2(String num2) {
            this.num2 = num2;
        }
    }


}

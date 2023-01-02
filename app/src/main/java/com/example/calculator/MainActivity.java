package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btndot,btnequal,btnplus,btnminus,btndivide,btnmultiply,btn_c,btnmod,btn00,btn_bs;
    TextView tv;
    int k=0;// used to check whether the button is clicked or not
    int l=0;// used for backspace
    String op1,op2,oprt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.tv_calc);
        btn1=findViewById(R.id.btn_1);
        btn2=findViewById(R.id.btn_2);
        btn3=findViewById(R.id.btn_3);
        btn4=findViewById(R.id.btn_4);
        btn5=findViewById(R.id.btn_5);
        btn6=findViewById(R.id.btn_6);
        btn7=findViewById(R.id.btn_7);
        btn8=findViewById(R.id.btn_8);
        btn9=findViewById(R.id.btn_9);
        btn0=findViewById(R.id.btn_0);
        btn00=findViewById(R.id.btn_00);
        btn_c=findViewById(R.id.btn_C);
        btnmod=findViewById(R.id.btn_mod);
        btn_bs=findViewById(R.id.btn_backspace);
        btnplus=findViewById(R.id.btn_plus);
        btnminus=findViewById(R.id.btn_minus);
        btndivide=findViewById(R.id.btn_divide);
        btnmultiply=findViewById(R.id.btn_multiply);
        btnequal=findViewById(R.id.btn_equals);
        btndot=findViewById(R.id.btn_dot);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnplus.setOnClickListener(this);
        btnminus.setOnClickListener(this);
        btndivide.setOnClickListener(this);
        btnmultiply.setOnClickListener(this);
        btnequal.setOnClickListener(this);
        btndot.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btn00.setOnClickListener(this);
        btn_c.setOnClickListener(this);
        btnmod.setOnClickListener(this);
        btn_bs.setOnClickListener(this);
    }
    //calculation function
    void calc()
    {
        float x,y,z;
        x=Float.parseFloat(op1);
        y=Float.parseFloat(op2);
        if (oprt.equals("+"))
        {
            z=x+y;
        }
        else if (oprt.equals("-"))
        {
            z=x-y;
        }
        else if (oprt.equals("*"))
        {
            z=x*y;
        }
        else if (oprt.equals("%"))
        {
            z=x%y;
        }
        else
        {
            z=x/y;
        }
        tv.setText(""+z);

    }


    @Override
    public void onClick(View view) {
        try {
            Button b=(Button)view;
            if (b==btn1||b==btn2 ||b==btn3||b==btn4||b==btn5 ||b==btn6||b==btn7||b==btn8 ||b==btn9||b==btn0||b==btndot||b==btn00)
            {
                if (k==0)
                {
                    tv.setText(b.getText().toString());
                    k=1;
                }
                else
                {
                    tv.setText(tv.getText().toString()+b.getText().toString());

                }

            }
            if (b==btnplus||b==btnminus||b==btnmultiply||b==btndivide||b==btnmod)
            {

                op1=tv.getText().toString();
                oprt=b.getText().toString();
                k=0;

            }
            if (b==btn_c)
            {
                tv.setText("0");
                k=0;
            }
            if (b==btn_bs)
            {
                //check whether answer is there or not
                if(l==0)
                {
                    String str=tv.getText().toString();

                    if (str.length()>=1)
                    {
                        str=str.substring(0,str.length()-1);
                        tv.setText(str);
                    }
                    else
                    {
                        tv.setText("0");
                        k=0;
                    }
                }
                //user clicked on equals
                else
                {
                    Toast.makeText(this, "ANSWER CANT BE EDITED", Toast.LENGTH_SHORT).show();
                }

            }
            if(b==btnequal)
            {
                op2=tv.getText().toString();
                calc();
                l=1;

            }
        }
        catch (Exception e)
        {
            Toast.makeText(MainActivity.this, "ENTER VALUE OR PERFORM CALCULATION", Toast.LENGTH_SHORT).show();
        }

    }
}
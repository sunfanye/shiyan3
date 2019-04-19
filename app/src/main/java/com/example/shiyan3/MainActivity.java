package com.example.shiyan3;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @OnClick(R2.id.ac1_button6)
    public void ButterKnifemethod(){
        TextView textView=findViewById(R.id.ac1_text1);
        textView.setText("ButterKnife绑定");
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);//需要放在setContentview后面




        Button button_con=findViewById(R.id.ac1_button8);//跳转到获取系统信息页面
        button_con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Configuration_Activity.class);
                startActivity(intent);
            }
        });
        Button button_jdt=findViewById(R.id.ac1_button9);//跳转到进度条模拟页面
        button_jdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,jdt_Activity.class);
                startActivity(intent);
            }
        });

        Button button_Act;//activity监听，需要implements OnClickListener，实现onClick方法
        button_Act=findViewById(R.id.ac1_button1);
        button_Act.setOnClickListener(this);//监听器设置为this的自身类

        Button button_nemoinclass=findViewById(R.id.ac1_button2);
        button_nemoinclass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView=findViewById(R.id.ac1_text1);
                textView.setText("匿名内部类");

            }
        });

        Button button_inclass = findViewById(R.id.ac1_button4);
        inclass inclass_listener = new inclass();//new了内部类inclass方法
        button_inclass.setOnClickListener(inclass_listener);


        Button button_outclass=findViewById(R.id.ac1_button5);
        button_outclass.setOnClickListener(new MyButtonlistener("外部类作为事件监听类",(TextView) findViewById(R.id.ac1_text1)));




    }

    class inclass implements View.OnClickListener{//内部类方法
        @Override
        public void onClick(View v) {
            TextView textView=findViewById(R.id.ac1_text1);
            textView.setText("内部类");
        }
        }

        public  void labelmethod(View v)
        {//标签绑定，在该活动对应布局用android Onclick
        TextView textView=findViewById(R.id.ac1_text1);
        textView.setText("绑定到标签");
    }

    public void onClick(View v)
    {
        TextView textView=findViewById(R.id.ac1_text1);
        textView.setText("Activity监听");

    }
}

class MyButtonlistener extends AppCompatActivity implements View.OnClickListener {

    private String str;
    private TextView  textView1;
    public MyButtonlistener(String str,TextView textView){
        super();
        this.str=str;
        this.textView1=textView;
    }
    public void onClick (View v) {

        textView1.setText(str);

    }

}

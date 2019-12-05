package com.cyr.wen.view03_ukudemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView menu;
    private ImageView home;
    private RelativeLayout level1;
    private RelativeLayout level2;
    private RelativeLayout level3;

    //记录菜单的显示
    private boolean islevel1show = true;
    private boolean islevel2show = true;
    private boolean islevel3show = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initEvent();
    }

    /**
     * 初始化控件
     */
    private void initView() {
        setContentView(R.layout.activity_main);

        //menu菜单
        menu = (ImageView) findViewById(R.id.menu);
        //home菜单
        home = (ImageView) findViewById(R.id.home);

        //三层菜单
        level1 = (RelativeLayout) findViewById(R.id.level1);
        level2 = (RelativeLayout) findViewById(R.id.level2);
        level3 = (RelativeLayout) findViewById(R.id.level3);
    }


    /**
     * 初始化事件
     */
    private void initEvent() {
        menu.setOnClickListener(this);
        home.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.menu:
                level3();
                break;

            case R.id.home:
                level3and2();
                break;
        }
    }
    private void level3(){
        if (islevel1show) {  //关闭的动画
            level3close();
            Toast.makeText(this,"打开的动画",Toast.LENGTH_SHORT).show();
        } else {  //打开的动画
            level3show();
            Toast.makeText(this,"关闭的动画",Toast.LENGTH_SHORT).show();
        }
        // 改变标记
        islevel1show = !islevel1show;
    }


    //第三和第二层的动画
    private void level3and2() {
        //先判断第三层是否显示
        if (islevel1show) {
            //第三层显示,就同时关闭第三层和第二层
            level3close();
            level2close();
            islevel1show=!islevel1show;
            islevel2show=!islevel2show;
        } else {
            //第三层不显示,就再判断第二层是否显示
            if (islevel2show) {
                level2close();
                islevel2show=!islevel2show;
            } else {
                level2show();
                islevel2show=!islevel2show;
            }
        }
    }

    //第三层关闭的方法
    private void level3close() {
        RotateAnimation ra = new RotateAnimation(
                0, -180,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 1f
        );
        ra.setDuration(600);
        ra.setFillAfter(true);//设置动画结束停留在结束点

        level3.startAnimation(ra);
    }

    //第三层打开的方法
    private void level3show() {
        RotateAnimation ra = new RotateAnimation(
                -180, 0,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 1f
        );
        ra.setDuration(600);
        ra.setFillAfter(true);//设置动画结束停留在结束点

        level3.startAnimation(ra);
    }

    //第二层打开的方法
    private void level2close() {
        RotateAnimation ra = new RotateAnimation(
                0, -180,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 1f
        );
        ra.setDuration(700);
        ra.setFillAfter(true);//设置动画结束停留在结束点

        level2.startAnimation(ra);
    }

    //第二层关闭的方法
    private void level2show() {
        RotateAnimation ra = new RotateAnimation(
                -180, 0,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 1f
        );
        ra.setDuration(700);
        ra.setFillAfter(true);//设置动画结束停留在结束点

        level2.startAnimation(ra);

        //添加更改   View02
        RotateAnimation rbb = new RotateAnimation(
                -180, 0,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 1f
        );


        //添加更改   View02
        RotateAnimation rc = new RotateAnimation(
                -180, 0,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 1f
        );

        RotateAnimation rcd = new RotateAnimation(
                -180, 0,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 1f
        );

        RotateAnimation rce = new RotateAnimation(
                -180, 180,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 1f
        );
        RotateAnimation rce1 = new RotateAnimation(
                -180, 100,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 1f
        );

        //11cc

        //11b

        //22bb

        //33a
    }
}

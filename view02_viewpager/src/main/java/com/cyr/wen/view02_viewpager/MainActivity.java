package com.cyr.wen.view02_viewpager;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private View move_circle;

    private int flag=1000;

    private int[] imgs={
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViewPager();

        //无限轮播需要的条件1:设置一个比较大的起点
        vp.setCurrentItem(flag);

        //2秒后启动handler
        handler.postDelayed(runnable,2000);
    }

    //无限轮播需要的条件4:"自动轮播
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.arg1==1){
                //让viewpager的页面滚动
                flag+=1;
                vp.setCurrentItem(flag);
                //调用runnable线程
                handler.postDelayed(runnable,2000);
            }
        }
    };

    private Runnable runnable=new Runnable() {
        @Override
        public void run() {
            //调用Handler,实现无限循环
            Message msg=new Message();
            msg.arg1=1;
            handler.handleMessage(msg);
        }
    };

    private void initViewPager() {
        vp = (ViewPager) findViewById(R.id.vp);

        vp.setAdapter(new MyPagerAdapter());

        move_circle=findViewById(R.id.move_circle);

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                //根据vp的界面移动来控制红点的移动
                RelativeLayout.LayoutParams layoutParams= (RelativeLayout.LayoutParams) move_circle.getLayoutParams();
                //因为每个点的直径是10dp,点与点之间的距离是10dp,所有移动20dp
                layoutParams.setMarginStart(dip2px((position%5)*20));
                move_circle.setLayoutParams(layoutParams);

                //保存当前的position值,当用户移动之后就重写记录当前的值
                flag=position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private class MyPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            ////无限轮播需要的条件2:  设置一个特别大的长度
            //要达到无线轮播的效果,需要把长度设置的足够的大,这里设置为int的最大值
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView=new ImageView(MainActivity.this);
            //无限轮播需要的条件3: 限制资源取值为现有的资源数量
            //需要根据int的长度来获取有限的图片资源  position%5不管position的值是什么总能取到0,1,2,3,4
            imageView.setImageResource(imgs[position%5]);

//            //如果这里保存了position的位置
//            flag=position;
            container.addView(imageView);

            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((ImageView)object);
        }
    }


    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public int dip2px(float dpValue) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


}

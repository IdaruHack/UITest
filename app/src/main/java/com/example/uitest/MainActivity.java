package com.example.uitest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.ContactsContract;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LayoutInflater mLayoutInflater;
    LinearLayout mNumLayout;
    private ArrayList<View> mViewList = new ArrayList<View>();
    Button mPreSelectedBt;

    MyPagerAdapter mPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = (ImageView) findViewById(R.id.user_image);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,UserInformationActivity.class);
            }
        });
        mLayoutInflater = getLayoutInflater();

        mViewList.add(mLayoutInflater.inflate(R.layout.per_pager1, null));
        mViewList.add(mLayoutInflater.inflate(R.layout.per_pager2, null));
        mViewList.add(mLayoutInflater.inflate(R.layout.per_pager3, null));

        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        mPagerAdapter = new MyPagerAdapter();
        viewPager.setAdapter(mPagerAdapter);

        mNumLayout = (LinearLayout) findViewById(R.id.);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.icon_dot_normal);
        for (int i = 0; i < mViewList.size(); i++) {
            Button bt = new Button(this);
            bt.setLayoutParams(new ViewGroup.LayoutParams(bitmap.getWidth(),bitmap.getHeight()));
            bt.setBackgroundResource(R.drawable.icon_dot_normal);
            mNumLayout.addView(bt);
        }
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {

                if(mPreSelectedBt != null){
                    mPreSelectedBt.setBackgroundResource(R.drawable.icon_dot_normal);
                }

                Button currentBt = (Button)mNumLayout.getChildAt(position);
                currentBt.setBackgroundResource(R.drawable.home_page_dot_select);
                mPreSelectedBt = currentBt;

                //Log.i("INFO", "current item:"+position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });


    }
    public class MyPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return mViewList.size();
        }

        @Override
        public Object instantiateItem(View container, int position) {
            Log. i("INFO", "instantiate item:"+position);
            ((ViewPager) container).addView(mViewList.get(position),0);
            return mViewList .get(position);
        }

        @Override
        public void destroyItem(View container, int position, Object object) {
            Log.i("INFO", "destroy item:"+position);
            ((ViewPager) container).removeView( mViewList.get(position));
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }
    }

}

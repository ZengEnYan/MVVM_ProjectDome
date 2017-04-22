package com.MVVM.test.activity;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.MVVM.test.R;
import com.MVVM.test.bean.UserEntity;
import com.MVVM.test.databinding.ActivityMainBinding;
import com.MVVM.test.event.EventButton;

/**
 * 1.搭建环境,修改Build.gradle
 * 2.将Activity中的界面相关的内容,拆分到XML文件里,Activity只保留业务逻辑.
 * 3.修改XML文件布局
 * 4.定义控件的事件监听,方便UI和Java代码里的数据传递(Module 和View交互)
 * 5.使用特殊的格式加载布局,使布局和监听关联.
 */
public class MainActivity extends AppCompatActivity {

    private UserEntity mUserEntity;
    private EventButton mButton;
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mUserEntity = new UserEntity();
        mUserEntity.userName="YanZengEn";
        mUserEntity.passWord = "zengen";
//        mUserEntity.UserName.set("YanZengEn");
//        mUserEntity.PassWord.set("ZengEnYan");
        activityMainBinding.setUser(mUserEntity);

//        new Thread(){
//            @Override
//            public void run() {
//                SystemClock.sleep(3000);
//            mUserEntity.userName="闫增恩";
//                mUserEntity.UserName.set("闫增恩");
//                mUserEntity.PassWord.set("zengen");
//                activityMainBinding.setUser(mUserEntity);
//            }
//        }.start();

        mButton = new EventButton(mUserEntity);
        activityMainBinding.setEvent(mButton);

        mDialog = new ProgressDialog(this);
    }

    public void jump(View view) {
        mDialog.show();
       new Thread(){
           @Override
           public void run() {
               SystemClock.sleep(3000);
               runOnUiThread(new Runnable() {
                   @Override
                   public void run() {
                       mDialog.dismiss();
                       //成功后的吐丝
                       Toast.makeText(MainActivity.this, mUserEntity.userName+"\n"+mUserEntity.passWord, Toast.LENGTH_SHORT).show();
                   }
               });
           }
       }.start();
    }
}

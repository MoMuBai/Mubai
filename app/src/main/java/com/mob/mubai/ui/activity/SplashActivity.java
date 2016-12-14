package com.mob.mubai.ui.activity;

import android.content.Intent;
import android.os.Handler;
import android.widget.ImageView;

import com.mob.mubai.R;
import com.mob.mubai.base.BaseActivity;
import com.mob.mubai.base.service.UpdateService;
import com.mob.mubai.base.utils.AppUtils;
import com.mob.mubai.view.dialog.MyDialog;

import butterknife.Bind;

/**
 * Created by lzw on 2016/11/10.
 * 闪屏
 */

public class SplashActivity extends BaseActivity {


    @Bind(R.id.iv_splash)
    ImageView ivSplash;
    @Bind(R.id.iv_snack_bar)
    ImageView ivSnackBar;

    private MyDialog myDialog;

    @Override
    protected int getLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    if (AppUtils.checkIsUpdate()) {
                        showDialog();
                    } else {
                        startMain();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 2000);
    }

    private void showDialog(){
        MyDialog.Builder builder = new MyDialog.Builder(this,"是否更新");
        builder.setOkButton(s -> {
            Intent intent = new Intent(SplashActivity.this, UpdateService.class);
            intent.putExtra("appName", "MuBai");
            intent.putExtra("url", "");
            startService(intent);
        });
        builder.setNoButton(s -> {
           startMain();
        });
        myDialog = builder.create();
        myDialog.setCanceledOnTouchOutside(false);
        myDialog.show();
    }

    private void startMain(){
        startIntent(MainActivity.class);
        finish();
    }
}
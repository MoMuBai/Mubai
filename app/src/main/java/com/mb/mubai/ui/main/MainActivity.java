package com.mb.mubai.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatDelegate;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lzw.library.utils.AppManager;
import com.lzw.library.utils.AppUtil;
import com.lzw.library.utils.SPUtil;
import com.lzw.library.utils.SpUtils;
import com.lzw.library.utils.To;
import com.mb.mubai.R;
import com.mb.mubai.base.BaseActivity;
import com.mb.mubai.ui.test.activity.BannerActivity;
import com.mb.mubai.ui.test.activity.CallPhoneActivity;
import com.mb.mubai.ui.test.activity.DownListActivity;
import com.mb.mubai.ui.test.activity.ExpandableActivity;
import com.mb.mubai.ui.test.activity.PinnedHeadListActivity;
import com.mb.mubai.ui.test.activity.RecyclerActivity;
import com.mb.mubai.ui.test.activity.SeekBarActivity;
import com.mb.mubai.ui.test.activity.WebViewActivity;
import com.mb.mubai.ui.user.login.LoginActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * //////////////////////////////////////////////////////////////////////////////
 * //
 * //      ┏┛ ┻━━━━━┛ ┻┓
 * //      ┃　　　　　　 ┃
 * //      ┃　　　━　　　┃
 * //      ┃　┗┛　  ┗┛　┃
 * //      ┃　　　　　　 ┃
 * //      ┃　　　┻　　　┃               @Author  lzw
 * //      ┃　　　　　　 ┃
 * //      ┗━┓　　　┏━━━┛               @Date  2017/1/18
 * //        ┃　　　┃   神兽保佑
 * //        ┃　　　┃   代码无BUG！      @Desc
 * //        ┃　　　┗━━━━━━━━━┓
 * //        ┃　　　　　　　    ┣━━━┛
 * //        ┃　　　　         ┏┛
 * //        ┗━┓ ┓ ┏━━━┳ ┓ ┏━┛
 * //          ┃ ┫ ┫   ┃ ┫ ┫
 * //          ┗━┻━┛   ┗━┻━┛
 * //
 * /////////////////////////////////////////////////////////////////////////////
 */
public class MainActivity extends BaseActivity<MainPresenter, MainModel> implements MainContract.View {
    @Bind(R.id.navigation_view)
    NavigationView navigationView;
    @Bind(R.id.view_pager)
    ViewPager viewPager;
    @Bind(R.id.tab1)
    TextView tab1;
    @Bind(R.id.tab2)
    TextView tab2;
    @Bind(R.id.tab3)
    TextView tab3;
    @Bind(R.id.tab4)
    TextView tab4;
    @Bind(R.id.tab5)
    TextView tab5;
    @Bind(R.id.underLayout)
    LinearLayout underLayout;
    @Bind(R.id.iv_first)
    ImageView ivFirst;
    @Bind(R.id.tv_first)
    TextView tvFirst;
    @Bind(R.id.firstLayout)
    RelativeLayout firstLayout;
    private MainAdapter mainAdapter;
    private int backPressTimes;

    private boolean isFirst = true;

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(item -> {
            Intent intent = new Intent();
            switch (item.getGroupId()) {
                case R.id.g1:
                    intent.setClass(mActivity, SeekBarActivity.class);
                    startActivity(intent);
                    break;
                case R.id.g2:
                    intent.setClass(mActivity, LoginActivity.class);
                    startActivity(intent);
                    break;
                case R.id.g3:
                    intent.setClass(mActivity, ExpandableActivity.class);
                    startActivity(intent);
                    break;
                case R.id.g4:
                    intent.setClass(mActivity, BannerActivity.class);
                    startActivity(intent);
                    break;
                case R.id.g5:
                    intent.setClass(mActivity, RecyclerActivity.class);
                    startActivity(intent);
                    break;
                case R.id.g6:
                    intent.setClass(mActivity, PinnedHeadListActivity.class);
                    startActivity(intent);
                    break;
                case R.id.g7:
                    intent.setClass(mActivity, CallPhoneActivity.class);
                    startActivity(intent);
                    break;
                case R.id.g8:
                    intent.setClass(mActivity, DownListActivity.class);
                    startActivity(intent);
                    break;
                case R.id.g9:
                    intent.setClass(mActivity, WebViewActivity.class);
                    startActivity(intent);
                    break;
                default:
                    break;
            }
            return true;
        });
        isFirst = SpUtils.getSharedBooleanData(mContext, "isFirst");
        if (isFirst) {
            firstLayout.setVisibility(View.VISIBLE);
            tvFirst.setVisibility(View.VISIBLE);
            viewPager.setClickable(false);
            viewPager.setEnabled(false);
            underLayout.setClickable(false);
            underLayout.setEnabled(false);
        } else {
            firstLayout.setVisibility(View.GONE);
            tvFirst.setVisibility(View.GONE);
        }
    }


    @Override
    protected void initData() {
        initTab();
    }

    @Override
    public void showStart() {

    }

    @Override
    public void showNoData(String msg) {

    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void showStop() {

    }

    private void initTab() {
        mainAdapter = new MainAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mainAdapter);
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
    }

    /**
     * 点击返回键的事件
     */
    @Override
    public void onBackPressed() {
        if (backPressTimes == 0) {
            Toast.makeText(this, "再按一次退出应用", Toast.LENGTH_SHORT).show();
            backPressTimes = 1;
            new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        backPressTimes = 0;
                    }
                }
            }.start();
            return;
        } else {
            AppManager.getAppManager().finishAllActivity();
            Process.killProcess(Process.myPid());
        }
        super.onBackPressed();
    }


    @OnClick({R.id.tab1, R.id.tab2, R.id.tab3, R.id.tab4, R.id.tab5, R.id.iv_first})
    void onTabClick(View view) {
        switch (view.getId()) {
            case R.id.tab1:
                if (!AppUtil.isFastDoubleClick()) {
                    viewPager.setCurrentItem(0);
                } else {
                    Toast.makeText(mContext, "不能多次点击", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.tab2:
                viewPager.setCurrentItem(1);
                break;
            case R.id.tab3:
                viewPager.setCurrentItem(2);
                break;
            case R.id.tab4:
                viewPager.setCurrentItem(3);
                break;
            case R.id.tab5:
                break;
            case R.id.iv_first:
                firstLayout.setVisibility(View.GONE);
                viewPager.setClickable(true);
                viewPager.setEnabled(true);
                underLayout.setClickable(true);
                underLayout.setEnabled(true);
                tvFirst.setVisibility(View.GONE);
                SpUtils.setSharedBooleanData(mContext, "isFirst", false);
                break;
            default:
                break;
        }
    }
}

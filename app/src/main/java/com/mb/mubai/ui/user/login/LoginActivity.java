package com.mb.mubai.ui.user.login;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.widget.EditText;

import com.lzw.library.utils.L;
import com.lzw.library.utils.OkHttpClientUtil;
import com.lzw.library.utils.SpUtils;
import com.mb.mubai.App;
import com.mb.mubai.R;
import com.mb.mubai.base.BaseActivity;
import com.mb.mubai.base.BaseModel;
import com.mb.mubai.base.BasePresenter;
import com.squareup.okhttp.Request;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;


/**
 * //////////////////////////////////////////////////////////////////////////////
 * //
 * //      ┏┛ ┻━━━━━┛ ┻┓
 * //      ┃　　　　　　 ┃
 * //      ┃　　　━　　　┃
 * //      ┃　┗┛　  ┗┛　┃
 * //      ┃　　　　　　 ┃
 * //      ┃　　　┻　　　┃               @Author  林志文
 * //      ┃　　　　　　 ┃
 * //      ┗━┓　　　┏━━━┛               @Date  2016/11/7
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

public class LoginActivity extends BaseActivity {


    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.text_input_name)
    TextInputLayout textInputName;
    @BindView(R.id.et_pass)
    EditText etPass;
    @BindView(R.id.text_input_pass)
    TextInputLayout textInputPass;
    @BindView(R.id.float_btn)
    FloatingActionButton floatBtn;
    private String BASE_URL = "http://webim.demo.rong.io/";
    private String token;

    @Override
    protected BaseModel getModel() {
        return null;
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        textInputName.setHint("Name");
        textInputPass.setHint("Pass");
    }

    @Override
    protected void initData() {
        floatBtn.setOnClickListener(v -> {
            String userName = textInputName.getEditText().getText().toString();
            String passWord = textInputPass.getEditText().getText().toString();
            if (userName.length() <= 0 || passWord.length() <= 0) {
                Snackbar.make(floatBtn, "需要用户名和密码", Snackbar.LENGTH_SHORT)
                        .setAction("返回", v1 -> {
                            finish();
                        }).show();
            }
            if (userName.length() < 6) {
                textInputName.setError("用户名不能少于6位");
            } else {
                textInputName.setError("");
                myLogin();
            }
        });
    }


    /**
     * 用户登录，用户登录成功，获得 cookie，将cookie 保存
     */
    private void myLogin() {
        Map<String, String> requestParameter = new HashMap<String, String>();

        requestParameter.put("email", "yang115@qq.com");
        requestParameter.put("password", "123456");

        OkHttpClientUtil.postAsyn(BASE_URL + "email_login", new OkHttpClientUtil.ResultCallback<String>() {
            @Override
            public void onError(Request request, Exception e) {
                L.d(TAG, "e:" + e);
            }

            @Override
            public void onResponse(String response) {
                L.d(TAG, "onResponse() called with: response = [" + response + "]");
                getToken();
            }
        }, requestParameter);
    }

    /**
     * 获得token
     */
    private void getToken() {
        OkHttpClientUtil.getAsyn(BASE_URL + "token", new OkHttpClientUtil.ResultCallback<String>() {
            @Override
            public void onError(Request request, Exception e) {
                L.d(TAG, "e:" + e);
            }

            @Override
            public void onResponse(String response) {
                token = response;
                L.d(TAG, token);
                SpUtils.setSharedStringData(App.getInstance(), "token", "token");
            }
        });
    }

}

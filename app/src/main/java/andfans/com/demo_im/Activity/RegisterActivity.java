package andfans.com.demo_im.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import andfans.com.demo_im.R;
import andfans.com.demo_im.Utils.Util;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

/**
 * 注册Activity
 * Created by 兆鹏 on 2017/5/10.
 */
//TODO:需要添加一个可以跳转到登录界面的TextView，以防用户是注册了以后删除APP，又重新下载的情况
//@SuppressWarnings("deprecation")
public class RegisterActivity extends AppCompatActivity{
    @BindView(R.id.id_register_toolBar)
    protected Toolbar mToolBar;
    @BindView(R.id.id_register_toolbar_title)
    protected TextView mToolBarTitle;
    @BindView(R.id.id_register_username)
    protected EditText mUserName;
    @BindView(R.id.id_register_password)
    protected EditText mPassword;
    @BindView(R.id.id_register_confirm_password)
    protected EditText mConfirmPassword;
    @BindView(R.id.id_register_registerBt)
    protected Button mRegisterButton;
    @OnTextChanged(value = R.id.id_register_username, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void afterUserNameChanged() {
        checkTextChange();
    }

    @OnTextChanged(value = R.id.id_register_password, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void afterPasswordChanged() {
        checkTextChange();
    }

    @OnTextChanged(value = R.id.id_register_confirm_password, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void afterConfirmPasswordChanged() {
        checkTextChange();
    }

    @OnClick(R.id.id_register_registerBt)
    void registerButton(){
        // TODO: 2017/5/11 注册的逻辑，先检查服务器中是否已经存在相同用户名的用户，
        // TODO: 如果存在，则弹出一个Toast，如果不存在，再检查两次输入的密码是否一致，如果一致
        // TODO: 则注册到服务器，否则弹出一个Toast，还要在这里把用户的基本信息保存到SharePreference里面
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity_layout);
        setEvents();
    }
    //判断所有EditText里面的文字是否为符合标准
    private void checkTextChange(){
        if((!Util.isTextNull(mUserName))&&(!Util.isTextNull(mPassword))&&(!Util.isTextNull(mConfirmPassword))){
            mRegisterButton.setEnabled(true);
        }else {
            mRegisterButton.setEnabled(false);
        }
    }

    private void setEvents() {
        ButterKnife.bind(this);
        mToolBar.setTitle("");//使APP的名称不显示出来
        setSupportActionBar(mToolBar);
    }
}

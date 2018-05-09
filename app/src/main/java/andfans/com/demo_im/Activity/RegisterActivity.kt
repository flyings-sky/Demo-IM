package andfans.com.demo_im.Activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import andfans.com.demo_im.R
import andfans.com.demo_im.Utils.Util
import android.support.v7.widget.Toolbar
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.register_activity_layout.*

/**
 * 注册Activity
 * Created by 兆鹏 on 2017/5/10.
 */
//TODO:需要添加一个可以跳转到登录界面的TextView，以防用户是注册了以后删除APP，又重新下载的情况
//@SuppressWarnings("deprecation")
class RegisterActivity : AppCompatActivity() {
    //val mToolBar = findViewById(R.id.id_register_toolBar) as Toolbar
    val mUserName = findViewById(R.id.id_register_username) as EditText
    val mPassword = findViewById(R.id.id_register_password) as EditText
    val mConfirmPassword = findViewById(R.id.id_register_confirm_password) as EditText
    val mRegisterBt = findViewById(R.id.id_register_registerBt) as Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_activity_layout)
        setEvents()
    }

    //判断三个输入框的内容是否为空
    fun checkTextChange(){
        mRegisterBt?.isEnabled = (!Util.textIsNull(mUserName?.text.toString()))
                &&(!Util.textIsNull(mPassword?.text.toString()))
                &&(!Util.textIsNull(mConfirmPassword?.text.toString()))
    }

    fun setEvents(){
        //mToolBar.title = ""
        //setSupportActionBar(mToolBar)
        class EditTextWatcher:TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                checkTextChange()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        }
        val textWatcher:EditTextWatcher = EditTextWatcher()
        mUserName.addTextChangedListener(textWatcher)
        mPassword.addTextChangedListener(textWatcher)
        mConfirmPassword.addTextChangedListener(textWatcher)
    }
}

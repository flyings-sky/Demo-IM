package andfans.com.demo_im.Utils;

import android.view.View;
import android.widget.TextView;

/**
 * 工具类
 * Created by 兆鹏 on 2017/5/10.
 */

public class Util {
    public static final String TAG = "IM";
    public static final String PREFS_NAME = "UserInfo";
    //判断可以显示文本的View里面的Text是否为空
    public static <E extends TextView> boolean isTextNull(E object){
        if(object.getText().toString().trim().equals("")){
            return true;
        }else {
            return false;
        }

    }
}

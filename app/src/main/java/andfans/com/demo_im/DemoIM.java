package andfans.com.demo_im;

import android.app.Application;
import android.util.Log;

import com.avos.avoscloud.AVAnalytics;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVInstallation;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.SaveCallback;

/**
 *
 * Created by 兆鹏 on 2017/5/10.
 */

public class DemoIM extends Application {
    public static String installationId;
    @Override
    public void onCreate() {
        super.onCreate();
        AVOSCloud.initialize(this,"f3YcCH7JEdaBvWUXlsdQaIPO-gzGzoHsz","h7YBMSUuU6r7xYlaI6H4gvsQ");
        // 启用崩溃错误统计
        AVAnalytics.enableCrashReport(this.getApplicationContext(), true);
        //开启调试日志
        AVOSCloud.setDebugLogEnabled(true);
        //保存本机的Installation
        AVInstallation.getCurrentInstallation().saveInBackground(new SaveCallback() {
            @Override
            public void done(AVException e) {
                if(e == null){
                    installationId = AVInstallation.getCurrentInstallation().getInstallationId();
                }else {
                    Log.e("Click",e.getMessage());
                }
            }
        });

        // 设置默认打开的 Activity
        //PushService.setDefaultPushCallback(mContext, FriendsDetailsActivity.class);
        //PushService.subscribe(this,"NewFriend",NewFriendActivity.class);
    }
}

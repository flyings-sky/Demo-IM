package andfans.com.demo_im

import android.app.Application
import com.avos.avoscloud.AVAnalytics
import com.avos.avoscloud.AVOSCloud
/**
 *
 * Created by 兆鹏 on 2017/5/10.
 */

class DemoIM : Application() {
    override fun onCreate() {
        super.onCreate()
        AVOSCloud.initialize(this, "f3YcCH7JEdaBvWUXlsdQaIPO-gzGzoHsz", "h7YBMSUuU6r7xYlaI6H4gvsQ")
        // 启用崩溃错误统计
        AVAnalytics.enableCrashReport(this.applicationContext, true)
        //开启调试日志
        AVOSCloud.setDebugLogEnabled(true)
//        //保存本机的Installation
//        AVInstallation.getCurrentInstallation().saveInBackground(object : SaveCallback() {
//            override fun done(e: AVException?) {
//                if (e == null) {
//                    installationId = AVInstallation.getCurrentInstallation().installationId
//                } else {
//                    Log.e("Click", e.message)
//                }
//            }
//        })

        // 设置默认打开的 Activity
        //PushService.setDefaultPushCallback(mContext, FriendsDetailsActivity.class);
        //PushService.subscribe(this,"NewFriend",NewFriendActivity.class);
    }

//    companion object {
//        var installationId: String = ""
//    }
}

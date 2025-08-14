@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.coolOpenWeb
import android.app.Activity
import android.content.Intent
import android.net.Uri
import io.dcloud.uniapp.*
import io.dcloud.uniapp.extapi.*
import io.dcloud.uniapp.framework.*
import io.dcloud.uniapp.runtime.*
import io.dcloud.uniapp.vue.*
import io.dcloud.uniapp.vue.shared.*
import io.dcloud.uts.*
import io.dcloud.uts.Map
import io.dcloud.uts.Set
import io.dcloud.uts.UTSAndroid
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
fun openWeb(url: String): Boolean {
    try {
        if (url.trim() == "") {
            console.error("[cool-openurl] URL不能为空")
            return false
        }
        var trimmedUrl = url.trim()
        if (!trimmedUrl.startsWith("http://") && !trimmedUrl.startsWith("https://")) {
            console.error("[cool-openurl] URL必须包含协议头（http://或https://）")
            return false
        }
        var uri: Uri?
        try {
            uri = Uri.parse(trimmedUrl)
        }
         catch (e: Throwable) {
            console.error("[cool-openurl] URL格式无效：" + trimmedUrl, e)
            return false
        }
        if (uri == null) {
            console.error("[cool-openurl] URI解析失败：" + trimmedUrl)
            return false
        }
        var intent = Intent(Intent.ACTION_VIEW, uri)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        var activity = UTSAndroid.getUniActivity()
        if (activity == null) {
            console.error("[cool-openurl] 无法获取当前Activity实例")
            return false
        }
        var currentActivity = activity as Activity
        var packageManager = currentActivity.getPackageManager()
        var resolveInfos = packageManager.queryIntentActivities(intent, 0)
        if (resolveInfos.size == 0) {
            console.error("[cool-openurl] 系统中没有可以打开URL的应用")
            return false
        }
        currentActivity.startActivity(intent)
        console.log("[cool-openurl] 成功打开URL：" + trimmedUrl)
        return true
    }
     catch (error: Throwable) {
        console.error("[cool-openurl] 打开URL时发生异常：", error)
        return false
    }
}

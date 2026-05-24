package com.android.purebilibili.core.network.policy

private const val BILIBILI_API_HOST = "api.bilibili.com"
private const val WEB_HOME_FEED_PATH = "/x/web-interface/wbi/index/top/feed/rcmd"

object HomeFeedAnonymizerRuntime {
    @Volatile
    private var enabledValue: Boolean = false

    val enabled: Boolean
        get() = enabledValue

    fun setEnabled(enabled: Boolean) {
        enabledValue = enabled
    }
}

fun shouldClearHomeFeedCookies(
    pluginEnabled: Boolean,
    host: String,
    encodedPath: String
): Boolean {
    return pluginEnabled &&
        host == BILIBILI_API_HOST &&
        encodedPath == WEB_HOME_FEED_PATH
}

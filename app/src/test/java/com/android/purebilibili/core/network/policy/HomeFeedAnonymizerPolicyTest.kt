package com.android.purebilibili.core.network.policy

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class HomeFeedAnonymizerPolicyTest {

    @Test
    fun disabledPlugin_keepsHomeFeedCookies() {
        assertFalse(
            shouldClearHomeFeedCookies(
                pluginEnabled = false,
                host = "api.bilibili.com",
                encodedPath = "/x/web-interface/wbi/index/top/feed/rcmd"
            )
        )
    }

    @Test
    fun enabledPlugin_clearsWebHomeFeedCookies() {
        assertTrue(
            shouldClearHomeFeedCookies(
                pluginEnabled = true,
                host = "api.bilibili.com",
                encodedPath = "/x/web-interface/wbi/index/top/feed/rcmd"
            )
        )
    }

    @Test
    fun enabledPlugin_keepsCookiesForPlaybackDynamicUserAndMobileFeed() {
        val requests = listOf(
            "api.bilibili.com" to "/x/player/wbi/playurl",
            "api.bilibili.com" to "/x/polymer/web-dynamic/v1/feed/all",
            "api.bilibili.com" to "/x/web-interface/nav",
            "app.bilibili.com" to "/x/v2/feed/index"
        )

        requests.forEach { (host, encodedPath) ->
            assertFalse(
                shouldClearHomeFeedCookies(
                    pluginEnabled = true,
                    host = host,
                    encodedPath = encodedPath
                )
            )
        }
    }

    @Test
    fun enabledPlugin_keepsCookiesForNonApiHostAndSimilarPath() {
        val requests = listOf(
            "www.bilibili.com" to "/x/web-interface/wbi/index/top/feed/rcmd",
            "api.bilibili.com" to "/x/web-interface/wbi/index/top/feed/rcmd_extra",
            "api.bilibili.com" to "/x/web-interface/wbi/index/top/feed"
        )

        requests.forEach { (host, encodedPath) ->
            assertFalse(
                shouldClearHomeFeedCookies(
                    pluginEnabled = true,
                    host = host,
                    encodedPath = encodedPath
                )
            )
        }
    }
}

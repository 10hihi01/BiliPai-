package com.android.purebilibili.navigation3

import com.android.purebilibili.navigation.ScreenRoutes
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class BiliPaiNavKeyMappingPolicyTest {

    @Test
    fun topLevelRoutes_mapToNavigation3Keys() {
        assertEquals(BiliPaiNavKey.Home, legacyRouteToBiliPaiNavKey(ScreenRoutes.Home.route))
        assertEquals(BiliPaiNavKey.Dynamic, legacyRouteToBiliPaiNavKey(ScreenRoutes.Dynamic.route))
        assertEquals(BiliPaiNavKey.Search, legacyRouteToBiliPaiNavKey(ScreenRoutes.Search.route))
        assertEquals(BiliPaiNavKey.Profile, legacyRouteToBiliPaiNavKey(ScreenRoutes.Profile.route))
    }

    @Test
    fun videoRoute_preservesNavigationArguments() {
        val route = "video/BV1xx411c7mD?cid=123&cover=https%3A%2F%2Fexample.com%2Fcover.jpg" +
            "&startAudio=true&autoPortrait=true&fullscreen=true&resumePositionMs=456&commentRootRpid=789"

        val key = assertIs<BiliPaiNavKey.VideoDetail>(legacyRouteToBiliPaiNavKey(route))

        assertEquals("BV1xx411c7mD", key.bvid)
        assertEquals(123L, key.cid)
        assertEquals("https://example.com/cover.jpg", key.coverUrl)
        assertEquals(true, key.startAudio)
        assertEquals(true, key.autoPortrait)
        assertEquals(true, key.fullscreen)
        assertEquals(456L, key.resumePositionMs)
        assertEquals(789L, key.commentRootRpid)
    }

    @Test
    fun navKey_roundTripsToLegacyRouteForCurrentBridge() {
        val key = BiliPaiNavKey.Space(mid = 42L)

        assertEquals(ScreenRoutes.Space.createRoute(42L), key.toLegacyRoute())
        assertEquals(key, legacyRouteToBiliPaiNavKey(key.toLegacyRoute()))
    }

    @Test
    fun settingsSecondaryRoutes_mapToNavigation3Keys() {
        assertEquals(BiliPaiNavKey.OpenSourceLicenses, legacyRouteToBiliPaiNavKey(ScreenRoutes.OpenSourceLicenses.route))
        assertEquals(BiliPaiNavKey.AppearanceSettings, legacyRouteToBiliPaiNavKey(ScreenRoutes.AppearanceSettings.route))
        assertEquals(BiliPaiNavKey.IconSettings, legacyRouteToBiliPaiNavKey(ScreenRoutes.IconSettings.route))
        assertEquals(BiliPaiNavKey.AnimationSettings, legacyRouteToBiliPaiNavKey(ScreenRoutes.AnimationSettings.route))
        assertEquals(BiliPaiNavKey.PlaybackSettings, legacyRouteToBiliPaiNavKey(ScreenRoutes.PlaybackSettings.route))
        assertEquals(BiliPaiNavKey.PermissionSettings, legacyRouteToBiliPaiNavKey(ScreenRoutes.PermissionSettings.route))
        assertEquals(BiliPaiNavKey.PluginsSettings(), legacyRouteToBiliPaiNavKey(ScreenRoutes.PluginsSettings.createRoute()))
        val pluginImportRoute = "plugins_settings?importUrl=https%3A%2F%2Fexample.com%2Fa.bpplugin"
        assertEquals(
            BiliPaiNavKey.PluginsSettings(importUrl = "https://example.com/a.bpplugin"),
            legacyRouteToBiliPaiNavKey(pluginImportRoute)
        )
        assertEquals(BiliPaiNavKey.BottomBarSettings, legacyRouteToBiliPaiNavKey(ScreenRoutes.BottomBarSettings.route))
        assertEquals(BiliPaiNavKey.SettingsShare, legacyRouteToBiliPaiNavKey(ScreenRoutes.SettingsShare.route))
        assertEquals(BiliPaiNavKey.WebDavBackup, legacyRouteToBiliPaiNavKey(ScreenRoutes.WebDavBackup.route))
        assertEquals(BiliPaiNavKey.TipsSettings, legacyRouteToBiliPaiNavKey(ScreenRoutes.TipsSettings.route))
    }

    @Test
    fun liveSecondaryRoutes_mapToNavigation3Keys() {
        assertEquals(BiliPaiNavKey.LiveList, legacyRouteToBiliPaiNavKey(ScreenRoutes.LiveList.route))
        assertEquals(BiliPaiNavKey.LiveSearch, legacyRouteToBiliPaiNavKey(ScreenRoutes.LiveSearch.route))
        assertEquals(BiliPaiNavKey.LiveArea, legacyRouteToBiliPaiNavKey(ScreenRoutes.LiveArea.route))
        val liveAreaDetailRoute = "live_area_detail/1/2?title=%E7%BD%91%E6%B8%B8"
        assertEquals(
            BiliPaiNavKey.LiveAreaDetail(parentAreaId = 1, areaId = 2, title = "网游"),
            legacyRouteToBiliPaiNavKey(liveAreaDetailRoute)
        )
        assertEquals(BiliPaiNavKey.LiveFollowing, legacyRouteToBiliPaiNavKey(ScreenRoutes.LiveFollowing.route))
    }

    @Test
    fun messageRoutes_mapToNavigation3Keys() {
        assertEquals(BiliPaiNavKey.Inbox, legacyRouteToBiliPaiNavKey(ScreenRoutes.Inbox.route))
        assertEquals(BiliPaiNavKey.ReplyMe, legacyRouteToBiliPaiNavKey(ScreenRoutes.ReplyMe.route))
        assertEquals(BiliPaiNavKey.AtMe, legacyRouteToBiliPaiNavKey(ScreenRoutes.AtMe.route))
        assertEquals(BiliPaiNavKey.LikeMe, legacyRouteToBiliPaiNavKey(ScreenRoutes.LikeMe.route))
        assertEquals(BiliPaiNavKey.SystemNotice, legacyRouteToBiliPaiNavKey(ScreenRoutes.SystemNotice.route))
        assertEquals(
            BiliPaiNavKey.Chat(talkerId = 42L, sessionType = 1, userName = "测试用户"),
            legacyRouteToBiliPaiNavKey("chat/42/1?name=%E6%B5%8B%E8%AF%95%E7%94%A8%E6%88%B7")
        )
    }

    @Test
    fun cardReturnTargets_matchExistingSharedElementDestinations() {
        assertEquals(true, isCardReturnTargetNavKey(BiliPaiNavKey.Home))
        assertEquals(true, isCardReturnTargetNavKey(BiliPaiNavKey.Search))
        assertEquals(true, isCardReturnTargetNavKey(BiliPaiNavKey.Space(42L)))
        assertEquals(false, isCardReturnTargetNavKey(BiliPaiNavKey.VideoDetail("BV1")))
        assertEquals(false, isCardReturnTargetNavKey(BiliPaiNavKey.Settings))
    }
}

package com.android.purebilibili.navigation

import java.io.File
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class AppNavigationNavigation3BridgeStructureTest {

    @Test
    fun appNavigationMirrorsLegacyBackStackIntoNavigation3Keys() {
        val source = appNavigationSource()

        assertTrue(source.contains("navigation3BackStack"))
        assertTrue(source.contains("pushBiliPaiNavKey"))
        assertTrue(source.contains("popBiliPaiNavKey"))
        assertTrue(source.contains("legacyRouteToBiliPaiNavKey"))
    }

    @Test
    fun videoReturnRouteLayerUsesNavigation3MotionDecision() {
        val source = navigation3Source()

        assertTrue(source.contains("resolveBiliPaiNavMotionDecision"))
        assertTrue(source.contains("BiliPaiNavRouteTransition.NO_OP_SHARED_ELEMENT"))
        assertTrue(source.contains("shouldInterceptSystemBackForNavigation3"))
    }

    @Test
    fun appNavigationMirrorsReturnStateIntoNavigation3SessionBeforeLegacyFallback() {
        val source = appNavigationSource()

        assertTrue(source.contains("BiliPaiReturnSessionState"))
        assertTrue(source.contains("navigation3ReturnSession"))
        assertTrue(source.contains("resolveBiliPaiNavSourceMetadata"))
        assertTrue(source.contains("navigation3ReturnSession.markReturning"))
        assertTrue(source.contains("navigation3ReturnSession.isQuickReturnFromDetail"))
        assertFalse(source.contains("isQuickReturnFromDetail = CardPositionManager.isQuickReturnFromDetail"))
    }

    @Test
    fun cardPositionManagerKeepsOnlyGeometryFallbackState() {
        val source = productionSourceExceptCardPositionManager()

        assertFalse(source.contains("CardPositionManager.isReturningFromDetail"))
        assertFalse(source.contains("CardPositionManager.isQuickReturnFromDetail"))
        assertFalse(source.contains("CardPositionManager.lastVideoSourceRoute"))
        assertFalse(source.contains("CardPositionManager.shouldLimitSharedElementsForQuickReturn()"))
        assertFalse(source.contains("CardPositionManager.markReturning()"))
        assertFalse(source.contains("CardPositionManager.clearReturning()"))
        assertFalse(source.contains("CardPositionManager.recordVideoSourceRoute("))
    }

    @Test
    fun appNavigationUsesNavDisplayAsSingleMainChain() {
        val source = appNavigationSource()
        val buildFile = appBuildGradleSource()

        assertTrue(source.contains("BiliPaiNavDisplayHost("))
        assertTrue(source.contains("sharedTransitionScope = LocalSharedTransitionScope.current"))
        assertTrue(source.contains("resolveBiliPaiNavEntryContentRole"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.HOME ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.DYNAMIC ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.SEARCH ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.PROFILE ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.VIDEO_DETAIL ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.HISTORY ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.SETTINGS ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.WATCH_LATER ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.FAVORITE ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.LOGIN ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.STORY ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.PARTITION ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.CATEGORY ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.SPACE ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.WEB ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.DYNAMIC_DETAIL ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.ARTICLE_DETAIL ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.LIVE ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.BANGUMI_DETAIL ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.LIVE_LIST ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.LIVE_SEARCH ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.LIVE_AREA ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.LIVE_AREA_DETAIL ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.LIVE_FOLLOWING ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.INBOX ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.REPLY_ME ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.AT_ME ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.LIKE_ME ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.SYSTEM_NOTICE ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.CHAT ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.AUDIO_MODE ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.ONBOARDING ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.FOLLOWING ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.DOWNLOAD_LIST ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.OFFLINE_VIDEO_PLAYER ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.SEARCH_TRENDING ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.TOPIC_DETAIL ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.SEASON_SERIES_DETAIL ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.BANGUMI ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.BANGUMI_PLAYER ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.MUSIC_DETAIL ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.NATIVE_MUSIC ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.OPEN_SOURCE_LICENSES ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.APPEARANCE_SETTINGS ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.ICON_SETTINGS ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.ANIMATION_SETTINGS ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.PLAYBACK_SETTINGS ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.PERMISSION_SETTINGS ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.PLUGINS_SETTINGS ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.BOTTOM_BAR_SETTINGS ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.SETTINGS_SHARE ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.WEB_DAV_BACKUP ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.TIPS_SETTINGS ->"))
        assertTrue(source.contains("onBack = { performSystemBackAction() }"))
        assertFalse(source.contains("shouldUseBiliPaiNavDisplayMainChain()"))
        assertFalse(source.contains("DEFERRED_LEGACY_ROUTE"))
        assertFalse(source.contains("NavHost("))
        assertFalse(buildFile.contains("navigation-compose"))
    }

    private fun appNavigationSource(): String {
        return listOf(
            File("app/src/main/java/com/android/purebilibili/navigation/AppNavigation.kt"),
            File("src/main/java/com/android/purebilibili/navigation/AppNavigation.kt")
        ).first { it.exists() }.readText()
    }

    private fun appBuildGradleSource(): String {
        return listOf(
            File("app/build.gradle.kts"),
            File("build.gradle.kts")
        ).first { it.exists() }.readText()
    }

    private fun productionSourceExceptCardPositionManager(): String {
        val root = listOf(
            File("app/src/main/java"),
            File("src/main/java")
        ).first { it.exists() }

        return root
            .walkTopDown()
            .filter { it.isFile && it.extension == "kt" && it.name != "CardPositionManager.kt" }
            .joinToString(separator = "\n") { it.readText() }
    }

    private fun navigation3Source(): String {
        val root = listOf(
            File("app/src/main/java/com/android/purebilibili/navigation3"),
            File("src/main/java/com/android/purebilibili/navigation3")
        ).first { it.exists() }

        return root
            .walkTopDown()
            .filter { it.isFile && it.extension == "kt" }
            .joinToString(separator = "\n") { it.readText() }
    }
}

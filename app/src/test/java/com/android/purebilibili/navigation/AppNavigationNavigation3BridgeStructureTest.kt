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
        assertTrue(source.contains("resolveBiliPaiNavKeyForLegacyBackStackEntry"))
        assertTrue(source.contains("pushBiliPaiNavKey"))
        assertTrue(source.contains("popBiliPaiNavKey"))
    }

    @Test
    fun videoReturnRouteLayerUsesNavigation3MotionDecision() {
        val source = appNavigationSource()

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
    fun appNavigationUsesNavDisplayAsSingleMainChain() {
        val source = appNavigationSource()

        assertTrue(source.contains("BiliPaiNavDisplayHost("))
        assertTrue(source.contains("sharedTransitionScope = LocalSharedTransitionScope.current"))
        assertTrue(source.contains("resolveBiliPaiNavEntryContentRole"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.HOME ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.HISTORY ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.SETTINGS ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.WATCH_LATER ->"))
        assertTrue(source.contains("BiliPaiNavEntryContentRole.FAVORITE ->"))
        assertTrue(source.contains("onBack = { performSystemBackAction() }"))
        assertFalse(source.contains("shouldUseBiliPaiNavDisplayMainChain()"))
        assertFalse(source.contains("else NavHost("))
    }

    private fun appNavigationSource(): String {
        return listOf(
            File("app/src/main/java/com/android/purebilibili/navigation/AppNavigation.kt"),
            File("src/main/java/com/android/purebilibili/navigation/AppNavigation.kt")
        ).first { it.exists() }.readText()
    }
}

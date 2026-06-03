package com.android.purebilibili.feature.video.ui.components

import java.io.File
import kotlin.test.Test
import kotlin.test.assertTrue

class BottomInputBarStructureTest {

    @Test
    fun bottomInputBar_usesLiquidGlassWithFallback() {
        val source = File("src/main/java/com/android/purebilibili/feature/video/ui/components/BottomInputBar.kt")
            .readText()

        assertTrue(source.contains("hazeState: HazeState? = null"))
        assertTrue(source.contains("glassScrollOffsetProvider: () -> Float = { 0f }"))
        assertTrue(source.contains("Modifier.unifiedBlur("))
        assertTrue(source.contains("liquidGlassBackground("))
        assertTrue(source.contains("Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU"))
        assertTrue(source.contains("fallbackGlassSurfaceColor"))
    }
}

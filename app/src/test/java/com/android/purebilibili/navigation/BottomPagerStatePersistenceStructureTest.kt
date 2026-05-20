package com.android.purebilibili.navigation

import java.io.File
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BottomPagerStatePersistenceStructureTest {

    @Test
    fun `bottom tabs no longer depend on local pager state holder`() {
        val source = loadSource("app/src/main/java/com/android/purebilibili/navigation/AppNavigation.kt")

        assertTrue(source.contains("BiliPaiNavDisplayHost("))
        assertFalse(source.contains("bottomPagerSaveableStateHolder.SaveableStateProvider("))
        assertFalse(source.contains("rememberSaveableStateHolder()"))
        assertFalse(source.contains("HorizontalPager("))
        assertFalse(source.contains("VerticalPager("))
    }

    private fun loadSource(path: String): String {
        val normalizedPath = path.removePrefix("app/")
        val sourceFile = listOf(
            File(path),
            File(normalizedPath)
        ).firstOrNull { it.exists() }
        require(sourceFile != null) { "Cannot locate $path from ${File(".").absolutePath}" }
        return sourceFile.readText()
    }
}

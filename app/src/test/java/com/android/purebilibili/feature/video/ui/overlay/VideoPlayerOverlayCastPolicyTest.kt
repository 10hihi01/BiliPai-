package com.android.purebilibili.feature.video.ui.overlay

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class VideoPlayerOverlayCastPolicyTest {

    @Test
    fun releasesCastBindingWhenDialogCloses() {
        assertTrue(
            shouldReleaseCastBindingAfterDialogVisibilityChange(
                previousVisible = true,
                currentVisible = false
            )
        )
    }

    // --- cast dialog dismissal timing ---

    @Test
    fun shouldDismissCastDialogImmediatelyOnUrlFailure() {
        // URL is null → dismiss before cast attempt
        assertTrue(shouldDismissCastDialogOnUrlFailure(null))
    }

    @Test
    fun shouldDismissCastDialogImmediatelyOnBlankUrl() {
        // blank URL counts as failure → dismiss
        assertTrue(shouldDismissCastDialogOnUrlFailure(""))
        assertTrue(shouldDismissCastDialogOnUrlFailure("   "))
    }

    @Test
    fun shouldNotDismissCastDialogWhenUrlResolved() {
        // URL is resolved → keep dialog open for plugin.cast to use the route
        assertFalse(shouldDismissCastDialogOnUrlFailure("https://example.com/video.mp4"))
        assertFalse(shouldDismissCastDialogOnUrlFailure("http://127.0.0.1:8901/proxy"))
    }

    @Test
    fun keepsCastBindingForAllOtherVisibilityTransitions() {
        assertFalse(
            shouldReleaseCastBindingAfterDialogVisibilityChange(
                previousVisible = false,
                currentVisible = false
            )
        )
        assertFalse(
            shouldReleaseCastBindingAfterDialogVisibilityChange(
                previousVisible = false,
                currentVisible = true
            )
        )
        assertFalse(
            shouldReleaseCastBindingAfterDialogVisibilityChange(
                previousVisible = true,
                currentVisible = true
            )
        )
    }
}

package com.android.purebilibili.feature.plugin

import com.android.purebilibili.core.network.policy.HomeFeedAnonymizerRuntime
import com.android.purebilibili.core.plugin.PluginCapability
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class HomeFeedAnonymizerPluginTest {

    @Test
    fun plugin_declaresMetadataAndCapabilities() {
        val plugin = HomeFeedAnonymizerPlugin()

        assertEquals(HOME_FEED_ANONYMIZER_PLUGIN_ID, plugin.id)
        assertEquals("初见推荐", plugin.name)
        assertEquals("BiliPai项目组", plugin.author)
        assertFalse(plugin.unavailable)
        assertEquals(
            setOf(
                PluginCapability.RECOMMENDATION_CANDIDATES,
                PluginCapability.NETWORK
            ),
            plugin.capabilityManifest.capabilities
        )
    }

    @Test
    fun plugin_enableAndDisable_updatesRuntimeState() = runTest {
        val plugin = HomeFeedAnonymizerPlugin()
        HomeFeedAnonymizerRuntime.setEnabled(false)

        plugin.onEnable()
        assertTrue(HomeFeedAnonymizerRuntime.enabled)

        plugin.onDisable()
        assertFalse(HomeFeedAnonymizerRuntime.enabled)
    }
}

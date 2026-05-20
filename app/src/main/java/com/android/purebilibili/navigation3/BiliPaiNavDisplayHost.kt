package com.android.purebilibili.navigation3

import androidx.activity.compose.BackHandler
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.ui.LocalNavAnimatedContentScope
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.android.purebilibili.core.ui.ProvideAnimatedVisibilityScope

@Composable
internal fun BiliPaiNavDisplayHost(
    backStack: List<BiliPaiNavKey>,
    motionMode: BiliPaiNavMotionMode,
    sourceMetadata: BiliPaiNavSourceMetadata,
    onBack: () -> Unit,
    modifier: Modifier = Modifier,
    sharedTransitionScope: SharedTransitionScope? = null,
    content: @Composable (BiliPaiNavKey) -> Unit
) {
    val safeBackStack = remember(backStack) {
        backStack.ifEmpty { listOf(BiliPaiNavKey.Home) }
    }
    val scopedContent: @Composable (BiliPaiNavKey) -> Unit = remember(content) {
        { key ->
            ProvideAnimatedVisibilityScope(
                animatedVisibilityScope = LocalNavAnimatedContentScope.current
            ) {
                content(key)
            }
        }
    }
    val entryProvider = remember(sourceMetadata, scopedContent) {
        biliPaiNavEntryProvider(
            sourceMetadata = sourceMetadata,
            content = scopedContent
        )
    }

    NavDisplay(
        backStack = safeBackStack,
        modifier = modifier,
        onBack = onBack,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        sharedTransitionScope = sharedTransitionScope,
        transitionSpec = {
            resolveBiliPaiNavContentTransform(BiliPaiNavRouteTransition.FALLBACK)
        },
        popTransitionSpec = {
            resolveBiliPaiNavContentTransform(BiliPaiNavRouteTransition.FALLBACK)
        },
        predictivePopTransitionSpec = {
            val transition = if (shouldUseNavigation3PredictivePop(motionMode)) {
                BiliPaiNavRouteTransition.PREDICTIVE_PROGRESS
            } else {
                BiliPaiNavRouteTransition.CLASSIC_CARD
            }
            resolveBiliPaiNavContentTransform(transition)
        },
        entryProvider = entryProvider
    )

    BackHandler(
        enabled = shouldInterceptSystemBackForNavigation3(
            mode = motionMode,
            appBackActionRequiresInterception = false
        ),
        onBack = onBack
    )
}

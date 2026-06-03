package com.android.purebilibili.feature.video.ui.components

import android.os.Build
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.purebilibili.core.ui.adaptive.MotionTier
import com.android.purebilibili.core.ui.blur.BlurSurfaceType
import com.android.purebilibili.core.ui.blur.unifiedBlur
import com.android.purebilibili.core.ui.effect.liquidGlassBackground
import com.android.purebilibili.core.ui.rememberAppBookmarkIcon
import com.android.purebilibili.core.ui.rememberAppCoinIcon
import com.android.purebilibili.core.ui.rememberAppLikeFilledIcon
import com.android.purebilibili.core.ui.rememberAppLikeIcon
import com.android.purebilibili.core.ui.rememberAppShareIcon
import dev.chrisbanes.haze.HazeState

@Composable
fun BottomInputBar(
    modifier: Modifier = Modifier,
    isLiked: Boolean,
    isFavorited: Boolean,
    isCoined: Boolean,
    onLikeClick: () -> Unit,
    onFavoriteClick: () -> Unit,
    onCoinClick: () -> Unit,
    onShareClick: () -> Unit,
    onCommentClick: () -> Unit,
    hazeState: HazeState? = null,
    glassScrollOffsetProvider: () -> Float = { 0f },
) {
    val favoriteIcon = rememberAppBookmarkIcon()
    val coinIcon = rememberAppCoinIcon()
    val likeIcon = rememberAppLikeIcon()
    val likeFilledIcon = rememberAppLikeFilledIcon()
    val shareIcon = rememberAppShareIcon()
    val glassShape: CornerBasedShape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
    val glassSurfaceColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.62f)
    val fallbackGlassSurfaceColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.9f)
    val surfaceModifier = if (hazeState != null) {
        val blurModifier = Modifier.unifiedBlur(
            hazeState = hazeState,
            shape = glassShape,
            surfaceType = BlurSurfaceType.BOTTOM_BAR,
            motionTier = MotionTier.Normal
        )
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            blurModifier.liquidGlassBackground(
                refractIntensity = 0.08f,
                scrollOffsetProvider = glassScrollOffsetProvider,
                backgroundColor = glassSurfaceColor
            )
        } else {
            blurModifier.background(fallbackGlassSurfaceColor, glassShape)
        }
    } else {
        Modifier
    }

    Surface(
        color = if (hazeState != null) Color.Transparent else MaterialTheme.colorScheme.surface,
        shape = if (hazeState != null) glassShape else RoundedCornerShape(0.dp),
        border = if (hazeState != null) {
            BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.32f))
        } else {
            null
        },
        tonalElevation = 8.dp,
        shadowElevation = 8.dp,
        modifier = modifier
            .fillMaxWidth()
            .then(surfaceModifier)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .navigationBarsPadding(), // fit system windows
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Input Field Placeholder
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(36.dp)
                    .clip(RoundedCornerShape(18.dp))
                    .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
                    .clickable { onCommentClick() }
                    .padding(horizontal = 12.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = "评论 UP 主和大家...",
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontSize = 14.sp
                )
            }
            
            Spacer(modifier = Modifier.width(16.dp))
            
            // Actions
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Like
                IconActionButton(
                    icon = if (isLiked) likeFilledIcon else likeIcon,
                    label = "点赞",
                    tint = if (isLiked) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
                    onClick = onLikeClick,
                    showLabel = false
                )
                
                // Coin
                IconActionButton(
                    icon = coinIcon,
                    label = "投币",
                    tint = if (isCoined) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
                    onClick = onCoinClick,
                    showLabel = false
                )

                // Favorite
                IconActionButton(
                    icon = favoriteIcon,
                    label = "收藏",
                    tint = if (isFavorited) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
                    onClick = onFavoriteClick,
                    showLabel = false
                )
                
                // Share
                IconActionButton(
                    icon = shareIcon,
                    label = "分享",
                    tint = MaterialTheme.colorScheme.onSurface,
                    onClick = onShareClick,
                    showLabel = false
                )
            }
        }
    }
}

@Composable
private fun IconActionButton(
    icon: ImageVector,
    label: String,
    tint: Color,
    onClick: () -> Unit,
    showLabel: Boolean = false
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable(onClick = onClick).padding(4.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = tint,
            modifier = Modifier.size(24.dp)
        )
        if (showLabel) {
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = label,
                fontSize = 10.sp,
                color = tint
            )
        }
    }
}

package com.android.purebilibili.feature.settings

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Article
import androidx.compose.material.icons.outlined.AutoAwesome
import androidx.compose.material.icons.outlined.Backup
import androidx.compose.material.icons.outlined.Block
import androidx.compose.material.icons.outlined.BugReport
import androidx.compose.material.icons.outlined.CardGiftcard
import androidx.compose.material.icons.outlined.ChatBubbleOutline
import androidx.compose.material.icons.outlined.DeleteOutline
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material.icons.outlined.Extension
import androidx.compose.material.icons.outlined.Feed
import androidx.compose.material.icons.outlined.Folder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Lightbulb
import androidx.compose.material.icons.outlined.Link
import androidx.compose.material.icons.outlined.OpenInNew
import androidx.compose.material.icons.outlined.Palette
import androidx.compose.material.icons.outlined.PlayCircle
import androidx.compose.material.icons.outlined.Replay
import androidx.compose.material.icons.outlined.Security
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.Terminal
import androidx.compose.material.icons.outlined.TouchApp
import androidx.compose.material.icons.outlined.Update
import androidx.compose.material.icons.outlined.WarningAmber
import androidx.compose.material.icons.outlined.Widgets
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector
import com.android.purebilibili.core.theme.LocalUiPreset
import com.android.purebilibili.core.theme.UiPreset
import io.github.alexzhirkevich.cupertino.icons.CupertinoIcons
import io.github.alexzhirkevich.cupertino.icons.outlined.ArrowCounterclockwise
import io.github.alexzhirkevich.cupertino.icons.outlined.ArrowLeftArrowRight
import io.github.alexzhirkevich.cupertino.icons.outlined.ArrowTriangle2Circlepath
import io.github.alexzhirkevich.cupertino.icons.outlined.BellBadge
import io.github.alexzhirkevich.cupertino.icons.outlined.Bolt
import io.github.alexzhirkevich.cupertino.icons.outlined.Camera
import io.github.alexzhirkevich.cupertino.icons.outlined.ChartBar
import io.github.alexzhirkevich.cupertino.icons.outlined.Clock
import io.github.alexzhirkevich.cupertino.icons.outlined.DocOnDoc
import io.github.alexzhirkevich.cupertino.icons.outlined.DocText
import io.github.alexzhirkevich.cupertino.icons.outlined.EyeSlash
import io.github.alexzhirkevich.cupertino.icons.outlined.ExclamationmarkTriangle
import io.github.alexzhirkevich.cupertino.icons.outlined.Folder
import io.github.alexzhirkevich.cupertino.icons.outlined.Gift
import io.github.alexzhirkevich.cupertino.icons.outlined.HandTap
import io.github.alexzhirkevich.cupertino.icons.outlined.House
import io.github.alexzhirkevich.cupertino.icons.outlined.InfoCircle
import io.github.alexzhirkevich.cupertino.icons.outlined.Lightbulb
import io.github.alexzhirkevich.cupertino.icons.outlined.Link
import io.github.alexzhirkevich.cupertino.icons.outlined.ListBullet
import io.github.alexzhirkevich.cupertino.icons.outlined.Lock
import io.github.alexzhirkevich.cupertino.icons.outlined.Newspaper
import io.github.alexzhirkevich.cupertino.icons.outlined.PaintbrushPointed
import io.github.alexzhirkevich.cupertino.icons.outlined.PlayCircle
import io.github.alexzhirkevich.cupertino.icons.outlined.PuzzlepieceExtension
import io.github.alexzhirkevich.cupertino.icons.outlined.RectangleStack
import io.github.alexzhirkevich.cupertino.icons.outlined.Sparkles
import io.github.alexzhirkevich.cupertino.icons.outlined.SquareAndArrowUp
import io.github.alexzhirkevich.cupertino.icons.outlined.SquareStack3dUp
import io.github.alexzhirkevich.cupertino.icons.outlined.Tag
import io.github.alexzhirkevich.cupertino.icons.outlined.Terminal
import io.github.alexzhirkevich.cupertino.icons.outlined.TextBubble
import io.github.alexzhirkevich.cupertino.icons.outlined.Trash
import io.github.alexzhirkevich.cupertino.icons.outlined.WandAndStars
import io.github.alexzhirkevich.cupertino.icons.outlined.XmarkCircle

internal enum class SettingsIconRole {
    INTERFACE_THEME,
    HOME_FEED,
    NAVIGATION,
    PLAYBACK_QUALITY,
    FULLSCREEN_GESTURE,
    INTERACTION_COMMENT,
    DATA_BACKUP,
    PRIVACY_PERMISSION,
    DIAGNOSTICS,
    ABOUT_SUPPORT,
    APPEARANCE,
    ANIMATION,
    PLAYBACK,
    BOTTOM_BAR,
    PERMISSION,
    BLOCKED_LIST,
    SETTINGS_SHARE,
    WEBDAV_BACKUP,
    DOWNLOAD_PATH,
    IMAGE_SAVE_PATH,
    CLEAR_CACHE,
    PLUGINS,
    EXPORT_LOGS,
    OPEN_SOURCE_LICENSES,
    OPEN_SOURCE_HOME,
    CHECK_UPDATE,
    VIEW_RELEASE_NOTES,
    REPLAY_ONBOARDING,
    TIPS,
    OPEN_LINKS,
    DONATE,
    DISCLAIMER,
    RELEASE_CHANNEL,
    CRASH_TRACKING,
    ANALYTICS,
    FEED_API,
    REFRESH_COUNT,
    DYNAMIC_PREVIEW_TEXT,
    DYNAMIC_TAB_VISIBILITY,
    EASTER_EGG,
    AUTO_CHECK_UPDATE,
    BUILD_SOURCE,
    BUILD_FINGERPRINT,
    BUILD_VERIFICATION,
    ANDROID_LIQUID_GLASS,
    DYNAMIC_COLOR,
    COLOR_STYLE,
    COLOR_SPEC,
    APP_LANGUAGE,
    FONT_FILE,
    SPLASH_WALLPAPER,
    RANDOM_WALLPAPER,
    DISPLAY_STYLE,
    HOME_COVER_GLASS,
    VIDEO_DURATION_BADGES,
    HOME_INFO_GLASS,
    HOME_WALLPAPER,
    WALLPAPER_EFFECT,
    HOME_UP_BADGES,
    ONLINE_COUNT,
    GRID_COLUMNS,
    HOME_CARD_WIDTH,
    CARD_ENTRANCE_ANIMATION,
    CARD_TRANSITION_ANIMATION,
    PREDICTIVE_BACK,
    BOTTOM_BAR_GLASS,
    TOP_BAR_BLUR,
    BOTTOM_BAR_BLUR,
    FLOATING_BOTTOM_BAR,
    HARDWARE_DECODER,
    PLAYBACK_SPEED,
    STOP_ON_EXIT,
    BACKGROUND_PLAYBACK,
    AUDIO_FOCUS,
    PIP_DANMAKU,
    AUDIO_MODE_PIP,
    PLAYER_DIAGNOSTICS,
    QUALITY_WARNING,
    SUBTITLE,
    COMMENT_DECORATION,
    AI_SUMMARY,
    LIKE_INTERACTION,
    VIDEO_DESCRIPTION,
    FULLSCREEN_ORIENTATION,
    HORIZONTAL_ADAPTATION,
    FULLSCREEN_GESTURE_REVERSE,
    HIDE_STATUS_BAR,
    AUTO_ENTER_FULLSCREEN,
    AUTO_EXIT_FULLSCREEN,
    FULLSCREEN_LOCK,
    FULLSCREEN_SCREENSHOT,
    CLEAN_SCREENSHOT,
    BATTERY_STATUS,
    TIME_STATUS,
    PLAYER_ACTIONS
}

@Composable
internal fun rememberSettingsSemanticIcon(
    role: SettingsIconRole,
    uiPreset: UiPreset = LocalUiPreset.current
): ImageVector = remember(role, uiPreset) {
    resolveSettingsSemanticIcon(role, uiPreset)
}

internal fun resolveSettingsSearchTargetIconRole(
    target: SettingsSearchTarget
): SettingsIconRole = when (target) {
    SettingsSearchTarget.INTERFACE_THEME -> SettingsIconRole.INTERFACE_THEME
    SettingsSearchTarget.HOME_FEED -> SettingsIconRole.HOME_FEED
    SettingsSearchTarget.NAVIGATION -> SettingsIconRole.NAVIGATION
    SettingsSearchTarget.PLAYBACK_QUALITY -> SettingsIconRole.PLAYBACK_QUALITY
    SettingsSearchTarget.FULLSCREEN_GESTURE -> SettingsIconRole.FULLSCREEN_GESTURE
    SettingsSearchTarget.INTERACTION_COMMENT -> SettingsIconRole.INTERACTION_COMMENT
    SettingsSearchTarget.DATA_BACKUP -> SettingsIconRole.DATA_BACKUP
    SettingsSearchTarget.PRIVACY_PERMISSION -> SettingsIconRole.PRIVACY_PERMISSION
    SettingsSearchTarget.DIAGNOSTICS -> SettingsIconRole.DIAGNOSTICS
    SettingsSearchTarget.ABOUT_SUPPORT -> SettingsIconRole.ABOUT_SUPPORT
    SettingsSearchTarget.APPEARANCE -> SettingsIconRole.APPEARANCE
    SettingsSearchTarget.ANIMATION -> SettingsIconRole.ANIMATION
    SettingsSearchTarget.PLAYBACK -> SettingsIconRole.PLAYBACK
    SettingsSearchTarget.BOTTOM_BAR -> SettingsIconRole.BOTTOM_BAR
    SettingsSearchTarget.PERMISSION -> SettingsIconRole.PERMISSION
    SettingsSearchTarget.BLOCKED_LIST -> SettingsIconRole.BLOCKED_LIST
    SettingsSearchTarget.SETTINGS_SHARE -> SettingsIconRole.SETTINGS_SHARE
    SettingsSearchTarget.WEBDAV_BACKUP -> SettingsIconRole.WEBDAV_BACKUP
    SettingsSearchTarget.DOWNLOAD_PATH -> SettingsIconRole.DOWNLOAD_PATH
    SettingsSearchTarget.IMAGE_SAVE_PATH -> SettingsIconRole.IMAGE_SAVE_PATH
    SettingsSearchTarget.CLEAR_CACHE -> SettingsIconRole.CLEAR_CACHE
    SettingsSearchTarget.PLUGINS -> SettingsIconRole.PLUGINS
    SettingsSearchTarget.EXPORT_LOGS -> SettingsIconRole.EXPORT_LOGS
    SettingsSearchTarget.OPEN_SOURCE_LICENSES -> SettingsIconRole.OPEN_SOURCE_LICENSES
    SettingsSearchTarget.OPEN_SOURCE_HOME -> SettingsIconRole.OPEN_SOURCE_HOME
    SettingsSearchTarget.CHECK_UPDATE -> SettingsIconRole.CHECK_UPDATE
    SettingsSearchTarget.VIEW_RELEASE_NOTES -> SettingsIconRole.VIEW_RELEASE_NOTES
    SettingsSearchTarget.REPLAY_ONBOARDING -> SettingsIconRole.REPLAY_ONBOARDING
    SettingsSearchTarget.TIPS -> SettingsIconRole.TIPS
    SettingsSearchTarget.OPEN_LINKS -> SettingsIconRole.OPEN_LINKS
    SettingsSearchTarget.DONATE -> SettingsIconRole.DONATE
    SettingsSearchTarget.TELEGRAM -> SettingsIconRole.OPEN_LINKS
    SettingsSearchTarget.TWITTER -> SettingsIconRole.OPEN_LINKS
    SettingsSearchTarget.DISCLAIMER -> SettingsIconRole.DISCLAIMER
}

internal fun resolveSettingsSemanticIcon(
    role: SettingsIconRole,
    uiPreset: UiPreset = UiPreset.IOS
): ImageVector = if (uiPreset == UiPreset.MD3) {
    resolveMd3SettingsSemanticIcon(role)
} else {
    resolveIosSettingsSemanticIcon(role)
}

private fun resolveMd3SettingsSemanticIcon(role: SettingsIconRole): ImageVector = when (role) {
    SettingsIconRole.INTERFACE_THEME -> Icons.Outlined.Palette
    SettingsIconRole.HOME_FEED -> Icons.Outlined.Home
    SettingsIconRole.NAVIGATION -> Icons.Outlined.Widgets
    SettingsIconRole.PLAYBACK_QUALITY -> Icons.Outlined.PlayCircle
    SettingsIconRole.FULLSCREEN_GESTURE -> Icons.Outlined.TouchApp
    SettingsIconRole.INTERACTION_COMMENT -> Icons.Outlined.ChatBubbleOutline
    SettingsIconRole.DATA_BACKUP -> Icons.Outlined.Backup
    SettingsIconRole.PRIVACY_PERMISSION -> Icons.Outlined.Security
    SettingsIconRole.DIAGNOSTICS -> Icons.Outlined.Terminal
    SettingsIconRole.ABOUT_SUPPORT -> Icons.Outlined.Description
    SettingsIconRole.APPEARANCE -> Icons.Outlined.Palette
    SettingsIconRole.ANIMATION -> Icons.Outlined.AutoAwesome
    SettingsIconRole.PLAYBACK -> Icons.Outlined.PlayCircle
    SettingsIconRole.BOTTOM_BAR -> Icons.Outlined.Widgets
    SettingsIconRole.PERMISSION -> Icons.Outlined.Security
    SettingsIconRole.BLOCKED_LIST -> Icons.Outlined.Block
    SettingsIconRole.SETTINGS_SHARE -> Icons.Outlined.Share
    SettingsIconRole.WEBDAV_BACKUP -> Icons.Outlined.Backup
    SettingsIconRole.DOWNLOAD_PATH -> Icons.Outlined.Folder
    SettingsIconRole.IMAGE_SAVE_PATH -> Icons.Outlined.Folder
    SettingsIconRole.CLEAR_CACHE -> Icons.Outlined.DeleteOutline
    SettingsIconRole.PLUGINS -> Icons.Outlined.Extension
    SettingsIconRole.EXPORT_LOGS -> Icons.Outlined.Article
    SettingsIconRole.OPEN_SOURCE_LICENSES -> Icons.Outlined.Description
    SettingsIconRole.OPEN_SOURCE_HOME -> Icons.Outlined.OpenInNew
    SettingsIconRole.CHECK_UPDATE -> Icons.Outlined.Update
    SettingsIconRole.VIEW_RELEASE_NOTES -> Icons.Outlined.Feed
    SettingsIconRole.REPLAY_ONBOARDING -> Icons.Outlined.Replay
    SettingsIconRole.TIPS -> Icons.Outlined.Lightbulb
    SettingsIconRole.OPEN_LINKS -> Icons.Outlined.Link
    SettingsIconRole.DONATE -> Icons.Outlined.CardGiftcard
    SettingsIconRole.DISCLAIMER -> Icons.Outlined.WarningAmber
    SettingsIconRole.RELEASE_CHANNEL -> Icons.Outlined.WarningAmber
    SettingsIconRole.CRASH_TRACKING -> Icons.Outlined.BugReport
    SettingsIconRole.ANALYTICS -> Icons.Outlined.Terminal
    SettingsIconRole.FEED_API -> Icons.Outlined.Feed
    SettingsIconRole.REFRESH_COUNT -> Icons.Outlined.Update
    SettingsIconRole.DYNAMIC_PREVIEW_TEXT -> Icons.Outlined.Article
    SettingsIconRole.DYNAMIC_TAB_VISIBILITY -> Icons.Outlined.Widgets
    SettingsIconRole.EASTER_EGG -> Icons.Outlined.AutoAwesome
    SettingsIconRole.AUTO_CHECK_UPDATE -> Icons.Outlined.Update
    SettingsIconRole.BUILD_SOURCE -> Icons.Outlined.Link
    SettingsIconRole.BUILD_FINGERPRINT -> Icons.Outlined.Description
    SettingsIconRole.BUILD_VERIFICATION -> Icons.Outlined.Security
    SettingsIconRole.ANDROID_LIQUID_GLASS -> Icons.Outlined.AutoAwesome
    SettingsIconRole.DYNAMIC_COLOR -> Icons.Outlined.Palette
    SettingsIconRole.COLOR_STYLE -> Icons.Outlined.Palette
    SettingsIconRole.COLOR_SPEC -> Icons.Outlined.AutoAwesome
    SettingsIconRole.APP_LANGUAGE -> Icons.Outlined.Article
    SettingsIconRole.FONT_FILE -> Icons.Outlined.Description
    SettingsIconRole.SPLASH_WALLPAPER -> Icons.Outlined.Home
    SettingsIconRole.RANDOM_WALLPAPER -> Icons.Outlined.Update
    SettingsIconRole.DISPLAY_STYLE -> Icons.Outlined.Widgets
    SettingsIconRole.HOME_COVER_GLASS -> Icons.Outlined.AutoAwesome
    SettingsIconRole.VIDEO_DURATION_BADGES -> Icons.Outlined.PlayCircle
    SettingsIconRole.HOME_INFO_GLASS -> Icons.Outlined.Article
    SettingsIconRole.HOME_WALLPAPER -> Icons.Outlined.Home
    SettingsIconRole.WALLPAPER_EFFECT -> Icons.Outlined.AutoAwesome
    SettingsIconRole.HOME_UP_BADGES -> Icons.Outlined.Security
    SettingsIconRole.ONLINE_COUNT -> Icons.Outlined.Terminal
    SettingsIconRole.GRID_COLUMNS -> Icons.Outlined.Widgets
    SettingsIconRole.HOME_CARD_WIDTH -> Icons.Outlined.Widgets
    SettingsIconRole.CARD_ENTRANCE_ANIMATION -> Icons.Outlined.AutoAwesome
    SettingsIconRole.CARD_TRANSITION_ANIMATION -> Icons.Outlined.Widgets
    SettingsIconRole.PREDICTIVE_BACK -> Icons.AutoMirrored.Outlined.ArrowBack
    SettingsIconRole.BOTTOM_BAR_GLASS -> Icons.Outlined.AutoAwesome
    SettingsIconRole.TOP_BAR_BLUR -> Icons.Outlined.Widgets
    SettingsIconRole.BOTTOM_BAR_BLUR -> Icons.Outlined.Widgets
    SettingsIconRole.FLOATING_BOTTOM_BAR -> Icons.Outlined.Widgets
    SettingsIconRole.HARDWARE_DECODER -> Icons.Outlined.PlayCircle
    SettingsIconRole.PLAYBACK_SPEED -> Icons.Outlined.Update
    SettingsIconRole.STOP_ON_EXIT -> Icons.Outlined.Block
    SettingsIconRole.BACKGROUND_PLAYBACK -> Icons.Outlined.PlayCircle
    SettingsIconRole.AUDIO_FOCUS -> Icons.Outlined.PlayCircle
    SettingsIconRole.PIP_DANMAKU -> Icons.Outlined.ChatBubbleOutline
    SettingsIconRole.AUDIO_MODE_PIP -> Icons.Outlined.PlayCircle
    SettingsIconRole.PLAYER_DIAGNOSTICS -> Icons.Outlined.Terminal
    SettingsIconRole.QUALITY_WARNING -> Icons.Outlined.WarningAmber
    SettingsIconRole.SUBTITLE -> Icons.Outlined.Article
    SettingsIconRole.COMMENT_DECORATION -> Icons.Outlined.ChatBubbleOutline
    SettingsIconRole.AI_SUMMARY -> Icons.Outlined.AutoAwesome
    SettingsIconRole.LIKE_INTERACTION -> Icons.Outlined.TouchApp
    SettingsIconRole.VIDEO_DESCRIPTION -> Icons.Outlined.Article
    SettingsIconRole.FULLSCREEN_ORIENTATION -> Icons.Outlined.TouchApp
    SettingsIconRole.HORIZONTAL_ADAPTATION -> Icons.Outlined.Widgets
    SettingsIconRole.FULLSCREEN_GESTURE_REVERSE -> Icons.Outlined.TouchApp
    SettingsIconRole.HIDE_STATUS_BAR -> Icons.Outlined.Widgets
    SettingsIconRole.AUTO_ENTER_FULLSCREEN -> Icons.Outlined.OpenInNew
    SettingsIconRole.AUTO_EXIT_FULLSCREEN -> Icons.Outlined.OpenInNew
    SettingsIconRole.FULLSCREEN_LOCK -> Icons.Outlined.Security
    SettingsIconRole.FULLSCREEN_SCREENSHOT -> Icons.Outlined.Home
    SettingsIconRole.CLEAN_SCREENSHOT -> Icons.Outlined.Home
    SettingsIconRole.BATTERY_STATUS -> Icons.Outlined.Terminal
    SettingsIconRole.TIME_STATUS -> Icons.Outlined.Update
    SettingsIconRole.PLAYER_ACTIONS -> Icons.Outlined.Share
}

private fun resolveIosSettingsSemanticIcon(role: SettingsIconRole): ImageVector = when (role) {
    SettingsIconRole.INTERFACE_THEME -> CupertinoIcons.Outlined.Sparkles
    SettingsIconRole.HOME_FEED -> CupertinoIcons.Outlined.House
    SettingsIconRole.NAVIGATION -> CupertinoIcons.Outlined.RectangleStack
    SettingsIconRole.PLAYBACK_QUALITY -> CupertinoIcons.Outlined.PlayCircle
    SettingsIconRole.FULLSCREEN_GESTURE -> CupertinoIcons.Outlined.HandTap
    SettingsIconRole.INTERACTION_COMMENT -> CupertinoIcons.Outlined.TextBubble
    SettingsIconRole.DATA_BACKUP -> CupertinoIcons.Outlined.DocOnDoc
    SettingsIconRole.PRIVACY_PERMISSION -> CupertinoIcons.Outlined.Lock
    SettingsIconRole.DIAGNOSTICS -> CupertinoIcons.Outlined.Terminal
    SettingsIconRole.ABOUT_SUPPORT -> CupertinoIcons.Outlined.InfoCircle
    SettingsIconRole.APPEARANCE -> CupertinoIcons.Outlined.PaintbrushPointed
    SettingsIconRole.ANIMATION -> CupertinoIcons.Outlined.WandAndStars
    SettingsIconRole.PLAYBACK -> CupertinoIcons.Outlined.PlayCircle
    SettingsIconRole.BOTTOM_BAR -> CupertinoIcons.Outlined.SquareStack3dUp
    SettingsIconRole.PERMISSION -> CupertinoIcons.Outlined.Lock
    SettingsIconRole.BLOCKED_LIST -> CupertinoIcons.Outlined.XmarkCircle
    SettingsIconRole.SETTINGS_SHARE -> CupertinoIcons.Outlined.ListBullet
    SettingsIconRole.WEBDAV_BACKUP -> CupertinoIcons.Outlined.DocOnDoc
    SettingsIconRole.DOWNLOAD_PATH -> CupertinoIcons.Outlined.Folder
    SettingsIconRole.IMAGE_SAVE_PATH -> CupertinoIcons.Outlined.Folder
    SettingsIconRole.CLEAR_CACHE -> CupertinoIcons.Outlined.Trash
    SettingsIconRole.PLUGINS -> CupertinoIcons.Outlined.PuzzlepieceExtension
    SettingsIconRole.EXPORT_LOGS -> CupertinoIcons.Outlined.Terminal
    SettingsIconRole.OPEN_SOURCE_LICENSES -> CupertinoIcons.Outlined.DocText
    SettingsIconRole.OPEN_SOURCE_HOME -> CupertinoIcons.Outlined.SquareAndArrowUp
    SettingsIconRole.CHECK_UPDATE -> CupertinoIcons.Outlined.ArrowTriangle2Circlepath
    SettingsIconRole.VIEW_RELEASE_NOTES -> CupertinoIcons.Outlined.Newspaper
    SettingsIconRole.REPLAY_ONBOARDING -> CupertinoIcons.Outlined.ArrowCounterclockwise
    SettingsIconRole.TIPS -> CupertinoIcons.Outlined.Lightbulb
    SettingsIconRole.OPEN_LINKS -> CupertinoIcons.Outlined.Link
    SettingsIconRole.DONATE -> CupertinoIcons.Outlined.Gift
    SettingsIconRole.DISCLAIMER -> CupertinoIcons.Outlined.ExclamationmarkTriangle
    SettingsIconRole.RELEASE_CHANNEL -> CupertinoIcons.Outlined.ExclamationmarkTriangle
    SettingsIconRole.CRASH_TRACKING -> CupertinoIcons.Outlined.XmarkCircle
    SettingsIconRole.ANALYTICS -> CupertinoIcons.Outlined.ChartBar
    SettingsIconRole.FEED_API -> CupertinoIcons.Outlined.Bolt
    SettingsIconRole.REFRESH_COUNT -> CupertinoIcons.Outlined.ArrowTriangle2Circlepath
    SettingsIconRole.DYNAMIC_PREVIEW_TEXT -> CupertinoIcons.Outlined.TextBubble
    SettingsIconRole.DYNAMIC_TAB_VISIBILITY -> CupertinoIcons.Outlined.RectangleStack
    SettingsIconRole.EASTER_EGG -> CupertinoIcons.Outlined.Sparkles
    SettingsIconRole.AUTO_CHECK_UPDATE -> CupertinoIcons.Outlined.BellBadge
    SettingsIconRole.BUILD_SOURCE -> CupertinoIcons.Outlined.Tag
    SettingsIconRole.BUILD_FINGERPRINT -> CupertinoIcons.Outlined.DocText
    SettingsIconRole.BUILD_VERIFICATION -> CupertinoIcons.Outlined.Lock
    SettingsIconRole.ANDROID_LIQUID_GLASS -> CupertinoIcons.Outlined.Sparkles
    SettingsIconRole.DYNAMIC_COLOR -> CupertinoIcons.Outlined.PaintbrushPointed
    SettingsIconRole.COLOR_STYLE -> CupertinoIcons.Outlined.Sparkles
    SettingsIconRole.COLOR_SPEC -> CupertinoIcons.Outlined.WandAndStars
    SettingsIconRole.APP_LANGUAGE -> CupertinoIcons.Outlined.DocText
    SettingsIconRole.FONT_FILE -> CupertinoIcons.Outlined.DocText
    SettingsIconRole.SPLASH_WALLPAPER -> CupertinoIcons.Outlined.House
    SettingsIconRole.RANDOM_WALLPAPER -> CupertinoIcons.Outlined.ArrowTriangle2Circlepath
    SettingsIconRole.DISPLAY_STYLE -> CupertinoIcons.Outlined.RectangleStack
    SettingsIconRole.HOME_COVER_GLASS -> CupertinoIcons.Outlined.Sparkles
    SettingsIconRole.VIDEO_DURATION_BADGES -> CupertinoIcons.Outlined.PlayCircle
    SettingsIconRole.HOME_INFO_GLASS -> CupertinoIcons.Outlined.Tag
    SettingsIconRole.HOME_WALLPAPER -> CupertinoIcons.Outlined.House
    SettingsIconRole.WALLPAPER_EFFECT -> CupertinoIcons.Outlined.Sparkles
    SettingsIconRole.HOME_UP_BADGES -> CupertinoIcons.Outlined.Lock
    SettingsIconRole.ONLINE_COUNT -> CupertinoIcons.Outlined.ChartBar
    SettingsIconRole.GRID_COLUMNS -> CupertinoIcons.Outlined.ListBullet
    SettingsIconRole.HOME_CARD_WIDTH -> CupertinoIcons.Outlined.RectangleStack
    SettingsIconRole.CARD_ENTRANCE_ANIMATION -> CupertinoIcons.Outlined.WandAndStars
    SettingsIconRole.CARD_TRANSITION_ANIMATION -> CupertinoIcons.Outlined.ArrowLeftArrowRight
    SettingsIconRole.PREDICTIVE_BACK -> CupertinoIcons.Outlined.ArrowLeftArrowRight
    SettingsIconRole.BOTTOM_BAR_GLASS -> CupertinoIcons.Outlined.Sparkles
    SettingsIconRole.TOP_BAR_BLUR -> CupertinoIcons.Outlined.SquareStack3dUp
    SettingsIconRole.BOTTOM_BAR_BLUR -> CupertinoIcons.Outlined.SquareStack3dUp
    SettingsIconRole.FLOATING_BOTTOM_BAR -> CupertinoIcons.Outlined.RectangleStack
    SettingsIconRole.HARDWARE_DECODER -> CupertinoIcons.Outlined.Bolt
    SettingsIconRole.PLAYBACK_SPEED -> CupertinoIcons.Outlined.Clock
    SettingsIconRole.STOP_ON_EXIT -> CupertinoIcons.Outlined.XmarkCircle
    SettingsIconRole.BACKGROUND_PLAYBACK -> CupertinoIcons.Outlined.PlayCircle
    SettingsIconRole.AUDIO_FOCUS -> CupertinoIcons.Outlined.Bolt
    SettingsIconRole.PIP_DANMAKU -> CupertinoIcons.Outlined.TextBubble
    SettingsIconRole.AUDIO_MODE_PIP -> CupertinoIcons.Outlined.PlayCircle
    SettingsIconRole.PLAYER_DIAGNOSTICS -> CupertinoIcons.Outlined.Terminal
    SettingsIconRole.QUALITY_WARNING -> CupertinoIcons.Outlined.ExclamationmarkTriangle
    SettingsIconRole.SUBTITLE -> CupertinoIcons.Outlined.DocText
    SettingsIconRole.COMMENT_DECORATION -> CupertinoIcons.Outlined.TextBubble
    SettingsIconRole.AI_SUMMARY -> CupertinoIcons.Outlined.Sparkles
    SettingsIconRole.LIKE_INTERACTION -> CupertinoIcons.Outlined.HandTap
    SettingsIconRole.VIDEO_DESCRIPTION -> CupertinoIcons.Outlined.DocText
    SettingsIconRole.FULLSCREEN_ORIENTATION -> CupertinoIcons.Outlined.ArrowLeftArrowRight
    SettingsIconRole.HORIZONTAL_ADAPTATION -> CupertinoIcons.Outlined.RectangleStack
    SettingsIconRole.FULLSCREEN_GESTURE_REVERSE -> CupertinoIcons.Outlined.HandTap
    SettingsIconRole.HIDE_STATUS_BAR -> CupertinoIcons.Outlined.RectangleStack
    SettingsIconRole.AUTO_ENTER_FULLSCREEN -> CupertinoIcons.Outlined.ArrowLeftArrowRight
    SettingsIconRole.AUTO_EXIT_FULLSCREEN -> CupertinoIcons.Outlined.ArrowLeftArrowRight
    SettingsIconRole.FULLSCREEN_LOCK -> CupertinoIcons.Outlined.Lock
    SettingsIconRole.FULLSCREEN_SCREENSHOT -> CupertinoIcons.Outlined.Camera
    SettingsIconRole.CLEAN_SCREENSHOT -> CupertinoIcons.Outlined.House
    SettingsIconRole.BATTERY_STATUS -> CupertinoIcons.Outlined.Bolt
    SettingsIconRole.TIME_STATUS -> CupertinoIcons.Outlined.Clock
    SettingsIconRole.PLAYER_ACTIONS -> CupertinoIcons.Outlined.SquareAndArrowUp
}

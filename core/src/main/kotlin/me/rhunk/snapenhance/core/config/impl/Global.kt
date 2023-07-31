package me.rhunk.snapenhance.core.config.impl

import me.rhunk.snapenhance.core.config.ConfigContainer
import me.rhunk.snapenhance.data.NotificationType

class Global : ConfigContainer() {
    val snapchatPlus = boolean("snapchat_plus")
    val autoUpdater = unique("auto_updater", "DAILY","EVERY_LAUNCH", "DAILY", "WEEKLY")
    val disableMetrics = boolean("disable_metrics")
    val disableVideoLengthRestrictions = boolean("disable_video_length_restrictions")
    val disableGooglePlayDialogs = boolean("disable_google_play_dialogs")
    val forceMediaSourceQuality = boolean("force_media_source_quality")
    val betterNotifications = multiple("better_notifications", "snap", "chat", "reply_button", "download_button")
    val notificationBlacklist = multiple("notification_blacklist", *NotificationType.getIncomingValues().map { it.key }.toTypedArray())
    val disableSnapSplitting = boolean("disable_snap_splitting")
}
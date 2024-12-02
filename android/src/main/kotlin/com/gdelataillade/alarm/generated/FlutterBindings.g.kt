// Autogenerated from Pigeon (v22.6.1), do not edit directly.
// See also: https://pub.dev/packages/pigeon
@file:Suppress("UNCHECKED_CAST", "ArrayInDataClass")


import android.util.Log
import io.flutter.plugin.common.BasicMessageChannel
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.MessageCodec
import io.flutter.plugin.common.StandardMessageCodec
import java.io.ByteArrayOutputStream
import java.nio.ByteBuffer

private fun wrapResult(result: Any?): List<Any?> {
  return listOf(result)
}

private fun wrapError(exception: Throwable): List<Any?> {
  return if (exception is FlutterError) {
    listOf(
      exception.code,
      exception.message,
      exception.details
    )
  } else {
    listOf(
      exception.javaClass.simpleName,
      exception.toString(),
      "Cause: " + exception.cause + ", Stacktrace: " + Log.getStackTraceString(exception)
    )
  }
}

private fun createConnectionError(channelName: String): FlutterError {
  return FlutterError("channel-error",  "Unable to establish connection on channel: '$channelName'.", "")}

/**
 * Error class for passing custom error details to Flutter via a thrown PlatformException.
 * @property code The error code.
 * @property message The error message.
 * @property details The error details. Must be a datatype supported by the api codec.
 */
class FlutterError (
  val code: String,
  override val message: String? = null,
  val details: Any? = null
) : Throwable()

/** Errors that can occur when interacting with the Alarm API. */
enum class AlarmErrorCode(val raw: Int) {
  UNKNOWN(0),
  /** A plugin internal error. Please report these as bugs on GitHub. */
  PLUGIN_INTERNAL(1),
  /** The arguments passed to the method are invalid. */
  INVALID_ARGUMENTS(2),
  /** An error occurred while communicating with the native platform. */
  CHANNEL_ERROR(3),
  /**
   * The required notification permission was not granted.
   *
   * Please use an external permission manager such as "permission_handler" to
   * request the permission from the user.
   */
  MISSING_NOTIFICATION_PERMISSION(4);

  companion object {
    fun ofRaw(raw: Int): AlarmErrorCode? {
      return values().firstOrNull { it.raw == raw }
    }
  }
}

/**
 * [AlarmSettingsWire] is a model that contains all the settings to customize
 * and set an alarm.
 *
 * Generated class from Pigeon that represents data sent in messages.
 */
data class AlarmSettingsWire (
  /** Unique identifier assiocated with the alarm. Cannot be 0 or -1; */
  val id: Long,
  /** Instant (independent of timezone) when the alarm will be triggered. */
  val millisecondsSinceEpoch: Long,
  /**
   * Path to audio asset to be used as the alarm ringtone. Accepted formats:
   *
   * * **Project asset**: Specifies an asset bundled with your Flutter project.
   *  Use this format for assets that are included in your project's
   * `pubspec.yaml` file.
   *  Example: `assets/audio.mp3`.
   * * **Absolute file path**: Specifies a direct file system path to the
   * audio file. This format is used for audio files stored outside the
   * Flutter project, such as files saved in the device's internal
   * or external storage.
   *  Example: `/path/to/your/audio.mp3`.
   * * **Relative file path**: Specifies a file path relative to a predefined
   * base directory in the app's internal storage. This format is convenient
   * for referring to files that are stored within a specific directory of
   * your app's internal storage without needing to specify the full path.
   *  Example: `Audios/audio.mp3`.
   *
   * If you want to use aboslute or relative file path, you must request
   * android storage permission and add the following permission to your
   * `AndroidManifest.xml`:
   * `android.permission.READ_EXTERNAL_STORAGE`
   */
  val assetAudioPath: String,
  /** Settings for the notification. */
  val notificationSettings: NotificationSettingsWire,
  /** If true, [assetAudioPath] will repeat indefinitely until alarm is stopped. */
  val loopAudio: Boolean,
  /**
   * If true, device will vibrate for 500ms, pause for 500ms and repeat until
   * alarm is stopped.
   *
   * If [loopAudio] is set to false, vibrations will stop when audio ends.
   */
  val vibrate: Boolean,
  /**
   * Specifies the system volume level to be set at the designated instant.
   *
   * Accepts a value between 0 (mute) and 1 (maximum volume).
   * When the alarm is triggered, the system volume adjusts to his specified
   * level. Upon stopping the alarm, the system volume reverts to its prior
   * setting.
   *
   * If left unspecified or set to `null`, the current system volume
   * at the time of the alarm will be used.
   * Defaults to `null`.
   */
  val volume: Double? = null,
  /**
   * If true, the alarm volume is enforced, automatically resetting to the
   * original alarm [volume] if the user attempts to adjust it.
   * This prevents the user from lowering the alarm volume.
   * Won't work if app is killed.
   *
   * Defaults to false.
   */
  val volumeEnforced: Boolean,
  /**
   * Duration, in seconds, over which to fade the alarm ringtone.
   * Set to 0.0 by default, which means no fade.
   */
  val fadeDuration: Double,
  /**
   * Whether to show a warning notification when application is killed by user.
   *
   * - **Android**: the alarm should still trigger even if the app is killed,
   * if configured correctly and with the right permissions.
   * - **iOS**: the alarm will not trigger if the app is killed.
   *
   * Recommended: set to `Platform.isIOS` to enable it only
   * on iOS. Defaults to `true`.
   */
  val warningNotificationOnKill: Boolean,
  /**
   * Whether to turn screen on and display full screen notification
   * when android alarm notification is triggered. Enabled by default.
   *
   * Some devices will need the Autostart permission to show the full screen
   * notification. You can check if the permission is granted and request it
   * with the [auto_start_flutter](https://pub.dev/packages/auto_start_flutter)
   * package.
   */
  val androidFullScreenIntent: Boolean
)
 {
  companion object {
    fun fromList(pigeonVar_list: List<Any?>): AlarmSettingsWire {
      val id = pigeonVar_list[0] as Long
      val millisecondsSinceEpoch = pigeonVar_list[1] as Long
      val assetAudioPath = pigeonVar_list[2] as String
      val notificationSettings = pigeonVar_list[3] as NotificationSettingsWire
      val loopAudio = pigeonVar_list[4] as Boolean
      val vibrate = pigeonVar_list[5] as Boolean
      val volume = pigeonVar_list[6] as Double?
      val volumeEnforced = pigeonVar_list[7] as Boolean
      val fadeDuration = pigeonVar_list[8] as Double
      val warningNotificationOnKill = pigeonVar_list[9] as Boolean
      val androidFullScreenIntent = pigeonVar_list[10] as Boolean
      return AlarmSettingsWire(id, millisecondsSinceEpoch, assetAudioPath, notificationSettings, loopAudio, vibrate, volume, volumeEnforced, fadeDuration, warningNotificationOnKill, androidFullScreenIntent)
    }
  }
  fun toList(): List<Any?> {
    return listOf(
      id,
      millisecondsSinceEpoch,
      assetAudioPath,
      notificationSettings,
      loopAudio,
      vibrate,
      volume,
      volumeEnforced,
      fadeDuration,
      warningNotificationOnKill,
      androidFullScreenIntent,
    )
  }
}

/**
 * Model for notification settings.
 *
 * Generated class from Pigeon that represents data sent in messages.
 */
data class NotificationSettingsWire (
  /** Title of the notification to be shown when alarm is triggered. */
  val title: String,
  /** Body of the notification to be shown when alarm is triggered. */
  val body: String,
  /**
   * The text to display on the stop button of the notification.
   *
   * Won't work on iOS if app was killed.
   * If null, button will not be shown. Null by default.
   */
  val stopButton: String? = null,
  /**
   * The icon to display on the notification.
   *
   * **Only customizable for Android. On iOS, it will use app default icon.**
   *
   * This refers to the small icon that is displayed in the
   * status bar and next to the notification content in both collapsed
   * and expanded views.
   *
   * Note that the icon must be monochrome and on a transparent background and
   * preferably 24x24 dp in size.
   *
   * **Only PNG and XML formats are supported at the moment.
   * Please open an issue to request support for more formats.**
   *
   * You must add your icon to your Android project's `res/drawable` directory.
   * Example: `android/app/src/main/res/drawable/notification_icon.png`
   *
   * And pass: `icon: notification_icon` without the file extension.
   *
   * If `null`, the default app icon will be used.
   * Defaults to `null`.
   */
  val icon: String? = null
)
 {
  companion object {
    fun fromList(pigeonVar_list: List<Any?>): NotificationSettingsWire {
      val title = pigeonVar_list[0] as String
      val body = pigeonVar_list[1] as String
      val stopButton = pigeonVar_list[2] as String?
      val icon = pigeonVar_list[3] as String?
      return NotificationSettingsWire(title, body, stopButton, icon)
    }
  }
  fun toList(): List<Any?> {
    return listOf(
      title,
      body,
      stopButton,
      icon,
    )
  }
}
private open class FlutterBindingsPigeonCodec : StandardMessageCodec() {
  override fun readValueOfType(type: Byte, buffer: ByteBuffer): Any? {
    return when (type) {
      129.toByte() -> {
        return (readValue(buffer) as Long?)?.let {
          AlarmErrorCode.ofRaw(it.toInt())
        }
      }
      130.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          AlarmSettingsWire.fromList(it)
        }
      }
      131.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          NotificationSettingsWire.fromList(it)
        }
      }
      else -> super.readValueOfType(type, buffer)
    }
  }
  override fun writeValue(stream: ByteArrayOutputStream, value: Any?)   {
    when (value) {
      is AlarmErrorCode -> {
        stream.write(129)
        writeValue(stream, value.raw)
      }
      is AlarmSettingsWire -> {
        stream.write(130)
        writeValue(stream, value.toList())
      }
      is NotificationSettingsWire -> {
        stream.write(131)
        writeValue(stream, value.toList())
      }
      else -> super.writeValue(stream, value)
    }
  }
}

/** Generated interface from Pigeon that represents a handler of messages from Flutter. */
interface AlarmApi {
  fun setAlarm(alarmSettings: AlarmSettingsWire)
  fun stopAlarm(alarmId: Long)
  fun isRinging(alarmId: Long?): Boolean
  fun setWarningNotificationOnKill(title: String, body: String)
  fun disableWarningNotificationOnKill()

  companion object {
    /** The codec used by AlarmApi. */
    val codec: MessageCodec<Any?> by lazy {
      FlutterBindingsPigeonCodec()
    }
    /** Sets up an instance of `AlarmApi` to handle messages through the `binaryMessenger`. */
    @JvmOverloads
    fun setUp(binaryMessenger: BinaryMessenger, api: AlarmApi?, messageChannelSuffix: String = "") {
      val separatedMessageChannelSuffix = if (messageChannelSuffix.isNotEmpty()) ".$messageChannelSuffix" else ""
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.alarm.AlarmApi.setAlarm$separatedMessageChannelSuffix", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val alarmSettingsArg = args[0] as AlarmSettingsWire
            val wrapped: List<Any?> = try {
              api.setAlarm(alarmSettingsArg)
              listOf(null)
            } catch (exception: Throwable) {
              wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.alarm.AlarmApi.stopAlarm$separatedMessageChannelSuffix", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val alarmIdArg = args[0] as Long
            val wrapped: List<Any?> = try {
              api.stopAlarm(alarmIdArg)
              listOf(null)
            } catch (exception: Throwable) {
              wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.alarm.AlarmApi.isRinging$separatedMessageChannelSuffix", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val alarmIdArg = args[0] as Long?
            val wrapped: List<Any?> = try {
              listOf(api.isRinging(alarmIdArg))
            } catch (exception: Throwable) {
              wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.alarm.AlarmApi.setWarningNotificationOnKill$separatedMessageChannelSuffix", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val titleArg = args[0] as String
            val bodyArg = args[1] as String
            val wrapped: List<Any?> = try {
              api.setWarningNotificationOnKill(titleArg, bodyArg)
              listOf(null)
            } catch (exception: Throwable) {
              wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.alarm.AlarmApi.disableWarningNotificationOnKill$separatedMessageChannelSuffix", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            val wrapped: List<Any?> = try {
              api.disableWarningNotificationOnKill()
              listOf(null)
            } catch (exception: Throwable) {
              wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
    }
  }
}
/** Generated class from Pigeon that represents Flutter messages that can be called from Kotlin. */
class AlarmTriggerApi(private val binaryMessenger: BinaryMessenger, private val messageChannelSuffix: String = "") {
  companion object {
    /** The codec used by AlarmTriggerApi. */
    val codec: MessageCodec<Any?> by lazy {
      FlutterBindingsPigeonCodec()
    }
  }
  fun alarmRang(alarmIdArg: Long, callback: (Result<Unit>) -> Unit)
{
    val separatedMessageChannelSuffix = if (messageChannelSuffix.isNotEmpty()) ".$messageChannelSuffix" else ""
    val channelName = "dev.flutter.pigeon.alarm.AlarmTriggerApi.alarmRang$separatedMessageChannelSuffix"
    val channel = BasicMessageChannel<Any?>(binaryMessenger, channelName, codec)
    channel.send(listOf(alarmIdArg)) {
      if (it is List<*>) {
        if (it.size > 1) {
          callback(Result.failure(FlutterError(it[0] as String, it[1] as String, it[2] as String?)))
        } else {
          callback(Result.success(Unit))
        }
      } else {
        callback(Result.failure(createConnectionError(channelName)))
      } 
    }
  }
  fun alarmStopped(alarmIdArg: Long, callback: (Result<Unit>) -> Unit)
{
    val separatedMessageChannelSuffix = if (messageChannelSuffix.isNotEmpty()) ".$messageChannelSuffix" else ""
    val channelName = "dev.flutter.pigeon.alarm.AlarmTriggerApi.alarmStopped$separatedMessageChannelSuffix"
    val channel = BasicMessageChannel<Any?>(binaryMessenger, channelName, codec)
    channel.send(listOf(alarmIdArg)) {
      if (it is List<*>) {
        if (it.size > 1) {
          callback(Result.failure(FlutterError(it[0] as String, it[1] as String, it[2] as String?)))
        } else {
          callback(Result.success(Unit))
        }
      } else {
        callback(Result.failure(createConnectionError(channelName)))
      } 
    }
  }
}

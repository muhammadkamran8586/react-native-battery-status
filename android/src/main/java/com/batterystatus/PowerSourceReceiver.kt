package com.batterystatus

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.WritableNativeMap

class PowerSourceReceiver(context: ReactApplicationContext) {
  val event = Event(context)
  val powerSource = object : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
      intent.let {
        try {
          val sourceEnum = intent?.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1)
          val source = getPowerSource(sourceEnum!!)
          val data = WritableNativeMap().apply {
            putString("source", source)
          }
          event.sendEvent("powerSource", data)
        } catch (e: Exception) {
          e.printStackTrace()
        }
      }
    }
    private fun getPowerSource(sourceEnum: Int): String {
      return when (sourceEnum) {
        BatteryManager.BATTERY_PLUGGED_AC -> "AC"
        BatteryManager.BATTERY_PLUGGED_USB -> "USB"
        BatteryManager.BATTERY_PLUGGED_DOCK -> "DOCk"
        BatteryManager.BATTERY_PLUGGED_WIRELESS -> "WIRELESS"
        else -> "UNKNOWN"
      }
    }
  }
}

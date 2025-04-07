package com.batterystatus

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.os.Build
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.WritableNativeMap

class BatteryInfoReceiver(context: ReactApplicationContext) {

  val event = Event(context)
  val batteryInfo = object : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
      intent.let {
        try {
          val temperatureReceiver = intent?.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, -1)
          val temperature = temperatureReceiver!! / 10.0
          val healthEnum = intent.getIntExtra(BatteryManager.EXTRA_HEALTH, -1)
          val health = getHealth(healthEnum)
          val data = WritableNativeMap().apply {
            putDouble("temperature", temperature)
            putString("health", health)
          }
          event.sendEvent("batteryInfo", data)
        } catch (e: Exception) {
          e.printStackTrace()
        }
      }
    }
  }

  private fun getHealth(healthEnum: Int): String {
    return when (healthEnum) {
      BatteryManager.BATTERY_HEALTH_UNKNOWN -> "UNKNOWN"
      BatteryManager.BATTERY_HEALTH_GOOD -> "GOOD"
      BatteryManager.BATTERY_HEALTH_OVERHEAT -> "OVERHEAT"
      BatteryManager.BATTERY_HEALTH_DEAD -> "DEAD"
      BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE -> "OVER_VOLTAGE"
      BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE -> "UNSPECIFIED_FAILURE"
      BatteryManager.BATTERY_HEALTH_COLD -> "COLD"
      else -> "UNKNOWN"
    }
  }
}



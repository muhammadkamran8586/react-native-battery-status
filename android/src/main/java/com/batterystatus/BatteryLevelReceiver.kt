package com.batterystatus

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.WritableNativeMap

class BatteryLevelReceiver(context : ReactApplicationContext) {
  val event = Event(context)
  val batteryLevel = object : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
      intent.let {
        try {
          val batteryLevel = intent?.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
          val scale = intent?.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
          val level = (batteryLevel!! * 100) / scale!!
          val data = WritableNativeMap().apply {
            putInt("level", level)
          }
          event.sendEvent("batteryLevel", data)
        } catch (e: Exception) {
          e.printStackTrace()
        }
      }
    }

  }
}

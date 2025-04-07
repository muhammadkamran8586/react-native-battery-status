package com.batterystatus

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import com.facebook.react.bridge.BridgeReactContext.*
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.WritableNativeMap
import com.facebook.react.module.annotations.ReactModule

@ReactModule(name = BatteryStatusModule.NAME)
class BatteryStatusModule(reactContext: ReactApplicationContext) :
  NativeBatteryStatusSpec(reactContext) {
  var context: ReactApplicationContext = reactContext
  val event = Event(context)

  override fun getName(): String {
    return NAME
  }

  init {
    val intentFilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
    context.registerReceiver(BatteryLevelReceiver(context).batteryLevel, intentFilter)
    context.registerReceiver(PowerSourceReceiver(context).powerSource, intentFilter)
    context.registerReceiver(BatteryInfoReceiver(context).batteryInfo, intentFilter)
  }

  override fun getBatteryLevel(promise: Promise?) {
    TODO("Not yet implemented")
  }

  override fun isCharging(promise: Promise?) {
    TODO("Not yet implemented")
  }

  override fun getPowerSource(promise: Promise?) {
    TODO("Not yet implemented")
  }

  override fun isLowPowerMode(promise: Promise?) {
    TODO("Not yet implemented")
  }


  companion object {
    const val NAME = "BatteryStatus"
  }
}

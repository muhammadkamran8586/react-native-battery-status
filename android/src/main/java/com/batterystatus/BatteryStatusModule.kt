package com.batterystatus

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.PowerManager
import com.facebook.react.bridge.BridgeReactContext
import com.facebook.react.bridge.BridgeReactContext.*
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.WritableNativeMap
import com.facebook.react.module.annotations.ReactModule

@ReactModule(name = BatteryStatusModule.NAME)
class BatteryStatusModule(reactContext: ReactApplicationContext) :
  NativeBatteryStatusSpec(reactContext) {

  override fun getName(): String {
    return NAME
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

  init{


  }


  private fun sendEvent(eventName: String, params: WritableNativeMap) {
    reactApplicationContext
      .getJSModule(RCTDeviceEventEmitter::class.java)
      .emit(eventName, params)
  }

  companion object {
    const val NAME = "BatteryStatus"
  }
}

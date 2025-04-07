package com.batterystatus

import com.facebook.react.bridge.BridgeReactContext.RCTDeviceEventEmitter
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.WritableNativeMap

class Event(val context: ReactApplicationContext) {

  public fun sendEvent(eventName: String, params: WritableNativeMap) {
    context.getJSModule(RCTDeviceEventEmitter::class.java).emit(eventName, params)
  }

}

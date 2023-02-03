package com.mygaurdian.android.data.service

import android.accessibilityservice.AccessibilityService
import android.content.ContentValues.TAG
import android.util.Log
import android.view.accessibility.AccessibilityEvent

class MyAccessibilityService: AccessibilityService() {

    companion object{
        public var isBlockerOn: Boolean = false
    }

    override fun onAccessibilityEvent(event : AccessibilityEvent?) {

        if (isBlockerOn){
            Log.i(TAG , "onAccessibilityEvent: $event")
        }

    }

    override fun onInterrupt() {
        TODO("Not yet implemented")
    }

    override fun onServiceConnected() {
        super.onServiceConnected()

        Log.i(TAG , "onServiceConnected: is connected")
    }
}
package com.mygaurdian.android.ui

import android.accessibilityservice.AccessibilityServiceInfo
import android.content.Context
import android.view.accessibility.AccessibilityManager
import com.mygaurdian.android.data.service.MyAccessibilityService

class AccessibilityUtils {

    companion object{
        fun isAccessibilityServiceEnabled(context: Context , service: Class<MyAccessibilityService>): Boolean {
            val accessibilityManager = context.getSystemService(Context.ACCESSIBILITY_SERVICE) as AccessibilityManager
            val enabledServices = accessibilityManager.getEnabledAccessibilityServiceList(
                AccessibilityServiceInfo.FEEDBACK_ALL_MASK)
            for (enabledService in enabledServices) {
                if (enabledService.resolveInfo.serviceInfo.name == service.name) {
                    return true
                }
            }
            return false
        }
    }

}
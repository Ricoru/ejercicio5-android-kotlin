package com.oliva.marc.sesion5oruna.view.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast

fun Context.message(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun Activity.startActivities(activity: Class<*>, extra: Bundle?) {
    val intent = Intent(this, activity)
    intent.putExtras(extra!!)
    this.startActivity(intent)
}

fun Activity.startActivitiesResult(activity: Class<*>, extra: Bundle?, actionRequest: Int) {
    val intent = Intent(this, activity)
    if (extra != null) intent.putExtras(extra)
    this.startActivityForResult(intent, actionRequest)
}
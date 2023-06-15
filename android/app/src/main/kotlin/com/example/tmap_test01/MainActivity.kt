package com.example.tmap_test01

import android.content.Intent
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.android.FlutterFragment
import io.flutter.embedding.android.FlutterFragmentActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant

class MainActivity: FlutterFragmentActivity() {
    val Channel = "MyTmap"

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        // Flutter 메인화면에 보여지는 Android Native View 설정
//        flutterEngine.platformViewsController
//                .registry
//                .registerViewFactory()

        GeneratedPluginRegistrant.registerWith(flutterEngine)

        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, Channel)
                .setMethodCallHandler { call, result ->
                    if(call.method.equals("startTmapActivity")){
                        val intent = Intent(this, TMapActivity::class.java)
                        startActivity(intent)
                    }
                    else {
                        result.error("unavailable", "cannot start activity", null)
                    }
                }
    }
}

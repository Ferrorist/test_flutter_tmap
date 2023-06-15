﻿import 'package:geolocator/geolocator.dart';
import 'package:permission_handler/permission_handler.dart';

class GPSservice {
  static Future<bool> checkPermission() async {
    bool serviceEnabled = await Geolocator.isLocationServiceEnabled();
    if (!serviceEnabled) {
      return false;
    }

    LocationPermission permission = await Geolocator.checkPermission();
    if (permission == LocationPermission.denied ||
        permission == LocationPermission.deniedForever) {
      return await requestPermission();
    }
    return true;
  }

  // 권한 요청
  static Future<bool> requestPermission() async {
    var requestStatus = await Permission.location.request();
    var status = await Permission.location.status;
    if (requestStatus.isPermanentlyDenied || status.isPermanentlyDenied) {
      // 권한 요청 거부, 해당 권한에 대한 요청에 대해 다시 묻지 않음 선택하여 설정화면에서 변경해야함. android

      // openAppSettings();
      return false;
    } else if (status.isRestricted || status.isDenied) {
      // 권한 요청 거부, 해당 권한에 대한 요청을 표시하지 않도록 선택하여 설정화면에서 변경해야함. ios
      // openAppSettings();
      return false;
    }
    return true;
  }
}

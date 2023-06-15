import 'dart:developer';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import '../widgets/tmap_widget.dart';
import '../widgets/Hybrid_tmap_widget.dart';

class ScreenTmap extends StatefulWidget {
  const ScreenTmap({super.key});

  @override
  State<ScreenTmap> createState() => _ScreenTmapState();
}

class _ScreenTmapState extends State<ScreenTmap> {
  final platform = const MethodChannel("MyTmap");

  Future startActivity() async {
    try {
      await platform.invokeMethod("startTmapActivity");
    } on PlatformException catch (e) {
      log("Error: $e");
    }
  }

  @override
  void initState() {
    super.initState();
    Navigator.pop(context);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: TmapWidget(),
    );
  }
}

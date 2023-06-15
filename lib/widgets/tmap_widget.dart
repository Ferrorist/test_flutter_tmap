import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class TmapWidget extends StatelessWidget {
  TmapWidget({super.key});
  String ViewType = "Tmap";
  final Map<String, dynamic> creationParams = <String, dynamic>{};
  @override
  Widget build(BuildContext context) {
    return AndroidView(
      viewType: ViewType,
      layoutDirection: TextDirection.ltr,
      creationParams: creationParams,
      creationParamsCodec: const StandardMessageCodec(),
    );
  }
}

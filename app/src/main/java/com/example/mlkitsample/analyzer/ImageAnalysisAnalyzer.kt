package com.example.mlkitsample.analyzer

import androidx.camera.core.ImageAnalysis
import androidx.camera.mlkit.vision.MlKitAnalyzer
import androidx.camera.view.CameraController
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import com.google.mlkit.vision.interfaces.Detector

val LocalImageAnalysisAnalyzer = compositionLocalOf<ImageAnalysis.Analyzer?> {
    null
}

@Composable
fun <T> ImageAnalysisAnalyzer(
    detector: Detector<T>,
    targetCoordinateSystem: Int = CameraController.COORDINATE_SYSTEM_VIEW_REFERENCED,
    content: @Composable (T?) -> Unit,
) {
    var parsedResult by remember { mutableStateOf<T?>(null) }
    val context = LocalContext.current
    val analyzer = MlKitAnalyzer(
        listOf(detector),
        targetCoordinateSystem,
        context.mainExecutor,
    ) { result ->
        parsedResult = result.getValue(detector)
    }
    CompositionLocalProvider(
        LocalImageAnalysisAnalyzer provides analyzer,
    ) {
        content(parsedResult)
    }
}

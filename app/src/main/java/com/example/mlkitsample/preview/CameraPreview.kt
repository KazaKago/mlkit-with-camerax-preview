package com.example.mlkitsample.preview

import android.view.ViewGroup
import androidx.camera.core.CameraSelector
import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.PreviewView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import com.example.mlkitsample.analyzer.LocalImageAnalysisAnalyzer

@Composable
fun CameraPreview(
    modifier: Modifier = Modifier,
    scaleType: PreviewView.ScaleType = PreviewView.ScaleType.FILL_CENTER,
    cameraSelector: CameraSelector = CameraSelector.DEFAULT_BACK_CAMERA,
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val imageAnalyzer = LocalImageAnalysisAnalyzer.current
    AndroidView(
        modifier = modifier,
        factory = { context ->
            PreviewView(context).apply {
                this.scaleType = scaleType
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                )
                controller = LifecycleCameraController(context).apply {
                    setCameraSelector(cameraSelector)
                    bindToLifecycle(lifecycleOwner)

                    if (imageAnalyzer != null) {
                        clearImageAnalysisAnalyzer()
                        setImageAnalysisAnalyzer(context.mainExecutor, imageAnalyzer)
                    }
                }
            }
        }
    )
}

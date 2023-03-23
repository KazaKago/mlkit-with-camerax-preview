package com.example.mlkitsample.analyzer

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.mlkit.vision.face.Face
import com.google.mlkit.vision.face.FaceDetection

@Composable
fun FaceAnalyzer(
    modifier: Modifier = Modifier,
    content: @Composable (faces: List<Face>) -> Unit,
) {
    Box(modifier) {
        ImageAnalysisAnalyzer<List<Face>>(
            detector = FaceDetection.getClient(),
            content = { content(it ?: emptyList()) },
        )
    }
}

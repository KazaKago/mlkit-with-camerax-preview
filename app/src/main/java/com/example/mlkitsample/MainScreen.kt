package com.example.mlkitsample

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mlkitsample.analyzer.FaceAnalyzer
import com.example.mlkitsample.preview.CameraPreview
import com.example.mlkitsample.preview.PreviewOverlay
import com.example.mlkitsample.ui.theme.AppTheme

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MainScreen() {
    Scaffold {
        FaceAnalyzer(Modifier.padding(it)) { faces ->
            CameraPreview()
            faces.forEach { face ->
                PreviewOverlay(boundingBox = face.boundingBox)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    AppTheme {
        MainScreen()
    }
}

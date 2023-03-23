package com.example.mlkitsample.preview

import android.graphics.Rect
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

@Composable
fun PreviewOverlay(
    modifier: Modifier = Modifier,
    boundingBox: Rect,
) {
    val density = LocalDensity.current.density
    val offsetX = boundingBox.left / density
    val offsetY = boundingBox.top / density
    val width = (boundingBox.right - boundingBox.left) / density
    val height = (boundingBox.bottom - boundingBox.top) / density
    Box(
        modifier
            .offset(x = offsetX.dp, y = offsetY.dp)
            .size(width = width.dp, height = height.dp)
            .border(width = 2.dp, color = Color.Red),
    )
}

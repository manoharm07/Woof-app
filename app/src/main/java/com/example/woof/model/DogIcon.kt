package com.example.woof.model

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp





@Composable
fun DogIcon(
    @DrawableRes img : Int,
    modifier : Modifier
) {
    Image(
        painter = painterResource(img),
        contentDescription = null,
        modifier
            .padding(8.dp, 12.dp, 0.dp, 12.dp)
            .clip(MaterialTheme.shapes.medium)
            .size(width = 60.dp, 60.dp),
        contentScale = ContentScale.Crop
    )
}

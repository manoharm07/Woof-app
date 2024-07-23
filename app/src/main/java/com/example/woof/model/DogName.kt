package com.example.woof.model

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.woof.R


//@Composable
//fun DogName(
//    @StringRes name: Int,
//    modifier : Modifier
//) {
//    Text(
//        text = stringResource(name),
//        style = MaterialTheme.typography.headlineMedium,
//        modifier = Modifier.padding(
//            start = 16.dp,
//            top = 8.dp,
//            end = dimensionResource(R.dimen.padding_medium),
//            bottom = dimensionResource(R.dimen.padding_small)
//        )
//    )
//}
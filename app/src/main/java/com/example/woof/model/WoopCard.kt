package com.example.woof.model

import androidx.annotation.IntegerRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.woof.R
import com.example.woof.data.Dog


@Composable
fun WoofCard(
    data: Dog,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Row {
            DogIcon(data.imageResourceId, Modifier)
            Column {
                DogName(data.name)
                DogInfo(age = data.age, yr = R.string.years_old, modifier = modifier)
            }
            Spacer(modifier.weight(1f))
            DogIconButton(expanded = expanded, onClick = { expanded = !expanded })
        }
        if (expanded) {
            DogHobby(
                data.hobbies, modifier = Modifier.padding(16.dp)
            )
        }
    }
}


@Composable
fun DogName(
    @StringRes name: Int
) {
    Text(
        text = stringResource(name),
        style = MaterialTheme.typography.headlineMedium,
        modifier = Modifier.padding(
            start = 16.dp,
            top = 8.dp,
            end = dimensionResource(R.dimen.padding_medium),
            bottom = dimensionResource(R.dimen.padding_small)
        )
    )
}


@Composable
fun DogInfo(
    @IntegerRes age : Int,
    yr : Int,
    modifier: Modifier
){
    Text(
        text = stringResource(yr, age), // data.age.toString() + " years old "
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier
            .padding(16.dp, 0.dp, 8.dp, 8.dp)
    )
}


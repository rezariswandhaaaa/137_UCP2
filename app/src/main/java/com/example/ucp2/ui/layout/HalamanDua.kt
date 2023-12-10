package com.example.ucp2.ui.layout


import androidx.benchmark.perfetto.Row
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ucp2.R
import com.example.ucp2.data.SkripsiUIState


@Composable
fun HalamanDua(
    skripsiUIState: SkripsiUIState,
    onBackButtonClicked: () -> Unit
){
    val items = listOf(
        Pair(stringResource(R.string.pembimbing), skripsiUIState.dosen) ,
        Pair(stringResource(R.string.pembimbing1), skripsiUIState.dosen1)
    )

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ){

        Text(text = stringResource(id = R.string.namamhs))
        Text(text = skripsiUIState.nama)
        Divider()
        Spacer(modifier = Modifier.padding(16.dp))


        Text(text = stringResource(id = R.string.nim))
        Text(text = skripsiUIState.nim)
        Divider()
        Spacer(modifier = Modifier.padding(16.dp))


        Text(text = stringResource(id = R.string.konsen))
        Text(text = skripsiUIState.konsentrasi)
        Divider()
        Spacer(modifier = Modifier.padding(16.dp))

        Text(text = stringResource(id = R.string.judulskripsi))
        Text(text = skripsiUIState.judul)
        Divider()
        Spacer(modifier = Modifier.padding(8.dp))

        Column (
            modifier = Modifier.fillMaxWidth()
        ){
            items.forEach{ item ->
                Column (modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)){
                    Text(item.first.uppercase())
                    Text(text = item.second.toString(), fontWeight = FontWeight.Bold)
                }
                Divider(thickness = dimensionResource(R.dimen.thickness_divider))
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
            }

        }
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))

        Row{

            Button(
                modifier = Modifier.weight(1f),
                onClick = onBackButtonClicked

            ) {
                Text(text = stringResource(id = R.string.back))
            }
        }
    }
}
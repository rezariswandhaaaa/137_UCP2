@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package com.example.ucp2.ui.layout


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ucp2.R


@Composable
fun HalamanSatu(
    pilihanDosen: List<String>,
    onSelectionChanged: (String) -> Unit,
    onSubmitButtonClicked: (MutableList<String>) -> Unit,

){
    var namaText by remember { mutableStateOf("") }
    var nimText by remember { mutableStateOf("") }
    var konsenText by remember { mutableStateOf("") }
    var skripsiText by remember { mutableStateOf("") }
    var dosenYgDipilih by rememberSaveable { mutableStateOf("") }

    var listData : MutableList<String> = mutableListOf(namaText,nimText, konsenText,skripsiText,dosenYgDipilih)

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
    ){
        Row {
            Text(text = "Formulir Pengajuan Skripsi", fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = namaText,
            onValueChange = {namaText = it},
            label = { Text(text = stringResource(id = R.string.namamhs)) }
        )

        OutlinedTextField(
            value = nimText,
            onValueChange = {nimText = it},
            label = { Text(text = stringResource(id = R.string.nim)) }
        )

        OutlinedTextField(
            value = konsenText,
            onValueChange = {konsenText = it},
            label = { Text(text = stringResource(id = R.string.konsen)) }
        )
        OutlinedTextField(
            value = skripsiText,
            onValueChange = {skripsiText = it},
            label = { Text(text = stringResource(id = R.string.judulskripsi)) }
        )
        Spacer(modifier = Modifier.height(2.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween){
            Text(text = "Dosen Pembimbing 1", fontWeight = FontWeight.Bold)
            pilihanDosen.forEach { item ->

                Row(
                    modifier = Modifier.selectable(selected = dosenYgDipilih == item,
                        onClick = {
                            dosenYgDipilih = item
                            onSelectionChanged(item)
                        }
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    RadioButton(
                        selected = dosenYgDipilih == item,
                        onClick = {
                            dosenYgDipilih = item
                            onSelectionChanged(item)
                        }
                    )

                    Text(item)

                }
            }
            Text(text = "Dosen Pembimbing 2", fontWeight = FontWeight.Bold)
            pilihanDosen.forEach { item ->

                Row(
                    modifier = Modifier.selectable(selected = dosenYgDipilih == item,
                        onClick = {
                            dosenYgDipilih = item
                            onSelectionChanged(item)
                        }
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    RadioButton(
                        selected = dosenYgDipilih == item,
                        onClick = {
                            dosenYgDipilih = item
                            onSelectionChanged(item)
                        }
                    )

                    Text(item)

                }

            }
        }

        Spacer(modifier = Modifier.padding(5.dp))


        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.padding_medium))
            .weight(1f, false),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
            verticalAlignment = Alignment.Bottom
        ){
            Button(
                modifier = Modifier.weight(1f),
                onClick = {onSubmitButtonClicked(listData)}
            ){
                Text(stringResource(R.string.submit))
            }
        }

    }
}

@Preview
@Composable
fun HalamanSatuPreview() {
    val flavors = listOf("haris", "reza", "osamah")
    HalamanSatu(
        pilihanDosen = flavors,
        onSelectionChanged = {},
        onSubmitButtonClicked = {}
    )
}
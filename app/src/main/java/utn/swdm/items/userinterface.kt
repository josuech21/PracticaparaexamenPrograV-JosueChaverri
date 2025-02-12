package utn.swdm.items

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.*
import utn.swdm.items.ui.theme.ItemsTheme
import utn.swdm.items.viewmodel.ItemViewModel

@Composable
fun ItemListScreen(viewModel: ItemViewModel = hiltViewModel())
{
    val itemsList = viewModel.getItems()

    LazyColumn (
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    )
    {
        items(itemsList)
        {
            item -> ItemCard(item = item)

        }
    }

}

@Composable
fun ItemCard(item: String)
{

    var backgroundColor by remember { mutableStateOf(Color.White) }


    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable {
                println("Click en la carta : $item"  )
                backgroundColor = if (backgroundColor == Color.White)
                {
                    Color.Red
                } else
                {
                    Color.White
                }

            },
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.outlinedCardColors()
    )
    {
        Text(
            text = item,
            modifier = Modifier.padding(16.dp))

    }

}

@Preview
@Composable
fun ItemListScreenPreview()
{
    ItemsTheme {
        ItemListScreen()
    }
}

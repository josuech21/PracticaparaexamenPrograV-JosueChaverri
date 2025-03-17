package utn.swdm.items

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import utn.swdm.items.data.database.model.Item
import utn.swdm.items.ui.theme.ItemsTheme
import utn.swdm.items.viewmodel.ItemViewModel

@Composable
fun ItemListScreen(viewModel: ItemViewModel = hiltViewModel()) {
    // Observar la lista de ítems desde el ViewModel
    val items by viewModel.items.collectAsState(initial = emptyList())

    // Cargar los ítems cuando la pantalla se inicia
    LaunchedEffect(Unit) {
        viewModel.loadItems()
    }

    // Mostrar la lista de ítems
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Abrir diálogo para agregar un ítem */ },
                modifier = Modifier.padding(16.dp)
            ) {
                Icon(Icons.Default.Add, contentDescription = "Agregar ítem")
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(items, key = { it.id }) { item ->
                ItemCard(
                    item = item,
                    onItemClick = { viewModel.updateItemSelection(item.id, !item.isSelected) },
                    onDeleteClick = { viewModel.deleteItem(item.id) }
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun ItemCard(
    item: Item,
    onItemClick: () -> Unit,
    onDeleteClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (item.isSelected) Color.LightGray else Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = item.name,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = if (item.isSelected) "Seleccionado" else "No seleccionado",
                color = if (item.isSelected) Color.Green else Color.Red
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Eliminar",
                color = Color.Red,
                modifier = Modifier.clickable { onDeleteClick() }
            )
        }
    }
}

@Composable
fun ItemListScreenPreview() {
    ItemsTheme {
        ItemListScreen()
    }
}

@Composable
fun ItemCardPreview() {
    ItemsTheme {
        ItemCard(
            item = Item(id = 1, name = "Ítem de ejemplo", isSelected = false),
            onItemClick = {},
            onDeleteClick = {}
        )
    }
}
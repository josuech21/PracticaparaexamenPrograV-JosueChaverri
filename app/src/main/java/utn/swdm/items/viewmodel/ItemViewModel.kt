package utn.swdm.items.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import utn.swdm.items.data.database.model.Item
import utn.swdm.items.repository.ItemRepository
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(
    private val repository: ItemRepository
) : ViewModel() {

    // Estado privado para la lista de ítems
    private val _items = MutableStateFlow<List<Item>>(emptyList())
    val items: StateFlow<List<Item>> get() = _items.asStateFlow()

    init {
        // Cargar los ítems cuando se crea el ViewModel
        loadItems()
    }

    // Cargar los ítems desde el repositorio
     fun loadItems() {
        viewModelScope.launch {
            repository.getAllItems().collect { items ->
                _items.value = items
            }
        }
    }

    // Agregar un ítem
    fun addItem(item: Item) {
        viewModelScope.launch {
            repository.addItem(item)
        }
    }

    // Eliminar un ítem
    fun deleteItem(itemId: Long) {
        viewModelScope.launch {
            repository.deleteItem(itemId)
        }
    }

    // Actualizar el estado de selección de un ítem
    fun updateItemSelection(itemId: Long, isSelected: Boolean) {
        viewModelScope.launch {
            repository.updateItemSelection(itemId, isSelected)
        }
    }
}
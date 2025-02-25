package utn.swdm.items.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import javax.inject.Inject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import utn.swdm.items.data.database.model.Item
import utn.swdm.items.data.database.repository.ItemRepository

@HiltViewModel
class ItemViewModel @Inject constructor(
    private val repository: ItemRepository
) : ViewModel()
{
    val allItems: LiveData<List<Item>> get() = repository.getAllItem()

    fun insert(item: Item) = viewModelScope
        .launch{
            repository.insert(item)
        }
    fun update(item: Item) = viewModelScope.launch{
        repository.update(item)
    }
    fun deleteItem(item: Item) = viewModelScope.launch {
        repository.delete(item)
    }
    fun deleteAll() = viewModelScope.launch {
        repository.deleteAll()
    }


}
package utn.swdm.items.viewmodel

import androidx.lifecycle.ViewModel
import javax.inject.Inject
import dagger.hilt.android.lifecycle.HiltViewModel
import utn.swdm.items.repository.ItemRepository


@HiltViewModel
class ItemViewModel @Inject constructor(
    private val repository: ItemRepository
) : ViewModel()
{
    fun getItems() : List<String>
    {
        return repository.getItems()
    }
}
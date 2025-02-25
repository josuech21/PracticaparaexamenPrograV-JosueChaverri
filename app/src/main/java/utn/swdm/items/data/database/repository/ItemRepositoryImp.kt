package utn.swdm.items.data.database.repository

import androidx.lifecycle.LiveData
import utn.swdm.items.data.database.interfaces.ItemDao
import utn.swdm.items.data.database.model.Item
import javax.inject.Inject

class ItemRepository @Inject constructor(private val itemDao: ItemDao)
{
    fun getAllItem() : LiveData<List<Item>>
    {
        return itemDao.getAllItems()
    }
    suspend fun insert(item: Item)
    {
        itemDao.insert(item)
    }
    suspend fun update(item: Item)
    {
        itemDao.update(item)
    }
    suspend fun  deleteAll()
    {
        itemDao.deleteAllItems()
    }
    suspend fun delete(item: Item)
    {
        itemDao.delete(item)
    }
}

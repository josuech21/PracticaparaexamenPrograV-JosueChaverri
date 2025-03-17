package utn.swdm.items.repository

import kotlinx.coroutines.flow.Flow
import utn.swdm.items.data.database.interfaces.ItemDao
import utn.swdm.items.data.database.model.Item
import javax.inject.Inject

class ItemRepository @Inject constructor(private val itemDao: ItemDao) {

    // Obtener todos los ítems (observable con Flow)
    fun getAllItems(): Flow<List<Item>> = itemDao.getAllItems()

    // Obtener un ítem por su ID (observable con Flow)
    fun getItemById(itemId: Long): Flow<Item?> = itemDao.getItemById(itemId)

    // Insertar un ítem y devolver su ID
    suspend fun addItem(item: Item): Long = itemDao.insertItem(item)

    // Eliminar un ítem por su ID
    suspend fun deleteItem(itemId: Long) = itemDao.deleteItem(itemId)

    // Actualizar el estado de selección de un ítem
    suspend fun updateItemSelection(itemId: Long, isSelected: Boolean) =
        itemDao.updateItemSelection(itemId, isSelected)

    // Actualizar el nombre de un ítem
    suspend fun updateItemName(itemId: Long, name: String) =
        itemDao.updateItemName(itemId, name)
}
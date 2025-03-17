package utn.swdm.items.data.database.interfaces

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import utn.swdm.items.data.database.model.Item

@Dao
interface ItemDao {

    // Obtener todos los ítems (observable con Flow)
    @Query("SELECT * FROM items")
    fun getAllItems(): Flow<List<Item>>

    // Obtener un ítem por su ID
    @Query("SELECT * FROM items WHERE id = :itemId")
    fun getItemById(itemId: Long): Flow<Item?>

    // Insertar un ítem y devolver su ID
    @Insert
    suspend fun insertItem(item: Item): Long

    // Eliminar un ítem por su ID
    @Query("DELETE FROM items WHERE id = :itemId")
    suspend fun deleteItem(itemId: Long)

    // Actualizar el estado de selección de un ítem
    @Query("UPDATE items SET isSelected = :isSelected WHERE id = :itemId")
    suspend fun updateItemSelection(itemId: Long, isSelected: Boolean)

    // Actualizar el nombre de un ítem
    @Query("UPDATE items SET name = :name WHERE id = :itemId")
    suspend fun updateItemName(itemId: Long, name: String)
}
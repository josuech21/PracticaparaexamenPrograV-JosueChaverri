package utn.swdm.items.data.database.interfaces

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import utn.swdm.items.data.database.model.Item

@Dao
interface ItemDao
{
    @Insert
    suspend fun insert(item: Item)

    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)

    @Query("DELETE From items")
    suspend fun deleteAllItems()

    @Query("SELECT * FROM items order by id")
    fun getAllItems(): LiveData<List<Item>>

}
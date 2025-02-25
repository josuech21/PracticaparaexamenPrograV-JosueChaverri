package utn.swdm.items.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import utn.swdm.items.data.database.interfaces.ItemDao
import utn.swdm.items.data.database.model.Item

@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase()
{

    abstract fun itemDao(): ItemDao

    companion object
    {
        @Volatile
        private var INSTANCE: AppDataBase?=null

        fun getDatabase(context: Context): AppDataBase
        {
            return INSTANCE?: synchronized(this)
            {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "item_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }

    }
}
package utn.swdm.items.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope
import utn.swdm.items.data.database.interfaces.ItemDao
import utn.swdm.items.data.database.model.Item

@Database(
    entities = [Item::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun itemDao(): ItemDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        // Obtener la instancia de la base de datos
        fun getDatabase(
            context: Context,
            coroutineScope: CoroutineScope? = null
        ): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "item_database"
                )
                    // Agregar un CoroutineScope si es necesario
                    .apply {
                        coroutineScope?.let { scope ->
                            // Asociar la base de datos con un CoroutineScope
                            // (útil para operaciones en segundo plano)
                        }
                    }
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
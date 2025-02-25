package utn.swdm.items.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "items")
data class Item(
            @PrimaryKey(autoGenerate = true)
            val id : Long =0,
            val name : String = "",
            val isSelected : Boolean = false
            )
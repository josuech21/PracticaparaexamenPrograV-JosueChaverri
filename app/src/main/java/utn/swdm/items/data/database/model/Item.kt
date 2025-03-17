package utn.swdm.items.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "items")
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String = "",
    val isSelected: Boolean = false,
    val description: String = "",  // Nuevo campo: Descripción del ítem
    val createdAt: Date = Date()   // Nuevo campo: Fecha de creación
) {
    init {
        // Validación: El nombre no puede estar vacío
        require(name.isNotBlank()) { "El nombre del ítem no puede estar vacío" }
    }
}
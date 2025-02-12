package utn.swdm.items.repository

interface ItemRepository
{
    fun getItems(): List<String>
}
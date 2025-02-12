package utn.swdm.items.repository

import javax.inject.Inject

class ItemRepositoryImp @Inject constructor() : ItemRepository
{
    override fun getItems(): List<String>
    {
        return listOf("Casa","Edificio","Parque","Frutas","Animales","Algo 1","Algo 2","Algo 3","TEST","TEST 2","TEST 3")
    }
}

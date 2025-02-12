package utn.swdm.items.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import utn.swdm.items.repository.ItemRepository
import utn.swdm.items.repository.ItemRepositoryImp
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule
{
    @Provides
    @Singleton
    fun provideItemRepository(): ItemRepository
    {
        return ItemRepositoryImp()
    }
}
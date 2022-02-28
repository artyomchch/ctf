package kozlov.artyom.ctf.di

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import kozlov.artyom.ctf.data.database.AppDatabase
import kozlov.artyom.ctf.data.database.ValueListDao
import kozlov.artyom.ctf.data.network.CurrencyApi
import kozlov.artyom.ctf.data.network.RetrofitInstance
import kozlov.artyom.ctf.data.repository.ValueListRepositoryImpl
import kozlov.artyom.ctf.domain.repository.ValueListRepository

@Module
interface ValueDomainModule {

    @ApplicationScope
    @Binds
    fun bindNewsListRepository(impl: ValueListRepositoryImpl): ValueListRepository

    companion object {
        @ApplicationScope
        @Provides
        fun provideAppInternet(): CurrencyApi {
            return RetrofitInstance.api
        }

        @ApplicationScope
        @Provides
        fun provideAppDatabase(context: Context): ValueListDao {
            return AppDatabase.getInstance(context).valueListDao()
        }
    }

}
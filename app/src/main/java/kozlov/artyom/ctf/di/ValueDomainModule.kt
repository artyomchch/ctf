package kozlov.artyom.ctf.di

import dagger.Binds
import dagger.Module
import dagger.Provides
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
    }

}
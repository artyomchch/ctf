package kozlov.artyom.ctf.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kozlov.artyom.ctf.presentation.activity.MainActivity

@ApplicationScope
@Component(
    modules = [ValueDomainModule::class, ViewModelModule::class]
)
interface ApplicationComponent {

    fun inject(activity: MainActivity)


    @Component.Factory
    interface ApplicationComponentFactory {

        fun create(
            @BindsInstance context: Context
        ): ApplicationComponent
    }
}
package kozlov.artyom.ctf.utils

import android.app.Application
import kozlov.artyom.ctf.di.DaggerApplicationComponent

class App : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory()
            .create(this)
    }
}
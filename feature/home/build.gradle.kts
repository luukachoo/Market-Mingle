plugins {
    id(Plugins.ANDROID_LIBRARY)
    id(Plugins.KOTLIN_ANDROID)
    id(Plugins.GMS_SERVICES)
}

apply<MainGradlePlugin>()

android {
    namespace = ModulePackages.FEATURE_HOME

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    basic()
    navigationComponent()
    glide()
    fireBaseAuth()
    firebaseDataBase()

    // core
    domain()
    common()
}
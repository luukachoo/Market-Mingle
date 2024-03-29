plugins {
    id(Plugins.ANDROID_LIBRARY)
    id(Plugins.KOTLIN_ANDROID)
}

apply<MainGradlePlugin>()

android {
    namespace = ModulePackages.FEATURE_WELCOME

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    basic()
    daggerHilt()
    navigationComponent()
    lottie()

    // core
    common()
    coreUi()
}
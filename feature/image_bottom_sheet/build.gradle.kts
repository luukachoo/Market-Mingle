plugins {
    id(Plugins.ANDROID_LIBRARY)
    id(Plugins.KOTLIN_ANDROID)
}

apply<MainGradlePlugin>()

android {
    namespace = ModulePackages.FEATURE_BOTTOM_SHEET

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    basic()
    navigationComponent()
    glide()

    // core
    domain()
    common()
    coreUi()
    workManager()
}
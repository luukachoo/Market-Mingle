plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

apply<MainGradlePlugin>()

android {
    namespace = "com.core.domain"
}

dependencies {
    basic()

    // core
    common()
}
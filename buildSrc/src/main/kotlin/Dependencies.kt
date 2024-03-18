import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

object Dependencies {
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintlayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
    const val junit = "junit:junit:${Versions.junit}"
    const val androidxTestExtJunit = "androidx.test.ext:junit:${Versions.androidxTestExtJunit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"

    // Retrofit and Moshi with OkHttp
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofitVersion}"
    const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.moshiVersion}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttpVersion}"
    const val okhttpInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpVersion}"

    // Dagger - Hilt
    const val daggerHilt = "com.google.dagger:hilt-android:${Versions.hiltVersion}"
    const val daggerHiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hiltVersion}"
    const val daggerHiltAgp = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltVersion}"

    // Glide
    const val glide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"

    // Room
    const val roomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    const val roomCoroutine = "androidx.room:room-ktx:${Versions.roomVersion}"

    // Navigation Component
    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}"
    const val androidxNavigationSafeArgsGradlePlugin =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigationVersion}"

    // Firebase
    const val firebaseAgp = "com.google.gms:google-services:${Versions.gmsVersion}"
    const val firebaseAuth = "com.google.firebase:firebase-auth:${Versions.firebaseAuthVersion}"
    const val firebaseStorage =
        "com.google.firebase:firebase-storage-ktx:${Versions.firebaseDatabaseVersion}"
    const val firebaseDatabase =
        "com.google.firebase:firebase-database:${Versions.firebaseDatabaseVersion}"
    const val firebaseMessaging =
        "com.google.firebase:firebase-messaging:${Versions.firebaseMessaging}"
    const val firebaseBom =
        "com.google.firebase:firebase-bom:${Versions.firebaseBom}"
    const val firebaseAnalytics =
        "com.google.firebase:firebase-analytics-ktx:${Versions.firebaseAnalytics}"

    // WorkManager
    const val workManager = "androidx.work:work-runtime-ktx:${Versions.workManagerVersion}"

    const val lottie =
        "com.airbnb.android:lottie:${Versions.lottieVersion}"

    const val oauth2 =
        "com.google.auth:google-auth-library-oauth2-http:${Versions.oauth2}"
}

fun DependencyHandler.basic() {
    implementation(Dependencies.coreKtx)
    implementation(Dependencies.appcompat)
    implementation(Dependencies.material)
    implementation(Dependencies.constraintlayout)
    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.androidxTestExtJunit)
    androidTestImplementation(Dependencies.espressoCore)
}

fun DependencyHandler.workManager() {
    implementation(Dependencies.workManager)
}

fun DependencyHandler.firebaseDataBase() {
    implementation(Dependencies.firebaseDatabase)
}

fun DependencyHandler.fireBaseAuth() {
    implementation(Dependencies.firebaseAuth)
}

fun DependencyHandler.firebaseStorage() {
    implementation(Dependencies.firebaseStorage)
}

fun DependencyHandler.firebaseMessaging() {
    implementation(Dependencies.firebaseMessaging)
    implementation(Dependencies.firebaseAnalytics)
    implementation(platform(Dependencies.firebaseBom))
}

fun DependencyHandler.oauth2() {
    implementation(Dependencies.oauth2)
}

fun DependencyHandler.room() {
    implementation(Dependencies.roomRuntime)
    implementation(Dependencies.roomCoroutine)
    ksp(Dependencies.roomCompiler)
}

fun DependencyHandler.retrofit() {
    implementation(Dependencies.retrofit)
    implementation(Dependencies.moshiConverter)
    implementation(Dependencies.moshi)
    implementation(Dependencies.okhttp)
    implementation(Dependencies.okhttpInterceptor)
}

fun DependencyHandler.daggerHilt() {
    implementation(Dependencies.daggerHilt)
    kapt(Dependencies.daggerHiltCompiler)
}

fun DependencyHandler.navigationComponent() {
    implementation(Dependencies.navigationFragment)
    implementation(Dependencies.navigationUi)
}

fun DependencyHandler.lottie() {
    implementation(Dependencies.lottie)
}

fun DependencyHandler.glide() {
    implementation(Dependencies.glide)
}

// example of how to implement modules
fun DependencyHandler.featureWelcome() {
    implementation(project(":feature:welcome"))
}

fun DependencyHandler.featureLogin() {
    implementation(project(":feature:login"))
}

fun DependencyHandler.featureRegister() {
    implementation(project(":feature:registration"))
}

fun DependencyHandler.featureHome() {
    implementation(project(":feature:home"))
}

fun DependencyHandler.featureForgotPassword() {
    implementation(project(":feature:forgot_password"))
}

fun DependencyHandler.featureProfile() {
    implementation(project(":feature:profile"))
}

fun DependencyHandler.featureImageBottomSheet() {
    implementation(project(":feature:image_bottom_sheet"))
}

fun DependencyHandler.featureSplashScreen() {
    implementation(project(":feature:splash_screen"))
}

fun DependencyHandler.featureLiveMatches() {
    implementation(project(":feature:live_matches"))
}

fun DependencyHandler.featurePastMatches() {
    implementation(project(":feature:past_matches"))
}

fun DependencyHandler.featureSeries() {
    implementation(project(":feature:series"))
}

fun DependencyHandler.featureUpcomingMatches() {
    implementation(project(":feature:upcoming_matches"))
}

fun DependencyHandler.featureLiveMatchDetails() {
    implementation(project(":feature:live_match_details"))
}

fun DependencyHandler.data() {
    implementation(project(":core:data"))
}

fun DependencyHandler.common() {
    implementation(project(":core:common"))
}

fun DependencyHandler.domain() {
    implementation(project(":core:domain"))
}

fun DependencyHandler.featureTournament() {
    implementation(project(":feature:tournament"))
}

fun DependencyHandler.featureChats() {
    implementation(project(":feature:chats"))
}

fun DependencyHandler.friendRequest() {
    implementation(project(":feature:friend_request"))
}
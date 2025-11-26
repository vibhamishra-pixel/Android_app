plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)   // ok to keep even if most of your code is Java
    // you can remove compose plugin if you’re not using Compose UI:
    // alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.myapplication"

    // pick any installed API, 34 or 35 – you showed 35 in SDK manager, so:
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    // Java code compatibility (Android only really supports up to 8 features)
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    // This is only for any Kotlin files Gradle might see; safe to leave
    kotlinOptions {
        jvmTarget = "11"
    }

    // We’re not using Jetpack Compose for the WebView screen
    buildFeatures {
        compose = false
    }
}

dependencies {
    // from your version catalog – fine to keep
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    // *** IMPORTANT: these two must be in quotes ***
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

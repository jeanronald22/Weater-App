plugins {
	alias(libs.plugins.android.application)
	alias(libs.plugins.kotlin.android)
	alias(libs.plugins.kotlin.compose)
	id("kotlin-kapt")
	id("dagger.hilt.android.plugin")
}

android {
	namespace = "com.training.weaterapp"
	compileSdk {
		version = release(36)
	}

	defaultConfig {
		applicationId = "com.training.weaterapp"
		minSdk = 27
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
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_11
		targetCompatibility = JavaVersion.VERSION_11
	}
	kotlinOptions {
		jvmTarget = "11"
	}
	buildFeatures {
		compose = true
	}
}

dependencies {
	implementation(libs.retrofit)
	implementation("com.google.code.gson:gson:2.13.2")
	implementation("androidx.room:room-runtime:2.8.4")
	implementation("com.google.accompanist:accompanist-systemuicontroller:0.30.1")
	implementation("com.squareup.retrofit2:converter-gson:2.9.0")
	implementation("io.coil-kt:coil-compose:2.6.0")
	implementation(libs.hilt.android)
	kapt(libs.hilt.compiler)
	implementation(libs.androidx.hilt.navigation.compose)
	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.lifecycle.runtime.ktx)
	implementation(libs.androidx.activity.compose)
	implementation(platform(libs.androidx.compose.bom))
	implementation(libs.androidx.compose.ui)
	implementation(libs.androidx.compose.ui.graphics)
	implementation(libs.androidx.compose.ui.tooling.preview)
	implementation(libs.androidx.compose.material3)
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)
	androidTestImplementation(platform(libs.androidx.compose.bom))
	androidTestImplementation(libs.androidx.compose.ui.test.junit4)
	debugImplementation(libs.androidx.compose.ui.tooling)
	debugImplementation(libs.androidx.compose.ui.test.manifest)
}
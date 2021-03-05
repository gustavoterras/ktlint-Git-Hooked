import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        jcenter()
        maven("https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.1.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.30")
        classpath("org.jlleitschuh.gradle:ktlint-gradle:10.0.0")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

subprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint") // Version should be inherited from parent

    // Optionally configure plugin
    configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
        version.set("0.40.0")
        debug.set(true)
        verbose.set(true)
        android.set(false)
        outputToConsole.set(true)
        outputColorName.set("RED")
        ignoreFailures.set(true)
        enableExperimentalRules.set(true)
        additionalEditorconfigFile.set(file("/some/additional/.editorconfig"))
        disabledRules.set(setOf("final-newline"))
        reporters {
            reporter(ReporterType.PLAIN)
            reporter(ReporterType.CHECKSTYLE)

//            customReporters {
//                register("csv") {
//                    fileExtension = "csv"
//                    dependency = project(":project-reporters:csv-reporter")
//                }
//                register("yaml") {
//                    fileExtension = "yml"
//                    dependency = "com.example:ktlint-yaml-reporter:1.0.0"
//                }
//            }
        }
//        kotlinScriptAdditionalPaths {
//            include(fileTree("scripts/"))
//        }
        filter {
            exclude("**/generated/**")
            include("**/kotlin/**")
        }
    }

//    dependencies {
//        ktlintRuleset(project(":rules"))
//    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks {
    val clean by registering(Delete::class) {
        delete(buildDir)
    }
}
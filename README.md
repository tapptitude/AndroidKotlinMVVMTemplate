[![Kotlin Version](https://img.shields.io/badge/kotlin-1.8.21-blue.svg)](http://kotlinlang.org/)
[![Gradle](https://img.shields.io/badge/gradle-8.1.1-blue.svg)](https://lv.binarybabel.org/catalog/gradle/latest)
[![API](https://img.shields.io/badge/API-26%2B-blue.svg)](https://android-arsenal.com/api?level=26)
[![License](https://img.shields.io/badge/License-MIT-lightgrey.svg)](https://en.wikipedia.org/wiki/MIT_License)

# Tapptitude's Android Template

A 100% Kotlin-based project template that helps us kick start our Android projects.

## Main features

- Dependencies managed
  through [Gradle version catalogs](https://docs.gradle.org/current/userguide/platforms.html#sub:version-catalog) `*.toml`
- Application signing, flavors & dimensions setup done
  in  [`convention`](gradle/build-logic/convention)
  using [convention plugins](https://docs.gradle.org/current/userguide/sharing_build_logic_between_subprojects.html#sec:convention_plugins)
- Supports `dev` & `production` flavors out of the box
- Lays the foundation for independent core business & presentation modules [`network`](#network), [`logger`](#logger)
  , [`persistence`](#persistence), [`session`](#session)
- Dependency updates management is done through [`gradle-versions`](https://github.com/ben-manes/gradle-versions-plugin)

## Quick setup

1. Click the [`Use this template`](https://github.com/tapptitude/AndroidKotlinMVVMTemplate/generate) button on this page
   to generate your own project using this template or clone the project.
2. Open the project in Android Studio.
3. Run the [customize](customize.kts) Kotlin script by right clicking the file and select `Run 'customize.kts`. The script will prompt
   you to input the package and app name.
4. Sync the project.
5. Update signing configuration available in the Gradle DSL
   plugin [`SigningConfigPlugin`](gradle/build-logic/convention/src/main/kotlin/SigningConfigPlugin.kt)

## Gradle structure

The template uses Gradle Kotlin DSL for build setup.

Dependencies are organized into a `toml` configuration file - [`libs.versions.toml`](gradle/libs.versions.toml).

Common module setup is done using [convention plugins](gradle/build-logic/convention/src/main/kotlin). The approach is based
on [https://github.com/android/nowinandroid](https://github.com/android/nowinandroid).
Modules should choose the plugin they need and specify it in the `plugins { }` section of the `build.gradle.kts`.

Android specific configuration is available in the [`Android`](gradle/build-logic/convention/src/main/kotlin/configuration/Android.kt)
class.

## Architecture considerations

This template adheres to the following architectural principles:

- An [MVVM](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93viewmodel) (Model-View-ViewModel) approach has been
  used for facilitating the GUI / business separation concerns.
- The app module uses a single-activity architecture, based on
  the [Navigation component](https://developer.android.com/guide/navigation/navigation-getting-started) for navigation
  operations.
- It follows the [S.O.L.I.D.](https://en.wikipedia.org/wiki/SOLID) software principles which help increasing flexibility
  & maintainability while keeping the code readable.
- A modular approach was used in order to improve on
  the [separation of concerns](https://en.wikipedia.org/wiki/Separation_of_concerns) topic, while also helping with
  isolating feature functionalities. This aspect also helps on the build speed on the long run as only modified modules
  will be recompiled at each run.

## Modules

```mermaid
    graph TD;
        app-->feature:home;
        feature:home-->core;
        feature:home-->session;
        feature:home-->logger;
        feature:home-->config;
        feature:home-->foundation:ui;
        core-->network;
        core-->persistence;
        network-->session;
        network-->config;
        logger-->config;
```

### app

The app module is the central place for all the other modules. It consists of a single `Activity` which hosts all the
navigation inside the app and provides basic UI functionality for `featureX` modules.

### featureHome

Represents a sample implementation of a `feature` module. It showcases how the `core` module provides all the needed
domain layer logic and the `feature` module focuses only on
the [presentation](https://developer.android.com/jetpack/guide/ui-layer) (also knows as the UI) layer.

### core

It gathers logic from `network` & `persistence` modules and creates the required infrastructure to host the business
level `Repositories` and `UseCases` that it later exposes to the `featureX` layer modules. It also hosts the UI models
and their respective converters. Most of the common business code is also hosted here (it's basically
a [domain layer](https://developer.android.com/jetpack/guide/domain-layer)).

### network

Provides a place to implement everything that's network related. It handles logic related to API calls, DTO models,
session handling through authentication headers and network level error handling. It
uses [Retrofit](https://square.github.io/retrofit/) & [okhttp](https://square.github.io/okhttp/) for the network layer
implementation and [Moshi](https://github.com/square/moshi) for `json` parsing.

### persistence

Provides a place to implement everything that's database caching related. It handles the logic for creating and migrating the database.
It also exposes a `Dao` for each database table, so that the `core` module can perform actions on each table. It uses
[Room](https://developer.android.com/training/data-storage/room) as the database implementation.

### session

It handles everything related to a user session and saves current login state. Provides a way to listen for such state
changes, while giving data about the current user and authentication information. It
uses [Jetpack DataStore](https://developer.android.com/topic/libraries/architecture/datastore) under the hood for
storing key-value pairs asynchronously.

### logger

Provides an implementation of basic console logging capabilities that can be easily extended to write to a file or any
other use case. It uses [Timber](https://github.com/JakeWharton/timber) in the underlying implementation.

### config

Provides build specific configuration to any module that needs it. Provided information is related to:

- app version code
- app version name
- app package identifier
- build flavor
- debug mode

## Code style

This project uses [ktlint](https://github.com/pinterest/ktlint), provided via the [spotless](https://github.com/diffplug/spotless)
gradle plugin.

Before pushing any code to the repository, please run the [spotlessApply](.run/spotlessApply.run.xml) configuration to fix any
code style issues. You can also do this via command line by running `./gradlew spotlessApply`

## License

Copyright © 2022 [Tapptitude](https://www.tapptitude.com/)

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit
persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

/*
 * Copyright (c) 2026 ghostflyby
 * SPDX-FileCopyrightText: 2026 ghostflyby
 * SPDX-License-Identifier: LGPL-3.0-or-later
 */

rootProject.name = "kotlin-sdk"

// When included as a composite build, skip modules that pull heavy plugins.
val composite = providers.gradleProperty("mcp.sdk.composite").orNull == "true"

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }

    plugins {
        id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

include(
    ":test-utils",
    ":kotlin-sdk-core",
    ":kotlin-sdk-server",
    ":kotlin-sdk-client",
    ":kotlin-sdk-testing",
)

if (!composite) {
    include(
        ":kotlin-sdk-client",
        ":kotlin-sdk-testing",
        ":kotlin-sdk",
        ":integration-test",
        ":docs",
        ":conformance-test",
    )
}

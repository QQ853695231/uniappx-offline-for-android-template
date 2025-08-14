# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a uni-app x offline packaging template for Android development. The project demonstrates how to build native Android apps using uni-app x framework with offline compilation, including a comprehensive UI component library (cool-ui) and demo pages showcasing various UI elements and functionality.

## Architecture

### Multi-Module Structure
- **app**: Main Android application module that integrates the uni-app x runtime
- **uniappx**: Core uni-app x library module containing:
  - Kotlin/UTS transpiled pages and components 
  - UI component library (cool-ui) with 50+ components
  - Assets for the uni-app x application
- **kux-request**: HTTP request utility module

### Key Components
- **UTS Runtime**: Uses custom UTS (UniApp TypeScript) plugins for Kotlin compilation
- **Component Registration**: Video components and lifecycle hooks registered in App.kt
- **Asset Management**: App assets stored in `uniappx/src/main/assets/apps/__UNI__BC2A3BF/`
- **Native Libraries**: 20+ AAR files in `libs/` directory provide uni-app x runtime functionality

## Development Commands

### Build Commands
```bash
# Build debug APK
./gradlew assembleDebug

# Build release APK  
./gradlew assembleRelease

# Clean build artifacts
./gradlew clean
```

### Testing
```bash
# Run unit tests
./gradlew test

# Run instrumented tests
./gradlew connectedAndroidTest
```

### Development Tools
```bash
# Check dependencies
./gradlew dependencies

# Lint check
./gradlew lint
```

## Key Configuration Files

### App ID Configuration
- App ID is set to `__UNI__BC2A3BF` in:
  - `uniappx/src/main/AndroidManifest.xml` (DCLOUD_UNI_APPID meta-data)
  - App assets directory name
  - `manifest.json` file

### Build Configuration
- **Target SDK**: 34, **Min SDK**: 21
- **UTS Plugins**: Custom Kotlin compiler and Gradle plugins in `plugins/`
- **Dependencies**: Extensive Android libraries including Material Design, Fresco, Glide, Coroutines
- **ProGuard**: Configured but disabled in release builds

### UTS Component Registration
- Video components registered via `UTSRegisterComponents` build config
- Custom lifecycle hooks through `UTSAndroidHookProxy`
- Components must be registered in `App.kt` with proper error handling

## Important Notes

- The `uniappx/src/main/java/index.kt` file is very large (1.2MB+) - contains all transpiled UTS/TypeScript code
- Cool-UI component library provides comprehensive UI elements organized by category (basic, data, feedback, form, layout, other, status)  
- App uses both debug and release variants with different application ID suffixes
- Native libraries in `libs/` are essential for uni-app x runtime functionality
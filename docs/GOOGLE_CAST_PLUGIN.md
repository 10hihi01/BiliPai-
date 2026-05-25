# Google Cast Plugin Project

This is the single entry point for the BiliPai Google Cast plugin work. Keep it concise, update it after each completed slice, and remove stale details instead of adding parallel notes.

If `docs/GOOGLE_CAST_PLUGIN.local.md` exists, read it after this file for machine-specific environment notes. That local file is intentionally ignored and must not be committed.

## Working Rules

- Build this as a BiliPai source-level native Kotlin plugin.
- Use sub-agent driven development: architecture, task slicing, review, and verification stay with the controller; coding slices are implemented through `claude -p`.
- After every completed slice, update this file so another worker can resume quickly.
- Keep documentation progressive: this file is the only project entry. Link to existing repo docs only when needed.
- Avoid unnecessary files. Delete obsolete notes and update stale information immediately.
- Use `D:\Temp` for temporary scratch data if needed; avoid writing to `C:` unless a tool requires it.
- Do not work directly on `main`; use the `feature/google-cast-plugin` worktree at `D:\DATA\Codes\BiliPai\worktrees\google-cast-plugin`.
- Branch names, commits, PR titles, and PR bodies must use normal human engineering wording without tool or authorship labels.

## Existing Context

- Native plugins are registered in `app/src/main/java/com/android/purebilibili/app/PureApplication.kt`.
- The plugin framework lives in `app/src/main/java/com/android/purebilibili/core/plugin/`.
- Built-in plugins live in `app/src/main/java/com/android/purebilibili/feature/plugin/`.
- Existing DLNA casting lives in `app/src/main/java/com/android/purebilibili/feature/cast/`.
- Existing player cast UI is wired in `app/src/main/java/com/android/purebilibili/feature/video/ui/overlay/VideoPlayerOverlay.kt`.
- Existing BiliBili TV cast URL policy is in `app/src/main/java/com/android/purebilibili/data/repository/VideoCastPolicy.kt`.

## Architecture Decision

Implement Google Cast as a native plugin accessed through the CastPluginApi boundary, so the player overlay discovers and loads cast routes generically without hosting Google Cast specifics directly:

- Add a native plugin entry so the feature appears in the plugin center and can be enabled or disabled.
- Add a small cast-provider abstraction so the player overlay can offer DLNA and Google Cast without mixing protocol details into UI code.
- Use Google Cast CAF for Chromecast discovery/session/media loading, and reuse the current BiliBili TV cast URL fallback path where possible.
- Keep DLNA behavior intact and avoid replacing the existing DLNA manager in this project.

Official references checked on 2026-05-26:

- Google Cast Android sender setup recommends `play-services-cast-framework:22.3.1` and a Cast options provider.
- AndroidX MediaRouter latest stable is `androidx.mediarouter:mediarouter:1.8.1`.
- Media3 CastPlayer docs exist, but this slice starts with CAF session/media loading to avoid a broad player-service rewrite.

## Slices

### Slice 0: Baseline And Scaffolding

Goal: confirm the worktree, baseline focused tests, and add this documentation entry.

Status: complete.

Verification target:

```powershell
.\gradlew.bat :app:testDebugUnitTest --tests "*Cast*"
```

Result on 2026-05-26: passed with `BUILD SUCCESSFUL`.

### Slice 1: Google Cast Plugin Shell

Goal: add build/manifest wiring, a native plugin class, and small policy tests proving enablement metadata and route visibility behavior.

Status: complete.

Likely files:

- `app/build.gradle.kts`
- `app/src/main/AndroidManifest.xml`
- `app/src/main/java/com/android/purebilibili/app/PureApplication.kt`
- `app/src/main/java/com/android/purebilibili/feature/plugin/googlecast/GoogleCastPlugin.kt`
- New focused tests under `app/src/test/java/com/android/purebilibili/feature/cast/`

Result on 2026-05-26:

- Added the native `GoogleCastPlugin` shell and registered it as an eighth built-in plugin.
- Added Google Cast CAF and MediaRouter dependencies.
- Added the Cast options provider manifest metadata and default receiver policy.
- Verified with `.\gradlew.bat :app:testDebugUnitTest --tests "*GoogleCast*" --no-daemon`.
- Verified with `.\gradlew.bat :app:testDebugUnitTest --tests "*Cast*" --no-daemon`.

### Slice 2: Chromecast Discovery And Selection

Goal: discover Google Cast routes, present them alongside existing DLNA entries, and honor plugin enabled state.

UI requirement: Google Cast device rows must match the existing DLNA cast list layout, spacing, selection behavior, dialog structure, and loading/empty states. Only the route-specific icon and concise Google Cast label should differ.

Status: complete.

Likely files:

- `app/src/main/java/com/android/purebilibili/core/plugin/CastPluginApi.kt`
- Google Cast manager/provider files under `feature/plugin/googlecast/`
- `DeviceListDialog.kt`
- Focused discovery/presentation policy tests

Result on 2026-05-26:

- Added the generic `CastPluginApi` boundary so the host cast dialog handles plugin cast providers without importing Google Cast protocol classes.
- Added MediaRouter-based Google Cast route discovery inside the native Google Cast plugin implementation.
- Added route filtering/presentation policy tests for default/Bluetooth routes, cast-category support, fallback names, and route mapping.
- Added plugin-provided cast routes to the existing device dialog using the same DLNA row structure and interaction pattern; only the icon and plugin label differ.
- Verified with `.\gradlew.bat :app:testDebugUnitTest --tests "*GoogleCast*" --no-daemon`.
- Verified with `.\gradlew.bat :app:testDebugUnitTest --tests "*Cast*" --no-daemon`.

### Slice 3: Chromecast Media Load

Goal: when a Chromecast device is selected, resolve the current playable cast URL and load it through the active Google Cast session.

Status: complete.

- `feature/plugin/googlecast/GoogleCastMediaLoader.kt`
- `VideoPlayerOverlay.kt`
- Focused tests for media metadata/request construction and URL fallback decisions

Result on 2026-05-26:

- `VideoPlayerOverlay` now calls enabled cast plugins through `CastPluginApi` after resolving the same cast URL path used by DLNA/SSDP.
- The Google Cast plugin builds CAF `MediaLoadRequestData` with buffered stream type, `video/mp4` default content type, autoplay, and title/subtitle metadata policy.
- MediaRouter, CastContext, session polling, and RemoteMediaClient load calls run on the main dispatcher with a bounded session wait.
- Verified with `.\gradlew.bat :app:testDebugUnitTest --tests "*GoogleCast*" --no-daemon`.
- Verified with `.\gradlew.bat :app:testDebugUnitTest --tests "*Cast*" --no-daemon`.

### Slice 4: Review, Verification, And Cleanup

Goal: run targeted tests and compile checks, remove dead notes/files, update this document, and prepare commits.

Verification ladder:

```powershell
.\gradlew.bat :app:testDebugUnitTest --tests "*Cast*"
.\gradlew.bat :app:compileDebugKotlin
```

### Slice 5: Bugfix — SSDP Isolation And Cast Route Preservation

Goal: fix two runtime bugs — (A) SSDP device profile fetch failures crashing the cast dialog, and (B) Google Cast route selection failing after dialog disposal clears discovery state.

Status: verified and APK built.

Result on 2026-05-26:

- SSDP profile fetch now catches per-device exceptions (SocketTimeoutException, parse failures) so one broken device never crashes the dialog or blocks other results.
- `DeviceListDialog.refreshSsdpDevices` wraps discovery in try/finally for `isSearching`; `associateNotNullBy` internally isolates per-device exceptions so one broken device never crashes the dialog.
- `GoogleCastRouteManager` caches `MediaRouter.RouteInfo` in `routeCache` so `GoogleCastMediaLoader` can select the route even if the dialog disposes before `loadMedia` returns.
- `VideoPlayerOverlay` plugin cast flow now dismisses the dialog AFTER `plugin.cast()` returns instead of before; URL-resolution failure still dismisses immediately.
- Added regression tests: `parseDeviceProfile` blank/invalid XML null returns, `associateNotNullBy` with mixed successes/exceptions, and `shouldDismissCastDialogOnUrlFailure` policy wired into the plugin cast flow.
- Verified with targeted regression tests for `SsdpDevicePresentationPolicyTest` and `VideoPlayerOverlayCastPolicyTest`, plus `.\gradlew.bat :app:testDebugUnitTest --tests "*Cast*" --no-daemon`, `.\gradlew.bat :app:compileDebugKotlin --no-daemon`, and `.\gradlew.bat :app:assembleDebug --no-daemon`; all returned BUILD SUCCESSFUL.
- Debug APK for device testing: `app/build/outputs/apk/debug/BiliPai-debug-8.4.1-debug.apk`.

## Progress Log

- 2026-05-26: Created isolated worktree `feature/google-cast-plugin`.
- 2026-05-26: Confirmed existing casting is DLNA/SSDP based; Google Cast/Chromecast support is not implemented yet.
- 2026-05-26: Completed Slice 0 documentation and focused Cast baseline.
- 2026-05-26: Completed Slice 1 Google Cast plugin shell, CAF wiring, and focused policy tests.
- 2026-05-26: Completed Slice 2 Chromecast route discovery and device-list selection UI aligned with existing DLNA rows.
- 2026-05-26: Corrected the plugin boundary so Google Cast discovery/loading lives behind `CastPluginApi`; completed Slice 3 Chromecast media loading.
- 2026-05-26: Completed Slice 5 bugfix — SSDP per-device exception isolation, Google Cast route cache preservation, dialog dismissal timing fix, and debug APK build.

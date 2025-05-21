package expo.modules.bbplayer

import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition

class ExpoBBPlayerModule : Module() {
  override fun definition() = ModuleDefinition {
    Name("ExpoBBPlayer")

    View(ExpoBBPlayerView::class) {
      Prop("jsonUrl") { view: ExpoBBPlayerView, url: String ->
        view.setJsonUrl(url)
      }

      Prop("options") { view: ExpoBBPlayerView, options: HashMap<String, Any?> ->
        view.setOptions(options)
      }

      OnViewDidUpdateProps {view ->
        view.setupPlayer()
      }

      AsyncFunction("adMediaHeight") { view: ExpoBBPlayerView ->
        view.adMediaHeight()
      }

      AsyncFunction("adMediaWidth") { view: ExpoBBPlayerView ->
        view.adMediaWidth()
      }

      AsyncFunction("adMediaClip") { view: ExpoBBPlayerView ->
        view.adMediaClip()
      }

      AsyncFunction("controls") { view: ExpoBBPlayerView ->
        view.controls()
      }

      AsyncFunction("duration") { view: ExpoBBPlayerView ->
        view.duration()
      }

      AsyncFunction("inView") { view: ExpoBBPlayerView ->
        view.inView()
      }

      AsyncFunction("mode") { view: ExpoBBPlayerView ->
        view.mode()
      }

      AsyncFunction("muted") { view: ExpoBBPlayerView ->
        view.muted()
      }

      AsyncFunction("phase") { view: ExpoBBPlayerView ->
        view.phase()
      }

      AsyncFunction("playoutData") { view: ExpoBBPlayerView ->
        view.playoutData()
      }

      AsyncFunction("projectData") { view: ExpoBBPlayerView ->
        view.projectData()
      }

      // using playerState as name to avoid collision with internal the state function
      AsyncFunction("playerState") { view: ExpoBBPlayerView ->
        view.state()
      }

      AsyncFunction("volume") { view: ExpoBBPlayerView ->
        view.volume()
      }

      AsyncFunction("autoPlayNextCancel") { view: ExpoBBPlayerView ->
        view.autoPlayNextCancel()
      }

      AsyncFunction("collapse") { view: ExpoBBPlayerView ->
        view.collapse()
      }

      AsyncFunction("expand") { view: ExpoBBPlayerView ->
        view.expand()
      }

      AsyncFunction("enterFullscreen") { view: ExpoBBPlayerView ->
        view.enterFullscreen()
      }

      AsyncFunction("exitFullscreen") { view: ExpoBBPlayerView ->
        view.exitFullscreen()
      }

      AsyncFunction("pause") { view: ExpoBBPlayerView ->
        view.pause()
      }

      AsyncFunction("play") { view: ExpoBBPlayerView ->
        view.play()
      }

      AsyncFunction("seek") { view: ExpoBBPlayerView, offsetInSeconds: Int ->
        view.seek(offsetInSeconds)
      }

      AsyncFunction("setMuted") { view: ExpoBBPlayerView, muted: Boolean ->
        view.setMuted(muted)
      }

      AsyncFunction("setVolume") { view: ExpoBBPlayerView, volume: Double ->
        view.setVolume(volume)
      }

      Events(
        "onDidFailWithError",
        "onDidRequestCollapse",
        "onDidRequestExpand",
        "onDidTriggerCanPlay",
        "onDidRequestOpenUrl",
        "onDidSetupWithJsonUrl",
        "onDidTriggerAdError",
        "onDidTriggerAdFinished",
        "onDidTriggerAdLoaded",
        "onDidTriggerAdLoadStart",
        "onDidTriggerAdNotFound",
        "onDidTriggerAdQuartile1",
        "onDidTriggerAdQuartile2",
        "onDidTriggerAdQuartile3",
        "onDidTriggerAdStarted",
        "onDidTriggerAllAdsCompleted",
        "onDidTriggerAutoPause",
        "onDidTriggerAutoPausePlay",
        "onDidTriggerCanPlay",
        "onDidTriggerCustomStatistics",
        "onDidTriggerDurationChange",
        "onDidTriggerEnded",
        "onDidTriggerFullscreen",
        "onDidTriggerMediaClipFailed",
        "onDidTriggerMediaClipLoaded",
        "onDidTriggerModeChange",
        "onDidTriggerPause",
        "onDidTriggerPhaseChange",
        "onDidTriggerPlay",
        "onDidTriggerPlaying",
        "onDidTriggerProjectLoaded",
        "onDidTriggerRetractFullscreen",
        "onDidTriggerSeeked",
        "onDidTriggerSeeking",
        "onDidTriggerStall",
        "onDidTriggerStateChange",
        "onDidTriggerViewFinished",
        "onDidTriggerViewStarted",
        "onDidTriggerVolumeChange",
      )
    }
  }
}


   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
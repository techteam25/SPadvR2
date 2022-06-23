package org.tyndalebt.spadv.androidtest.happypath

import androidx.appcompat.widget.AppCompatSeekBar
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.CoreMatchers
import org.tyndalebt.spadv.androidtest.happypath.base.SharedBase
import org.tyndalebt.spadv.androidtest.utilities.ActivityAccessor
import org.tyndalebt.spadv.androidtest.utilities.Constants
import org.tyndalebt.spadv.R

abstract class PlayerPhaseTestBase(sharedBase: SharedBase) : SwipablePhaseTestBase(sharedBase) {

    fun pressMicButton() {
        Espresso.onView(CoreMatchers.allOf(ViewMatchers.withId(R.id.start_recording_button), ViewMatchers.isDisplayed())).perform(ViewActions.click())
    }

    fun giveAppTimeToRecordAudio() {
        Thread.sleep(Constants.durationToRecordTranslatedClip)
    }

    fun getCurrentSlideAudioProgress(): Int {
        val progressBar = ActivityAccessor.getCurrentActivity()?.findViewById<AppCompatSeekBar>(base.getPlayerSeekbarId())
        return progressBar!!.progress
    }

    fun pressPlayPauseButton() {
        Espresso.onView(CoreMatchers.allOf(ViewMatchers.withId(base.getPlaybackButtonId()), ViewMatchers.isDisplayed())).perform(ViewActions.click())
    }

    fun giveAppTimeToPlayAudio() {
        Thread.sleep(Constants.durationToPlayTranslatedClip)
    }
}
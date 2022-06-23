package org.tyndalebt.spadv.androidtest.happypath.community_work

import org.junit.Assert
import org.tyndalebt.spadv.androidtest.happypath.PlayerPhaseTestBase
import org.tyndalebt.spadv.androidtest.happypath.base.SharedBase
import org.tyndalebt.spadv.R
import org.tyndalebt.spadv.androidtest.utilities.ActivityAccessor
import org.tyndalebt.spadv.androidtest.utilities.AnimationsToggler
import org.tyndalebt.spadv.androidtest.utilities.Constants
import org.tyndalebt.spadv.androidtest.utilities.PhaseNavigator

class CommunityWorkPhaseBase(sharedBase: SharedBase) : PlayerPhaseTestBase(sharedBase) {

    override fun navigateToPhase() {
        PhaseNavigator.navigateFromRegistrationScreenToPhase(Constants.Phase.communityWork, base)
    }

    fun should_BeAbleToSwipeBetweenSlides() {
        test_swipingBetweenSlides()
    }

    fun should_BeAbleToPlayTranslationOfASlide() {
        makeSureAnAudioClipIsAvailable(Constants.Phase.communityWork)

        val originalProgress = getCurrentSlideAudioProgress()
        pressPlayPauseButton()
        Thread.sleep(Constants.durationToPlayTranslatedClip)
        pressPlayPauseButton()
        val progressAfterPausing = getCurrentSlideAudioProgress()
        Assert.assertTrue("Expected progress bar to increase in position.", progressAfterPausing > originalProgress)
    }

    fun should_BeAbleToRecordFeedback() {
        val originalNumberOfRecordings = getCurrentNumberOfRecordings()

        AnimationsToggler.withoutCustomAnimations {
            pressMicButton()
            Thread.sleep(Constants.durationToRecordFeedbackClip)
            pressMicButton()
        }

        val finalNumberOfRecordings = getCurrentNumberOfRecordings()
        Assert.assertEquals("Expected an additional feedback recording to exist", originalNumberOfRecordings + 1, finalNumberOfRecordings)
    }

    fun should_beAbleToSwipeToNextPhase() {
        test_swipingToNextPhase(Constants.Phase.accuracyCheck)
    }

    private fun getCurrentNumberOfRecordings() =
            ActivityAccessor.getCurrentActivity()!!.findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.recordings_list)!!.childCount

}
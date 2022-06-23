package org.tyndalebt.spadv.androidtest.happypath.community_work

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.tyndalebt.spadv.androidtest.happypath.PhaseTestBase
import org.tyndalebt.spadv.androidtest.happypath.base.ImageBase
import org.tyndalebt.spadv.androidtest.happypath.base.annotation.ImageTest

@LargeTest
@ImageTest
@RunWith(AndroidJUnit4::class)
class CommunityWorkImage : ImageBase() {
    private var base: CommunityWorkPhaseBase = CommunityWorkPhaseBase(this)

    @Before
    fun setup() {
        PhaseTestBase.revertWorkspaceToCleanState(this)
        base.setUp()
    }

    @Test
    fun should_BeAbleToSwipeBetweenSlides() {
        base.should_BeAbleToSwipeBetweenSlides()
    }

    @Test
    fun should_BeAbleToPlayTranslationOfASlide() {
        base.should_BeAbleToPlayTranslationOfASlide()
    }

    @Test
    fun should_BeAbleToRecordFeedback() {
        base.should_BeAbleToRecordFeedback()
    }

    @Test
    fun should_beAbleToSwipeToNextPhase() {
        base.should_beAbleToSwipeToNextPhase()
    }
}
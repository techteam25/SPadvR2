package org.tyndalebt.spadv.androidtest.happypath.learn

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
class LearnImage : ImageBase() {

    private var base: LearnPhaseBase = LearnPhaseBase(this)

    @Before
    fun setup() {
        PhaseTestBase.revertWorkspaceToCleanState(this)
        base.setUp()
    }

    @Test
    fun should_BeAbleToUsePlayButton() {
        base.should_BeAbleToUsePlayButton()
    }

    @Test
    fun should_BeAbleToRecordAudioClip() {
        base.should_BeAbleToRecordAudioClip()
    }

}

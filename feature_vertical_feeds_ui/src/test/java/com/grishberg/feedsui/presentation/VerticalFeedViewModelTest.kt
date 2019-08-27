package com.grishberg.feedsui.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.grishberg.verticalfeeds.FeedContentOutputAction
import com.grishberg.verticalfeeds.FeedItem
import com.grishberg.verticalfeeds.FeedContent
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class VerticalFeedViewModelTest {
    @get:Rule
    val testRule = InstantTaskExecutorRule()

    private lateinit var contentOutputAction: FeedContentOutputAction
    private val content = mock<FeedContent> {
        doAnswer { iom -> contentOutputAction = iom.getArgument(0) }
                .whenever(it).registerOutputBoundsAction(any())
    }
    private val underTest = VerticalFeedViewModel(content)
    private val feed = mock<FeedItem<Any>>()


    @Test
    fun getFeedTest() {
        val newFeeds = listOf(feed)

        contentOutputAction.updateFeeds(newFeeds)

        assertEquals(newFeeds, underTest.feeds.value)
    }
}
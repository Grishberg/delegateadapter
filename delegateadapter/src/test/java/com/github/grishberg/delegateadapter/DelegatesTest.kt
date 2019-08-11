package com.github.grishberg.delegateadapter

import android.view.ViewGroup
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.never
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner


@RunWith(RobolectricTestRunner::class)
class DelegatesTest {
    private val item1 = TestItem(1)
    private val item2 = TestItem(2)

    private val items = listOf(item1, item2)
    private val delegate1 = mock<AdapterDelegate<ItemWithId, TestItem, RecycableViewHolder>> {
        on { isForType(item1) } doReturn true
    }
    private val delegate2 = mock<AdapterDelegate<ItemWithId, TestItem, RecycableViewHolder>> {
        on { isForType(item2) } doReturn true
    }

    private val delegates = Delegates<ItemWithId>(listOf(delegate1, delegate2))

    @Test
    fun createSecondDelegateViewHolderWhenGivenSecondItem() {
        val parent = mock<ViewGroup>()
        delegates.createVh(parent, 1)

        verify(delegate1, never()).onCreateViewHolder(parent)
        verify(delegate2).onCreateViewHolder(parent)
    }

    @Test
    fun bindFirstDelegateViewHolderWhenGivenFirstItem() {
        val vh = mock<RecycableViewHolder>()
        delegates.bindVh(vh, item1, 0)

        verify(delegate1).onBindViewHolder(vh, item1)
    }

    private class TestItem(private val id: Int) : ItemWithId {
        override fun getId(): Int {
            return id
        }
    }
}
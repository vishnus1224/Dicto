package com.vishnus1224.dicto.event

import com.vishnus1224.dicto.provider.CopyEventProvider
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test

import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

/**
 * Created by Vishnu on 3/7/2017.
 */
class EventsKtTest {

    @Mock lateinit var copyEventProvider : CopyEventProvider

    val testObserver = TestObserver<String>()

    @Before
    fun setUp() {

        MockitoAnnotations.initMocks(this)

    }

    @Test
    fun receiveCopyEventForSingleWord() {

        Mockito.`when`(copyEventProvider.provideEvent()).thenReturn(Observable.just("Hey"))

        copyWord(copyEventProvider).subscribe(testObserver)

        testObserver.assertComplete()

        testObserver.assertNoErrors()

        testObserver.assertValueCount(1)

        verify(copyEventProvider).provideEvent()

    }

    @Test
    fun doNotReceiveCopyEventForWordsSeparatedWithWhitespaces(){

        Mockito.`when`(copyEventProvider.provideEvent()).thenReturn(Observable.just("Hey you"))

        copyWord(copyEventProvider).subscribe(testObserver)

        testObserver.assertComplete()

        testObserver.assertNoErrors()

        testObserver.assertNoValues()

    }

    @Test
    fun doNotReceiveDuplicateCopyEvent(){

        Mockito.`when`(copyEventProvider.provideEvent()).thenReturn(Observable.just("Hey", "Hey"))

        copyWord(copyEventProvider).subscribe(testObserver)

        testObserver.assertComplete()

        testObserver.assertNoErrors()

        testObserver.assertValueCount(1)


    }


}
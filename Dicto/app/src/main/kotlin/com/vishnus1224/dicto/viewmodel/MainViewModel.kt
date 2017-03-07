package com.vishnus1224.dicto.viewmodel

import com.vishnus1224.dicto.event.copyWord
import com.vishnus1224.dicto.provider.CopyEventProvider
import io.reactivex.disposables.CompositeDisposable

/**
 * The main view model to handle user interaction and events.
 * probably the only one as of now.
 * Created by Vishnu on 3/5/2017.
 */
class MainViewModel(val copyEventProvider: CopyEventProvider) : BaseViewModel{

    val disposer : CompositeDisposable

    init {

        disposer = CompositeDisposable()

        listenForCopyEvent()

    }

    private fun listenForCopyEvent() {

        //subscribe to the copy event to get notified when user copies a word from any app.
        disposer.add(copyWord(copyEventProvider).subscribe { copiedText ->

        })


    }



    override fun deInit() {

        disposer.clear()

    }

}
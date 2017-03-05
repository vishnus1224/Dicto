package com.vishnus1224.dicto.viewmodel

import io.reactivex.disposables.CompositeDisposable

/**
 * The main view model to handle user interaction and events.
 * probably the only one as of now.
 * Created by Vishnu on 3/5/2017.
 */
class MainViewModel() : BaseViewModel{

    val disposer : CompositeDisposable

    init {

        disposer = CompositeDisposable()


    }

    fun onCopyEventReceived(copiedText : String){



    }



    override fun deInit() {

        disposer.clear()

    }

}
package com.vishnus1224.dicto.event

import android.content.ClipboardManager
import android.content.Context
import io.reactivex.Observable
import android.content.Context.CLIPBOARD_SERVICE

/**
 * Exposes observables for system wide events.
 * e.g. User copied text in some application.
 * Created by Vishnu on 3/5/2017.
 */

/**
 * Whenever user copies one word from any of the apps and if the event has not already been emitted i.e it is unique,
 * then observers will get notified of this event.
 */
fun copyWord(context: Context) : Observable<String> {

    val event : Observable<String> =  Observable.create { observer ->

        val clipBoard = context.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager

        fun primaryClipChangedListener(){

            //get the first copied item from clipboard
            val copiedText = clipBoard.primaryClip.getItemAt(0)

            if(!observer.isDisposed) {

                observer.onNext(copiedText.text.toString())

            }
        }

        clipBoard.addPrimaryClipChangedListener { primaryClipChangedListener() }

        //when subscription is disposed, remove the listener.
        observer.setCancellable { clipBoard.removePrimaryClipChangedListener { primaryClipChangedListener() } }

    }

    //filter the event to make sure copying more than one word does not propagate through.
    return event.filter { copiedText ->
        copiedText.split(" ").size == 1 }.distinct()

}





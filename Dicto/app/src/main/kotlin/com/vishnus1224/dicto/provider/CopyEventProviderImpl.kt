package com.vishnus1224.dicto.provider

import android.content.ClipboardManager
import android.content.Context
import io.reactivex.Observable

/**
 * Created by Vishnu on 3/7/2017.
 */
class CopyEventProviderImpl(val context: Context) : CopyEventProvider {

    override fun provideEvent(): Observable<String> {

        return Observable.create { observer ->

            val clipBoard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

            fun primaryClipChangedListener() {

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
    }
}
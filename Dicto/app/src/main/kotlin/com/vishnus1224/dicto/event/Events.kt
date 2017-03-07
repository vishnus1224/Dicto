package com.vishnus1224.dicto.event

import io.reactivex.Observable
import com.vishnus1224.dicto.provider.CopyEventProvider

/**
 * Exposes observables for system wide events.
 * e.g. User copied text in some application.
 * Created by Vishnu on 3/5/2017.
 */

/**
 * Whenever user copies one word from any of the apps and if the event has not already been emitted i.e it is unique,
 * then observers will get notified of this event.
 */
fun copyWord(copyEventProvider: CopyEventProvider) : Observable<String> {

    //filter the event to make sure copying more than one word does not propagate through.
    return copyEventProvider.provideEvent()
            .filter { copiedText -> copiedText.split(" ").size == 1 }
            .distinct()

}





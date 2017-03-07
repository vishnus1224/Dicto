package com.vishnus1224.dicto.provider

import io.reactivex.Observable

/**
 * Provides a copy event for its listeners.
 * The event occurs whenever user copies any text from any of the apps.
 * Created by Vishnu on 3/7/2017.
 */
interface CopyEventProvider {

    fun provideEvent(): Observable<String>

}
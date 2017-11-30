package com.vishnus1224.dicto.data.model

internal data class Sense(val definitions: List<String>)

internal data class Entry(val senses: List<Sense>)

internal data class LexicalEntry(val entries: List<Entry>)

internal data class EntriesResult(val id: String, val lexicalEntries: List<LexicalEntry>)

data class EntriesResponse internal constructor(val results: List<EntriesResult>)
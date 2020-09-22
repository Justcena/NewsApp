package com.android_devs.news.db

import androidx.room.TypeConverter
import com.android_devs.news.models.Source

class Converters {
    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)
    }
}
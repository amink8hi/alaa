package com.hanamin.alaa.data.remote.responce

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Sets(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = 0,
    val redirect_url: String? = "",
    val title: String? = "",
    val short_title: String? = "",
    val photo: String? = "",
    val contents_count: String? = "",
    val contents: String? = "",
    val created_at: String? = "",
    val updated_at: String? = ""
)
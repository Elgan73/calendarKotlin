package com.stark.calendarkotlin

data class Tasks(
    val id: Int = 0,
    val date_start: Long,
    val date_finish: Long,
    val name: String = "My task",
    val description: String = "Desc my business"
    )


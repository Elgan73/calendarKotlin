package com.stark.calendarkotlin

import java.sql.Timestamp

data class Tasks(
    val id: Int = 1,
    val date_start: Long,
    val date_finish: Long,
    val name: String = "My task",
    val description: String = "Desc my business"
    )


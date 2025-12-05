package com.patro.bikramsamvat.data.model

data class MonthCell(
    val isEmpty: Boolean,
    val bsDay: Int? = null,
    val adDay: Int? = null,
    val fullData: CalendarDate? = null
)
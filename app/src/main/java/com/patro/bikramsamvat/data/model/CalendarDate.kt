package com.patro.bikramsamvat.data.model

import kotlinx.serialization.Serializable

// top level json
@Serializable
data class CalendarResponse(
    val data: CalendarData
)

data class CalendarData(
    val dates: List<CalendarDate>
)

// A single day entry
data class CalendarDate(
    val bsDay: Int,
    val bsMonth: Int,
    val bsYear: Int,

    val adDay: Int,
    val adMonth: Int,
    val adYear: Int,

    val adMonthStrEn: String,
    val bsDayNp: String,
    val bsMonthStrNp: String,
    val bsYearNp:String,

    val weekdayStrNp: String,
    val weekdayStrEn: String,

    val isPublicHoliday: Boolean,
    val tithiCode: Int?,
    val tithiStrEn: String,

    val events: List<String>,

    val astral: AstralData,

    val specialDays: SpecialDays,

    val bsMonthNp: String,
    val weekday: Int,
    val bsMonthStrEn: String,
    val adMonthStrNp: String
)

data class AstralData(
    val sunrise: String?,
    val sunset: String?
)

data class SpecialDays(
    val bibaha: Boolean,
    val bratabanda: Boolean,
    val grihaprabesh: Boolean,
    val rudri: Boolean
)
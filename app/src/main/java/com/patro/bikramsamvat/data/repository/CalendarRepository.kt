package com.patro.bikramsamvat.data.repository

import android.content.Context
import com.patro.bikramsamvat.data.model.CalendarData
import com.patro.bikramsamvat.data.model.CalendarDate
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

// Add serialization annotations

@Serializable
data class CalendarResponse(
    val data: CalendarData

)

@Serializable
data class CalendarData(
    val dates: List<CalendarDate>
)

@Serializable
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

@Serializable
data class AstralData(
    val sunrise: String? = null,
    val sunset: String? = null
)

@Serializable
data class SpecialDays(
    val bibaha: Boolean,
    val bratabanda: Boolean,
    val grihaprabesh: Boolean,
    val rudri: Boolean
)

fun loadCalendarJson(context: Context): CalendarResponse {
    val json = context.assets.open("2082.json")
        .bufferedReader()
        .use { it.readText()}
    return Json.decodeFromString(json)
}
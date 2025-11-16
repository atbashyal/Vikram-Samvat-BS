package com.example.vikramsamvat.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.vikramsamvat.converter.BSConverter
import com.example.vikramsamvat.model.*
import com.example.vikramsamvat.model.NepaliDay
import com.example.vikramsamvat.model.NepaliMonth
import com.example.vikramsamvat.utils.getDaysInMonth

class CalendarRepository {

    @RequiresApi(Build.VERSION_CODES.O)
    fun getMonth(year: Int, month: Int): NepaliMonth {
        val daysInMonth = getDaysInMonth(year, month)

        val days = (1..daysInMonth).map { d ->
            NepaliDay(year, month, d)
        }

        return NepaliMonth(year, month, days)
    }
}

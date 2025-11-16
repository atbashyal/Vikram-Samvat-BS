package com.example.vikramsamvat.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.YearMonth

@RequiresApi(Build.VERSION_CODES.O)
fun getDaysInMonth(year: Int, month: Int): Int {
    return YearMonth.of(year, month).lengthOfMonth()
}

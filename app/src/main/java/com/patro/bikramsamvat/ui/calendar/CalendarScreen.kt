package com.patro.bikramsamvat.ui.calendar

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.patro.bikramsamvat.data.model.CalendarData

@Composable
fun CalendarScreen(calendarData: List<CalendarData>){
    LazyColumn(

    ){
        items(calendarData) { day ->
            CalendarDayCard(day)
        }
    }
}
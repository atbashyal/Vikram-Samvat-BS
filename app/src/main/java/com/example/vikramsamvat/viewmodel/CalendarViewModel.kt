package com.example.vikramsamvat.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.vikramsamvat.model.NepaliMonth
import com.example.vikramsamvat.repository.CalendarRepository

@RequiresApi(Build.VERSION_CODES.O)
class CalendarViewModel : ViewModel() {

    private val repo = CalendarRepository()

    private val _state = MutableStateFlow<NepaliMonth?>(null)
    val state: StateFlow<NepaliMonth?> = _state

    init {
        // Load current Nepali date automatically
        loadMonth(2081, 1)   // TODO: change this to current BS date later
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun loadMonth(year: Int, month: Int) {
        _state.value = repo.getMonth(year, month)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun nextMonth() {
        val m = state.value ?: return
        val newMonth = if (m.month == 12) 1 else m.month + 1
        val newYear = if (m.month == 12) m.year + 1 else m.year
        loadMonth(newYear, newMonth)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun previousMonth() {
        val m = state.value ?: return
        val newMonth = if (m.month == 1) 12 else m.month - 1
        val newYear = if (m.month == 1) m.year - 1 else m.year
        loadMonth(newYear, newMonth)
    }
}

package com.example.vikramsamvat

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import com.example.vikramsamvat.ui.calendar.CalendarScreen
import com.example.vikramsamvat.viewmodel.CalendarViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: CalendarViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CalendarScreen(viewModel)
        }
    }
}

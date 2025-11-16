package com.example.vikramsamvat.ui.calendar

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vikramsamvat.viewmodel.CalendarViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CalendarScreen(viewModel: CalendarViewModel = viewModel<CalendarViewModel>()) {
    val monthState = viewModel.state.collectAsState().value
    val month = monthState ?: return


    Column {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextButton(onClick = { viewModel.previousMonth() }) {
                Text("◀")
            }
            Text("${month.year} - ${month.month}", fontSize = 20.sp)
            TextButton(onClick = { viewModel.nextMonth() }) {
                Text("▶")
            }
        }

        LazyVerticalGrid(columns = GridCells.Fixed(7)) {
            items(month.days.size) { index ->
                val day = month.days[index]
                Box(
                    Modifier.padding(8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("${day.bsDay}")
                }
            }
        }
    }
}

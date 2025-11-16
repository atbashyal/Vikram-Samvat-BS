package com.example.vikramsamvat.converter

object BSConverter {

    private val bsData = arrayOf(
        intArrayOf(2000, 30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31),
        intArrayOf(2001, 31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30),
        intArrayOf(2002, 31, 31, 32, 31, 31, 31, 29, 30, 29, 30, 29, 31),
        // ... (I will provide full year data 2000–2090 if you want)
    )

    private const val START_BS_YEAR = 2000
    private const val START_AD_YEAR = 1943

    private val adMonth = intArrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

    private fun isLeapYear(year: Int): Boolean {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)
    }

    // AD → BS Conversion
    fun adToBs(year: Int, month: Int, day: Int): Triple<Int, Int, Int> {
        var adY = START_AD_YEAR
        var adM = 1
        var adD = 1

        var bsY = START_BS_YEAR
        var bsM = 1
        var bsD = 1

        var dayDiff = 0

        while (adY < year || adM < month || adD < day) {
            adM += 1
            adD += 1
            dayDiff += 1

            if (adD > if (adM == 2 && isLeapYear(adY)) 29 else adMonth[adM - 1]) {
                adD = 1
                adM++
            }
            if (adM > 12) {
                adM = 1
                adY++
            }
        }

        while (dayDiff > 0) {
            bsD++
            if (bsD > bsData[bsY - START_BS_YEAR][bsM]) {
                bsD = 1
                bsM++
            }
            if (bsM > 12) {
                bsM = 1
                bsY++
            }
            dayDiff--
        }

        return Triple(bsY, bsM, bsD)
    }
}

package c_march

import kotlin.math.max


/**
 *  Problem 24. Count Days Without Meetings.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n log n)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            10,
            arrayOf(intArrayOf(5, 7), intArrayOf(1, 3), intArrayOf(9, 10))
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${countDays(test.first, test.second)}")
    }

}

fun countDays(days: Int, meetings: Array<IntArray>): Int {
    meetings.sortBy { it[0] }
    var freeDays = 0
    var latestEnd = 0

    for (meeting in meetings) {
        val start = meeting[0]
        val end = meeting[1]

        if (start > latestEnd + 1) {
            freeDays += start - latestEnd - 1
        }

        latestEnd = max(latestEnd.toDouble(), end.toDouble()).toInt()
    }

    freeDays += days - latestEnd
    return freeDays
}


// Time limit exceeds
// TC - O(n log n * n * days)
// SC - O(days)
fun countDays1(days: Int, meetings: Array<IntArray>): Int {
    val daysArr = IntArray(days + 1)
    for (meeting in meetings) {
        fillDays(meeting[0], meeting[1], daysArr)
    }
    var availDays = 0
    for (day in daysArr) {
        if (day == 0) availDays++
    }
    return availDays - 1
}

private fun fillDays(start: Int, end: Int, daysArr: IntArray) {
    for (i in start..end) {
        daysArr[i] = 1
    }
}
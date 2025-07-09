package g_july

import kotlin.math.max

/**
 *  Problem 9. Reschedule Meetings for Maximum Free Time I.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Data9(
            eventTime = 5,
            k = 1,
            intArrayOf(1, 3),
            intArrayOf(2, 5)
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${maxFreeTime(test.eventTime, test.k, test.startTime, test.endTime)}")
    }

}

fun maxFreeTime(
    eventTime: Int,
    k: Int,
    startTime: IntArray,
    endTime: IntArray
): Int {
    val n = startTime.size
    var res = 0
    var t = 0
    for (i in 0..<n) {
        t += endTime[i] - startTime[i]
        val left = if (i <= k - 1) 0 else endTime[i - k]
        val right = if (i == n - 1) eventTime else startTime[i + 1]
        res = max(res, right - left - t)
        if (i >= k - 1) {
            t -= endTime[i - k + 1] - startTime[i - k + 1]
        }
    }
    return res
}

private data class Data9(
    val eventTime: Int,
    val k: Int,
    val startTime: IntArray,
    val endTime: IntArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Data9

        if (eventTime != other.eventTime) return false
        if (k != other.k) return false
        if (!startTime.contentEquals(other.startTime)) return false
        if (!endTime.contentEquals(other.endTime)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = eventTime
        result = 31 * result + k
        result = 31 * result + startTime.contentHashCode()
        result = 31 * result + endTime.contentHashCode()
        return result
    }
}
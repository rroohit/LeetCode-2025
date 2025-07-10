package g_july

import kotlin.math.max

/**
 *  Problem 10. Reschedule Meetings for Maximum Free Time II.
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

}

fun maxFreeTime(eventTime: Int, startTime: IntArray, endTime: IntArray): Int {
    val n = startTime.size
    val q = BooleanArray(n)
    run {
        var i = 0
        var t1 = 0
        var t2 = 0
        while (i < n) {
            if (endTime[i] - startTime[i] <= t1) {
                q[i] = true
            }
            t1 = max(t1, startTime[i] - (if (i == 0) 0 else endTime[i - 1]))

            if (endTime[n - i - 1] - startTime[n - i - 1] <= t2) {
                q[n - i - 1] = true
            }
            t2 = max(
                t2,
                (if (i == 0) eventTime else startTime[n - i]) - endTime[n - i - 1]
            )
            i++
        }
    }

    var res = 0
    for (i in 0..<n) {
        val left = if (i == 0) 0 else endTime[i - 1]
        val right = if (i == n - 1) eventTime else startTime[i + 1]
        res = if (q[i]) {
            max(res, right - left)
        } else {
            max(res, right - left - (endTime[i] - startTime[i]))
        }
    }
    return res
}

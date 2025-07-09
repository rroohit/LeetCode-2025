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

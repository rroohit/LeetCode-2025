package d_april

import java.util.*
import kotlin.math.min


/**
 *  Problem 10. Count the Number of Powerful Integers.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(log(finish) * 10)
 *
 *       - Space complexity: O(log(finish))
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Test10(
            1, 6000, 4, "124"
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${numberOfPowerfulInt(test.start, test.finish, test.limit, test.s)}")
    }

}

data class Test10(
    val start: Long,
    val finish: Long,
    val limit: Int,
    val s: String
)

fun numberOfPowerfulInt(
    start: Long,
    finish: Long,
    limit: Int,
    s: String
): Long {
    var low = start.toString()
    val high = finish.toString()
    val n = high.length
    low = String.format("%" + n + "s", low).replace(' ', '0') // align digits
    val preLen = n - s.length
    val memo = LongArray(n)
    Arrays.fill(memo, -1)

    return dfs(
        0,
        limitLow = true,
        limitHigh = true,
        low = low,
        high = high,
        limit = limit,
        s = s,
        preLen = preLen,
        memo = memo
    )
}

private fun dfs(
    i: Int,
    limitLow: Boolean,
    limitHigh: Boolean,
    low: String,
    high: String,
    limit: Int,
    s: String,
    preLen: Int,
    memo: LongArray
): Long {
    if (i == low.length) {
        return 1
    }
    if (!limitLow && !limitHigh && memo[i] != -1L) {
        return memo[i]
    }

    val lo = if (limitLow) low[i].code - '0'.code else 0
    val hi = if (limitHigh) high[i].code - '0'.code else 9
    var res: Long = 0
    if (i < preLen) {
        for (digit in lo..min(hi.toDouble(), limit.toDouble()).toInt()) {
            res += dfs(
                i + 1,
                limitLow && digit == lo,
                limitHigh && digit == hi,
                low,
                high,
                limit,
                s,
                preLen,
                memo
            )
        }
    } else {
        val x = s[i - preLen].code - '0'.code
        if (lo <= x && x <= min(hi.toDouble(), limit.toDouble())) {
            res = dfs(
                i + 1,
                limitLow && x == lo,
                limitHigh && x == hi,
                low,
                high,
                limit,
                s,
                preLen,
                memo
            )
        }
    }
    if (!limitLow && !limitHigh) {
        memo[i] = res
    }
    return res
}
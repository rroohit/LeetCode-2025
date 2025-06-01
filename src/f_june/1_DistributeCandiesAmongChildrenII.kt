package f_june

import kotlin.math.max
import kotlin.math.min


/**
 *  Problem 1. Distribute Candies Among Children II.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(min(limit, n))
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(5, 2)
    )

    testCases.forEach { (n, limit) ->
        println("Result ==> ${distributeCandies(n, limit)}")
    }
}

fun distributeCandies(n: Int, limit: Int): Long {
    var total = 0L
    for (i in 0..min(limit, n)) {
        if (n - i > 2 * limit) continue
        total += min(n - i, limit) - max(0, n - i - limit) + 1
    }
    return total
}




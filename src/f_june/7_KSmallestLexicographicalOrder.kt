package f_june

import kotlin.math.min

/**
 *  Problem 7. K-th Smallest in Lexicographical Order.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(log(n)^2)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(13, 2)
    )

    testCases.forEach { (n, k) ->
        println("Result ==> ${findKthNumber(n, k)}")
    }


}


fun findKthNumber(n: Int, k: Int): Int {
    var k = k
    var curr = 1
    k--

    while (k > 0) {
        val step = countSteps(n, curr.toLong(), (curr + 1).toLong())
        if (step <= k) {
            curr++
            k -= step
        } else {
            curr *= 10
            k--
        }
    }

    return curr
}

private fun countSteps(n: Int, prefix1: Long, prefix2: Long): Int {
    var prefix1 = prefix1
    var prefix2 = prefix2
    var steps = 0
    while (prefix1 <= n) {
        steps += (min((n + 1).toLong(), prefix2) - prefix1).toInt()
        prefix1 *= 10
        prefix2 *= 10
    }
    return steps
}

package h_august

import java.util.*
import java.util.function.Supplier
import kotlin.math.max

/**
 *  Problem 7. Find the Maximum Number of Fruits Collected.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n^2)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 6, 8, 7),
            intArrayOf(9, 10, 11, 12),
            intArrayOf(13, 14, 15, 16)
        )
    )

    testCases.forEach { fruits ->
        println("Result ==> ${maxCollectedFruits(fruits)}")
    }

}

fun maxCollectedFruits(fruits: Array<IntArray>): Int {
    val n = fruits.size
    var ans = 0
    for (i in 0..<n) {
        ans += fruits[i][i]
    }

    val dp: Supplier<Int?> = Supplier {
        var prev = IntArray(n)
        var curr = IntArray(n)
        Arrays.fill(prev, Int.Companion.MIN_VALUE)
        Arrays.fill(curr, Int.Companion.MIN_VALUE)
        prev[n - 1] = fruits[0][n - 1]
        for (i in 1..<n - 1) {
            for (j in max(n - 1 - i, i + 1)..<n) {
                var best = prev[j]
                if (j - 1 >= 0) best = max(best, prev[j - 1])
                if (j + 1 < n) best = max(best, prev[j + 1])
                curr[j] = best + fruits[i][j]
            }
            val temp = prev
            prev = curr
            curr = temp
        }
        prev[n - 1]
    }

    ans += dp.get()!!

    for (i in 0..<n) {
        for (j in 0..<i) {
            val temp = fruits[j][i]
            fruits[j][i] = fruits[i][j]
            fruits[i][j] = temp
        }
    }

    ans += dp.get()!!
    return ans
}



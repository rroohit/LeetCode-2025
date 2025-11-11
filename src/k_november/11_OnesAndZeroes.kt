package k_november

import kotlin.math.max

/**
 * Problem 11. Ones and Zeroes.
 *
 * ## Intuition -
 *  We can think of this problem like a 0/1 Knapsack — each string is an item with
 *      a cost (number of 0s and 1s) and a value (1). Our goal is to maximize the number
 *      of strings we can include without exceeding the limits of 0s (m) and 1s (n).
 *
 * ## Approach -
 *  We use Bottom-Up Dynamic Programming (Tabulation).
 *      - Initialize a 2D dp array where dp[i][j] represents the maximum number of strings
 *          that can be formed with at most i zeros and j ones.
 *      - For each string, count its zeros and ones.
 *      - Traverse dp backwards to ensure each string is used at most once.
 *      - Update dp[i][j] as the maximum of current dp[i][j] and the value obtained by including the string.
 *
 * ## Complexity:
 *      - Time complexity: O(k * m * n), where k = number of strings
 *      - Space complexity: O(m * n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Triple(
            arrayOf("10", "0001", "111001", "1", "0"), 5, 3
        ),
        Triple(
            arrayOf("10", "0", "1"), 1, 1
        )
    )

    testCases.forEach { (strs, m, n) ->
        val solution = Solution11()
        println("Result ==> ${solution.findMaxForm(strs, m, n)}")
    }

}

class Solution11 {
    fun findMaxForm(strs: Array<String>, m: Int, n: Int): Int {
        val dp = Array(m + 1) { IntArray(n + 1) }

        for (str in strs) {
            val (zeros, ones) = count(str)
            for (i in m downTo zeros) {
                for (j in n downTo ones) {
                    dp[i][j] = maxOf(dp[i][j], 1 + dp[i - zeros][j - ones])
                }
            }
        }
        return dp[m][n]
    }

    private fun count(str: String): Pair<Int, Int> {
        var zeros = 0
        var ones = 0
        for (ch in str) if (ch == '1') ones++ else zeros++
        return Pair(zeros, ones)
    }
}


class Solution11_2 {
    private lateinit var cntPair: Array<Pair<Int, Int>>
    private lateinit var dp: Array<Array<IntArray>>

    fun findMaxForm(strs: Array<String>, m: Int, n: Int): Int {
        cntPair = Array(strs.size) { oneAndZero(strs[it]) }

        dp = Array(strs.size + 1) {
            Array(m + 1) {
                IntArray(n + 1) { -1 }
            }
        }

        return f(0, m, n)
    }

    private fun f(i: Int, m: Int, n: Int): Int {
        if (i >= cntPair.size) return 0

        if (dp[i][m][n] != -1) return dp[i][m][n]

        val skip = f(i + 1, m, n)
        val (zeros, ones) = cntPair[i]
        var take = 0
        if (m >= zeros && n >= ones) {
            take = 1 + f(i + 1, m - zeros, n - ones)
        }

        dp[i][m][n] = maxOf(skip, take)
        return dp[i][m][n]
    }

    private fun oneAndZero(str: String): Pair<Int, Int> {
        var zero = 0
        var one = 0
        for (ch in str) if (ch == '1') one++ else zero++
        return Pair(zero, one)
    }
}

// TLE ::TC - O(2^n)
class Solution11_1 {
    val cntPair = ArrayList<Pair<Int, Int>>() // (zero, one)

    fun findMaxForm(strs: Array<String>, m: Int, n: Int): Int {
        for (string in strs) {
            cntPair.add(
                oneAndZero(string)
            )
        }
        return f(0, m, n)
    }

    private fun f(i: Int, m: Int, n: Int): Int {
        if (i >= cntPair.size) return 0
        val skip = f(i + 1, m, n)
        val (zeros, ones) = cntPair[i]
        var take = 0
        if (m >= zeros && n >= ones) {
            take = 1 + f(i + 1, m - zeros, n - ones)
        }
        return max(skip, take)
    }

    private fun oneAndZero(str: String): Pair<Int, Int> {
        var zero = 0
        var one = 0
        for (ch in str) if (ch == '1') one++ else zero++
        return Pair(zero, one)
    }
}
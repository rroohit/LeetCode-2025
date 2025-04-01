package d_april

import kotlin.math.max

/**
 *  Problem 1. Solving Questions With Brainpower.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        arrayOf(
            intArrayOf(3, 2),
            intArrayOf(4, 3),
            intArrayOf(4, 4),
            intArrayOf(2, 5)
        )
    )

    testCases.forEach { questions ->
        println("Result ==> ${mostPoints(questions)}")
    }

}

// - Time Complexity
//  - Each state dfs(i) is computed at most once due to memoization
//  - There are n different states from 0 to n - 1
//  # Thus overall Time complexity is O(n)
// ----------------------------------------------------------------------
// - Space Complexity
//  - Recursive Stack Space : The worst case recursion depth is O(n) leading to O(n) space.
//  - Memoization Array dp stores n elements taking O(n) space
//  # Thus total time complexity is O(n)
private lateinit var mQues: Array<IntArray>
private var n = 0
private lateinit var dp: Array<Long>
fun mostPoints(questions: Array<IntArray>): Long {
    mQues = questions
    n = mQues.size
    dp = Array(n) { 0L }
    return dfs(0)
}

private fun dfs(i: Int): Long {
    if (i >= n) return 0L
    if (dp[i] > 0L) return dp[i]

    // choose to solve
    val solve = mQues[i][0] + dfs(i + 1 + mQues[i][1])

    // choose to skip
    val skip = dfs(i + 1)

    dp[i] = max(solve, skip)
    return dp[i]
}
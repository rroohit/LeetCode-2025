package f_june

/**
 *  Problem 30.Longest Harmonious Subsequence.
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
        intArrayOf(1, 3, 2, 2, 5, 2, 3, 7),
        intArrayOf(1, 2, 3, 4),
        intArrayOf(1, 1, 1, 1)
    )

    testCases.forEach { nums ->
        println("Result ==> ${findLHS(nums)}")
    }

}

fun findLHS(nums: IntArray): Int {
    val freq = nums.asSequence().groupingBy { it }.eachCount()
    var result = 0
    for ((num, count) in freq) {
        freq[num + 1]?.let {
            result = maxOf(result, count + it)
        }
    }
    return result
}

package b_february

/**
 *  Problem 9. Count Number of Bad Pairs.
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
        intArrayOf(4, 1, 3, 3),
        intArrayOf(1, 2, 3, 4, 5)
    )

    testCases.forEach { nums ->
        println("Result ==> ${countBadPairs(nums)}")
    }

}

fun countBadPairs(nums: IntArray): Long {
    var ans = 0L
    val map = HashMap<Int, Int>()
    for (i in nums.indices) {
        val diff = i - nums[i]
        val goodPair = map.getOrDefault(diff, 0)
        ans += i - goodPair
        map[diff] = goodPair + 1
    }
    return ans
}
package d_april

/**
 *  Problem 28. Count Subarrays With Score Less Than K.
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

    val testCases = listOf(
        Pair(
            intArrayOf(2, 1, 4, 3, 5), 10L
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${countSubarrays(test.first, test.second)}")
    }

}

fun countSubarrays(nums: IntArray, k: Long): Long {
    val n = nums.size
    var res: Long = 0
    var total: Long = 0
    var i = 0
    var j = 0
    while (j < n) {
        total += nums[j]
        while (i <= j && total * (j - i + 1) >= k) {
            total -= nums[i]
            i++
        }
        res += (j - i + 1)
        j++
    }
    return res
}
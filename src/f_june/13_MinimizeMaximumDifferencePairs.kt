package f_june

/**
 *  Problem 13. Minimize the Maximum Difference of Pairs.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity:  O(n * logV + n * logn)
 *
 *
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(10, 1, 2, 7, 1, 3), 2
        ),
        Pair(
            intArrayOf(4, 2, 1, 2), 1
        )
    )

    testCases.forEach { (nums, p) ->
        println("Result ==> ${minimizeMax(nums, p)}")
    }

}

fun minimizeMax(nums: IntArray, p: Int): Int {
    nums.sort()
    var left = 0
    var right = nums.last() - nums.first()

    while (left < right) {
        val mid = left + (right - left) / 2
        if (countValidPairs(nums, mid) >= p) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return left
}

private fun countValidPairs(nums: IntArray, threshold: Int): Int {
    var index = 0
    var count = 0
    while (index < nums.size - 1) {
        if (nums[index + 1] - nums[index] <= threshold) {
            count++
            index++
        }
        index++
    }
    return count
}

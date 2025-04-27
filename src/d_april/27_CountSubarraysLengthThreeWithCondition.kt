package d_april

/**
 *  Problem 27. Count Subarrays of Length Three With a Condition.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O()
 *
 *       - Space complexity: O()
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(1, 2, 1, 4, 1),
        intArrayOf(1, 1, 1)
    )

    testCases.forEach { nums ->
        println("Result ==> ${countSubarrays(nums)}")
    }

}

fun countSubarrays(nums: IntArray): Int {
    var count = 0

    for (i in 1..<nums.size - 1) {
        val first = nums[i - 1]
        val last = nums[i + 1]
        if (nums[i] == (first + last) * 2) count++
    }

    return count
}
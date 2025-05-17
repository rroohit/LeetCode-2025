package e_may

/**
 *  Problem 17. Sort Colors.
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
        intArrayOf(2, 0, 2, 1, 1, 0),
        intArrayOf(2, 0, 1),
        intArrayOf(2, 2, 2, 0, 0, 0, 1, 1, 1)
    )

    testCases.forEach { nums ->
        sortColors(nums)
        println("Result ==> ${nums.toList()}")
    }

}

fun sortColors(nums: IntArray): Unit {
    var l = 0
    var m = 0
    var r = nums.size - 1

    while (m <= r) {
        when (nums[m]) {
            0 -> {
                val temp = nums[l]
                nums[l++] = 0
                nums[m++] = temp
            }

            2 -> {
                val temp = nums[r]
                nums[r--] = 2
                nums[m] = temp
            }

            else -> m++
        }
    }
}
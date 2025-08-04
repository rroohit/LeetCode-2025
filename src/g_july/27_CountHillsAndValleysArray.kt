package g_july

/**
 *  Problem 27. Count Hills and Valleys in an Array.
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
        intArrayOf(2, 4, 1, 1, 6, 5),
        intArrayOf(6, 6, 5, 5, 4, 1)
    )

    testCases.forEach { nums ->
        println("Result ==> ${countHillValley(nums)}")
    }//

}

fun countHillValley(nums: IntArray): Int {
    var res = 0
    val n = nums.size
    for (i in 1..<n - 1) {
        if (nums[i] == nums[i - 1]) continue

        var left = 0
        for (j in i - 1 downTo 0) {
            if (nums[j] > nums[i]) {
                left = 1
                break
            } else if (nums[j] < nums[i]) {
                left = -1
                break
            }
        }

        var right = 0
        for (j in i + 1..<n) {
            if (nums[j] > nums[i]) {
                right = 1
                break
            } else if (nums[j] < nums[i]) {
                right = -1
                break
            }
        }

        if (left == right && left != 0) ++res
    }

    return res
}

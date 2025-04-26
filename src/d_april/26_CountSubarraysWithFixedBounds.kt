package d_april

/**
 *  Problem 26. Count Subarrays With Fixed Bounds.
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
        Triple(
            intArrayOf(1, 3, 5, 2, 7, 5), 1, 5
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${countSubarrays(test.first, test.second, test.third)}")
    }

}

fun countSubarrays(nums: IntArray, minK: Int, maxK: Int): Long {
    var lastMinK = -1
    var lastMaxK = -1
    var lastInvalid = -1
    var count = 0L

    for (i in nums.indices) {
        if (nums[i] < minK || nums[i] > maxK) lastInvalid = i
        if (nums[i] == minK) lastMinK = i
        if (nums[i] == maxK) lastMaxK = i

        val validStart = minOf(lastMinK, lastMaxK)
        if (validStart > lastInvalid) {
            count += (validStart - lastInvalid)
        }
    }
    return count
}
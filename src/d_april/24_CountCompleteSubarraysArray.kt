package d_april

/**
 *  Problem 24. Count Complete Subarrays in an Array.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n^2)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(1, 3, 1, 2, 2),
        intArrayOf(5, 5, 5, 5)
    )

    testCases.forEach { nums ->
        println("Result ==> ${countCompleteSubarrays(nums)}")
    }

}

fun countCompleteSubarrays(nums: IntArray): Int {
    val distNums = HashSet<Int>()
    for (num in nums) distNums.add(num)

    var count = 0

    for (i in nums.indices) {
        val subArray = HashSet<Int>()
        subArray.add(nums[i])
        if (subArray.size == distNums.size) count++
        for (j in i + 1..<nums.size) {
            subArray.add(nums[j])
            if (subArray.size == distNums.size) count++
        }
    }

    return count
}
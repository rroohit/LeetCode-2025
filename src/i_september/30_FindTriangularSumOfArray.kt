package i_september

/**
 *  Problem 30. Find Triangular Sum of an Array.
 *
 *  ## Intuition -
 *      Reduce the array step by step by summing adjacent elements (mod 10)
 *          until only one element remains.
 *
 *  ## Approach -
 *      Use in-place updates: iterate over the array layer by layer,
 *          updating values with (prev + curr) % 10 until reaching the last element.
 *
 *  ## Complexity:
 *       - Time complexity: O(n^2)
 *          // nested iterations
 *       - Space complexity: O(1)
 *          // in-place computation
 *
 *  ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(1, 2, 3, 4, 5),
        intArrayOf(5)
    )

    testCases.forEach { nums ->
        println("Result ==> ${triangularSum(nums)}")
    }


}

// TC - O(n^2) :: SC - O(1)
fun triangularSum(nums: IntArray): Int {
    val n = nums.size
    if (n == 1) return nums[0]
    var last = nums[0]
    for (i in 1..<n) {
        for (j in i..<n) {
            val curr = nums[j]
            nums[j] = (curr + last) % 10
            last = curr
        }
        last = nums[i]
    }
    return last
}
















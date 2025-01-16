package a_january

/**
 *  Problem 16. Bitwise XOR of All Pairings.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n + m)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(2, 1, 3),
            intArrayOf(10, 2, 5, 0)
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${xorAllNums(test.first, test.second)}")
    }

}

fun xorAllNums(nums1: IntArray, nums2: IntArray): Int {
    var xor1 = 0
    var xor2 = 0

    val len1: Int = nums1.size
    val len2: Int = nums2.size

    if (len2 % 2 != 0) {
        for (num in nums1) {
            xor1 = xor1 xor num
        }
    }

    if (len1 % 2 != 0) {
        for (num in nums2) {
            xor2 = xor2 xor num
        }
    }

    return xor1 xor xor2
}
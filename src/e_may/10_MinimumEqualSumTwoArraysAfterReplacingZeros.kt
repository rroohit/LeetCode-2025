package e_may

import kotlin.math.max

/**
 *  Problem 10. Minimum Equal Sum of Two Arrays After Replacing Zeros.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(max(nums1.size, nums2.size))
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(3, 2, 0, 1, 0),
            intArrayOf(6, 5, 0)
        ),
        Pair(
            intArrayOf(2, 0, 2, 0),
            intArrayOf(1, 4)
        )
    )

    testCases.forEach { (nums1, nums2) ->
        println("Result ==> ${minSum(nums1, nums2)}")
    }

}

fun minSum(nums1: IntArray, nums2: IntArray): Long {
    var sumOne = 0L
    var sumTwo = 0L
    var zeroOne = 0L
    var zeroTwo = 0L

    for (i in 0..<max(nums1.size, nums2.size)) {
        if (i < nums1.size) {
            sumOne += nums1[i]
            if (nums1[i] == 0) {
                sumOne++
                zeroOne++
            }
        }

        if (i < nums2.size) {
            sumTwo += nums2[i]
            if (nums2[i] == 0) {
                sumTwo++
                zeroTwo++
            }
        }
    }

    if ((zeroOne == 0L && sumTwo > sumOne) || (zeroTwo == 0L && sumOne > sumTwo)) return -1
    return max(sumOne, sumTwo)
}
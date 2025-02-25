package b_february

/**
 *  Problem 25. Number of Sub-arrays With Odd Sum.
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
        intArrayOf(1, 3, 5),
        intArrayOf(2, 4, 6),
        intArrayOf(1, 2, 3, 4, 5, 6, 7)
    )

    testCases.forEach { arr ->
        println("Result ==> ${numOfSubarrays(arr)}")
    }

}

fun numOfSubarrays(arr: IntArray): Int {
    val mod = 1000000007
    var count = 0
    var prefixSum = 0
    var oddCount = 0
    var evenCount = 1

    for (num in arr) {
        prefixSum += num
        if (prefixSum % 2 == 0) {
            count += oddCount
            evenCount++
        } else {
            count += evenCount
            oddCount++
        }
        count %= mod
    }

    return count
}
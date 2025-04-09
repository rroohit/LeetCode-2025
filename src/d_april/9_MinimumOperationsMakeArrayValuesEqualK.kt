package d_april

/**
 *  Problem 9. Minimum Operations to Make Array Values Equal to K.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(5, 2, 5, 4, 5), 2
        ),
        Pair(
            intArrayOf(2, 1, 2), 2
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${minOperations(test.first, test.second)}")
    }

}

fun minOperations(nums: IntArray, k: Int): Int {
    val uniq = HashSet<Int>()
    for (num in nums) {
        if (num < k) return -1
        if (num > k) uniq.add(num)
    }
    return uniq.size
}
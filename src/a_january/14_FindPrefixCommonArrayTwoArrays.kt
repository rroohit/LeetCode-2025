package a_january

/**
 *  Problem 14. Find the Prefix Common Array of Two Arrays.
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
            intArrayOf(1, 3, 2, 4),
            intArrayOf(3, 1, 2, 4)
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${findThePrefixCommonArray(test.first, test.second).toList()}")
    }

}

fun findThePrefixCommonArray(A: IntArray, B: IntArray): IntArray {

    return intArrayOf()
}
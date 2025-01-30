package a_january


/**
 *  Problem 29. Redundant Connection.
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
        arrayOf(intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(2, 3)),
        arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4), intArrayOf(1, 4), intArrayOf(1, 5))
    )

    testCases.forEach { edges ->
        println("Result ==> ${findRedundantConnection(edges).toList()}")
    }

}

fun findRedundantConnection(edges: Array<IntArray>): IntArray {


    return intArrayOf()
}


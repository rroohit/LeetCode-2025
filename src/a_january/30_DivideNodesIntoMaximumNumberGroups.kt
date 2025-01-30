package a_january


/**
 *  Problem 30. Divide Nodes Into the Maximum Number of Groups.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O()
 *
 *       - Space complexity: O()
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            6,
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(1, 4),
                intArrayOf(1, 5),
                intArrayOf(2, 6),
                intArrayOf(2, 3),
                intArrayOf(4, 6)
            )
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${magnificentSets(test.first, test.second)}")
    }

}

fun magnificentSets(n: Int, edges: Array<IntArray>): Int {

    return 0
}
package e_may

/**
 *  Problem 20. Zero Array Transformation I.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n + m)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(1, 0, 1),
            arrayOf(intArrayOf(0, 2))
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${isZeroArray(test.first, test.second)}")
    }

}

fun isZeroArray(nums: IntArray, queries: Array<IntArray>): Boolean {
    val deltaArray = IntArray(nums.size + 1)
    for (query in queries) {
        val left = query[0]
        val right = query[1]
        deltaArray[left] += 1
        deltaArray[right + 1] -= 1
    }

    val operationCounts = IntArray(deltaArray.size)
    var currentOperations = 0
    for (i in deltaArray.indices) {
        currentOperations += deltaArray[i]
        operationCounts[i] = currentOperations
    }
    for (i in nums.indices) {
        if (operationCounts[i] < nums[i]) {
            return false
        }
    }
    return true
}

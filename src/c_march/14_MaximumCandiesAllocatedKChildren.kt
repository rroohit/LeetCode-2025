package c_march

/**
 *  Problem 14. Maximum Candies Allocated to K Children.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n log m)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(5, 8, 6),
            3L
        ),
        Pair(
            intArrayOf(2, 5),
            11L
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${maximumCandies(test.first, test.second)}")
    }

}

fun maximumCandies(candies: IntArray, k: Long): Int {
    var maxCandiesInPile = 0
    for (candy in candies) {
        if (candy > maxCandiesInPile) maxCandiesInPile = candy
    }

    var left = 0
    var right = maxCandiesInPile
    while (left < right) {
        val middle = (left + right + 1) / 2
        if (canAllocateCandies(candies, k, middle)) {
            left = middle
        } else {
            right = middle - 1
        }
    }

    return left
}

private fun canAllocateCandies(
    candies: IntArray,
    k: Long,
    numOfCandies: Int
): Boolean {
    var maxNumOfChildren: Long = 0
    for (pileIndex in candies.indices) {
        maxNumOfChildren += (candies[pileIndex] / numOfCandies).toLong()
    }
    return maxNumOfChildren >= k
}
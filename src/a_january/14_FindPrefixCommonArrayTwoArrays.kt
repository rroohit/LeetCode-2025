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
    val n: Int = A.size
    val prefixCommonArray = IntArray(n)
    val frequency = IntArray(n + 1)
    var commonCount = 0

    for (currentIndex in 0..<n) {
        frequency[A[currentIndex]] += 1
        if (frequency[A[currentIndex]] == 2) ++commonCount
        frequency[B[currentIndex]] += 1
        if (frequency[B[currentIndex]] == 2) ++commonCount

        prefixCommonArray[currentIndex] = commonCount
    }

    return prefixCommonArray
}
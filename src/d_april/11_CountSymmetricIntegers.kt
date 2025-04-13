package d_april

/**
 *  Problem 11. Count Symmetric Integers.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(high - low)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(1, 100),
        Pair(1200, 1230)
    )

    testCases.forEach { test ->
        println("Result ==> ${countSymmetricIntegers(test.first, test.second)}")
    }

}

fun countSymmetricIntegers(low: Int, high: Int): Int {
    var count = 0
    for (i in low..high) {
        if (i < 100 && i % 11 == 0) {
            count++
        } else if (i in 1000..9999) {
            val left = i / 1000 + (i % 1000) / 100
            val right = (i % 100) / 10 + (i % 10)
            if (left == right) count++
        }
    }
    return count
}
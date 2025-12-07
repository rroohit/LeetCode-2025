package l_december

/**
 * Problem 7. Count Odd Numbers in an Interval Range.
 *
 * ## Intuition
 *      Any continuous integer range has roughly half odd and half even numbers.
 *      If the range length is even, exactly half will be odd.
 *      If the range length is odd, then the count of odds depends on whether the range
 *      starts or ends with an odd number.
 *
 * ## Approach
 *      - Compute the total number of integers in [low, high].
 *      - Half of them are odd (`total / 2`) in the base case.
 *      - If the total count is odd and either `low` or `high` is odd,
 *         increment the result by 1 to account for the extra odd number.
 *
 * ## Complexity
 *      - Time complexity: O(1)
 *      - Space complexity: O(1)
 *
 * ## Code
 */
fun main() {

    val testCases = listOf(
        Pair(3, 7),
        Pair(3, 3),
        Pair(6, 6),
        Pair(2, 6),
    )

    testCases.forEach { (low, high) ->
        println("Result ==> ${countOdds(low, high)}")
    }

}

fun countOdds(low: Int, high: Int): Int {
    val total = high - low + 1
    var half = total / 2
    if (total and 1 == 1) {
        if (low and 1 == 1 || high and 1 == 1) half++
    }
    return half
}

fun countOdds1(low: Int, high: Int): Int {
    var cnt = 0
    for (num in low..high) if (num and 1 == 1) cnt++
    return cnt
}
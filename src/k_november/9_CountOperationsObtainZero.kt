package k_november

/**
 * Problem 9. Count Operations to Obtain Zero.
 *
 * ## Intuition -
 *  The problem reduces to repeatedly subtracting the smaller number from the larger one.
 *  Instead of performing each subtraction individually, we can optimize by using division
 *  to count how many times the smaller number fits into the larger one.
 *
 * ## Approach -
 *  - Initialize two variables `a` and `b` with the input values.
 *  - While both numbers are greater than zero:
 *      - Add `a / b` to the operation count (number of subtractions in one step).
 *      - Update `a` as `a % b` (the remainder after multiple subtractions).
 *      - Swap `a` and `b` to continue until one becomes zero.
 *  - Return the total operation count.
 *
 * ## Complexity:
 *   - Time complexity: O(log(min(num1, num2))) — similar to the Euclidean algorithm.
 *   - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(2, 3),
        Pair(10, 10),
        Pair(4, 9)
    )

    testCases.forEach { (num1, num2) ->
        println("Result ==> ${countOperations(num1, num2)}")
    }

}

fun countOperations(num1: Int, num2: Int): Int {
    var a = num1
    var b = num2
    var op = 0
    while (a > 0 && b > 0) {
        op += a / b
        a %= b
        val t = a
        a = b
        b = t
    }
    return op
}


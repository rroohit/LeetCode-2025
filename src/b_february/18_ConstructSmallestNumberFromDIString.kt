package b_february

import java.util.*


/**
 *  Problem 18. Construct Smallest Number From DI String.
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
        "IIIDIDDD",
        "DDD"
    )

    testCases.forEach { pattern ->
        println("Result ==> ${smallestNumber(pattern)}")
    }

}

fun smallestNumber(pattern: String): String {
    val result = StringBuilder()
    val numStack = Stack<Int>()

    for (index in 0..pattern.length) {
        numStack.push(index + 1)
        if (index == pattern.length || pattern[index] == 'I') {
            while (!numStack.isEmpty()) {
                result.append(numStack.pop())
            }
        }
    }

    return result.toString()
}
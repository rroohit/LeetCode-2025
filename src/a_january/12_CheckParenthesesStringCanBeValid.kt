package a_january

import java.util.*


/**
 *  Problem 12. Check if a Parentheses String Can Be Valid.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            ")(",
            "00"
        ),
        Pair(
            "((()(()()))()((()()))))()((()(()",
            "10111100100101001110100010001001"
        )

    )

    testCases.forEach { test ->
        println("Result ==> ${canBeValid(test.first, test.second)}")
    }

}

fun canBeValid(s: String, locked: String): Boolean {
    val n = s.length
    if (n % 2 == 1) return false

    val openBrackets = Stack<Int>()
    val unlocked = Stack<Int>()

    for (i in 0..<n) {
        when {
            locked[i] == '0' -> unlocked.push(i)
            s[i] == '(' -> openBrackets.push(i)
            s[i] == ')' -> when {
                !openBrackets.empty() -> openBrackets.pop()
                !unlocked.empty() -> unlocked.pop()
                else -> return false
            }
        }
    }

    while (
        !openBrackets.empty() &&
        !unlocked.empty() &&
        openBrackets.peek() < unlocked.peek()
    ) {
        openBrackets.pop()
        unlocked.pop()
    }

    return openBrackets.empty()
}

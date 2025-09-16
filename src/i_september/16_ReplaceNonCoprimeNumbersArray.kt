package i_september

import java.util.Stack

/**
 *  Problem 16. Replace Non-Coprime Numbers in Array.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n + logm)
 *
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(6, 4, 3, 2, 7, 6, 2),
        intArrayOf(2, 2, 1, 1, 3, 3, 3),
        intArrayOf(31, 97561, 97561, 97561, 97561, 97561, 97561, 97561, 97561)
    )

    testCases.forEach { nums ->
        println("Result ==> ${replaceNonCoprimes(nums)}")
    }

}

fun replaceNonCoprimes(nums: IntArray): List<Int> {
    val stack = Stack<Long>()

    for (num in nums) {
        var b = num.toLong()
        while (stack.isNotEmpty()) {
            val a = stack.peek() ?: break
            val gcd = getGCD(a, b)
            if (gcd == 1L) break
            stack.pop()
            b = getLCM(a, b)
        }
        stack.push(b)
    }

    return stack.map { it.toInt() }
}

private fun getLCM(a: Long, b: Long): Long {
    val lcm = (a * b) / getGCD(a, b)
    return lcm
}

private fun getGCD(a: Long, b: Long): Long {
    if (b == 0L) return a
    return getGCD(b, a % b)
}



















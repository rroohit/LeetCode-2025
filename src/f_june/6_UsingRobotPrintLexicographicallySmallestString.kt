package f_june

import java.util.*


/**
 *  Problem 6. Using a Robot to Print the Lexicographically Smallest String.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n + ∣Σ∣)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        "zza",
        "bac",
        "bdda"
    )

    testCases.forEach { s ->
        println("Result ==> ${robotWithString(s)}")
    }

}

fun robotWithString(s: String): String {
    val cnt = IntArray(26)
    for (c in s.toCharArray()) {
        cnt[c.code - 'a'.code]++
    }

    val stack = Stack<Char?>()
    val res = StringBuilder()
    var minCharacter = 'a'
    for (c in s.toCharArray()) {
        stack.push(c)
        cnt[c.code - 'a'.code]--
        while (minCharacter != 'z' && cnt[minCharacter.code - 'a'.code] == 0) {
            minCharacter++
        }
        while (!stack.isEmpty() && stack.peek()!! <= minCharacter) {
            res.append(stack.pop())
        }
    }

    return res.toString()
}
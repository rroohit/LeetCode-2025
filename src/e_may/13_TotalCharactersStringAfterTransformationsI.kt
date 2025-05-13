package e_may

/**
 *  Problem 13. Total Characters in String After Transformations I.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(|s| + 26 * t)
 *
 *       - Space complexity: O(26) -> O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair("abcyy", 2)
    )

    testCases.forEach { test ->
        println("Result ==> ${lengthAfterTransformations(test.first, test.second)}")
    }

}

fun lengthAfterTransformations(s: String, t: Int): Int {
    val mod = 1_000_000_007L
    val count = LongArray(26)
    for (ch in s) count[ch - 'a']++

    repeat(t) {
        val newCount = LongArray(26)
        for (i in 0..<25) {
            newCount[i + 1] = (newCount[i + 1] + count[i]) % mod
        }
        // 'z' → "ab"
        val zCount = count[25]
        newCount[0] = (newCount[0] + zCount) % mod
        newCount[1] = (newCount[1] + zCount) % mod

        // Copy back for next step
        for (i in 0..25) {
            count[i] = newCount[i]
        }
    }

    val result = count.fold(0L) { acc, x -> (acc + x) % mod }
    return result.toInt()
}
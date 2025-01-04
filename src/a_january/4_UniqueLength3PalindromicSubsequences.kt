package a_january

/**
 *  Problem 4. Unique Length-3 Palindromic Subsequences.
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
        "aabca",
        "adc",
        "bbcbaba", // 4
        "aaaaaaaaaaaaaa"

    )

    testCases.forEach { s: String ->
        println("Result ==> ${countPalindromicSubsequence(s)}")
        println()
    }

}

fun countPalindromicSubsequence(s: String): Int {
    val leftIndex = IntArray(26) { -1 }
    val rightIndex = IntArray(26) { -1 }
    for (i in s.indices) {
        val ch = s[i]
        if (leftIndex[ch - 'a'] == -1) leftIndex[ch - 'a'] = i
        rightIndex[ch - 'a'] = i
    }

    var count = 0
    for (i in 0..25) {
        if (leftIndex[i] == -1) continue
        val hashSet = HashSet<Char>()
        for (j in leftIndex[i] + 1..< rightIndex[i]) hashSet.add(s[j])
        count += hashSet.size
    }

    return count
}







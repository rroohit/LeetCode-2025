package a_january

/**
 *  Problem 8. Count Prefix and Suffix Pairs I.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n^2)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        arrayOf("a", "aba", "ababa", "aa"),
        arrayOf("pa", "papa", "ma", "mama"),
        arrayOf("abab", "ab")
    )

    testCases.forEach { words ->
        println("Result ==> ${countPrefixSuffixPairs(words)}")
    }

}

fun countPrefixSuffixPairs(words: Array<String>): Int {
    var count = 0
    for (i in words.indices) {
        for (j in i + 1..<words.size) {
            if (isPrefixAndSuffix(words[i], words[j])) count++
        }
    }
    return count
}

private fun isPrefixAndSuffix(str1: String, str2: String): Boolean {
    if (str1.isEmpty()) return true
    if (str1.length > str2.length) return false
    for (i in str1.indices) {
        if (str1[i] != str2[i] || str1[str1.length - i - 1] != str2[str2.length - i - 1]) return false
    }
    return true
}
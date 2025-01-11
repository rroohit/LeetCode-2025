package a_january

/**
 *  Problem 11. Construct K Palindrome Strings.
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
            "annabelle", 2
        ),
        Pair(
            "leetcode", 3
        ),
        Pair(
            "leetcode", 6
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${canConstruct(test.first, test.second)}")
    }

}

fun canConstruct(s: String, k: Int): Boolean {
    val n = s.length
    if (k > n) return false
    if (k == n) return true

    var oddCount = 0

    for (chr in s) {
        oddCount = oddCount xor (1 shl (chr.code - 'a'.code))
    }
    return Integer.bitCount(oddCount) <= k
}

// TC - O(n) :: SC - O(1)
@Suppress("unused")
fun canConstruct1(s: String, k: Int): Boolean {
    val n = s.length
    if (k > n) return false
    if (k == n) return true

    val count = IntArray(26) { 0 }
    for (ch in s) count[ch - 'a']++

    var oddCount = 0
    for (num in count) if (num % 2 != 0) oddCount++


    return (oddCount <= k)
}
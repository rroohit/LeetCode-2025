package a_january

/**
 *  Problem 13. Minimum Length of String After Operations.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(26) - O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        "abaacbcbb",
        "aa",
        "aaa"
    )

    testCases.forEach { s: String ->
        println("Result ==> ${minimumLength(s)}")
    }

}

fun minimumLength(s: String): Int {
    val n = s.length
    if (n <= 2) return n
    val countMap = IntArray(26)
    for (ch in s) countMap[ch - 'a']++

    var len = n
    for (count in countMap) {
        if (count == 0) continue
        if (count > 2) {
            val maxDelete = (count - 1) - ((count -1) % 2)
            len -= maxDelete
        }
    }

    return len
}
package b_february

/**
 *  Problem 5. Check if One String Swap Can Make Strings Equal.
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
        Pair("bank", "kanb")
    )

    testCases.forEach { test ->
        println("Result ==> ${areAlmostEqual(test.first, test.second)}")
    }

}

fun areAlmostEqual(s1: String, s2: String): Boolean {
    val map = IntArray(26)
    for (ch in s1) map[ch - 'a']++
    for (ch in s2) {
        if (map[ch - 'a'] == 0) return false
        map[ch - 'a']--
    }

    var diff = 0
    for (i in s1.indices) {
        if (s1[i] != s2[i]) diff++
    }
    return (diff == 2 || diff == 0)
}
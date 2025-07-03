package g_july

/**
 *  Problem 3. Find the K-th Character in String Game I.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(logk)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        5, 10
    )

    testCases.forEach { k ->
        println("Result ==> ${kthCharacter(k)}")
    }

}

fun kthCharacter(k: Int): Char {
    var k = k
    var ans = 0
    var t: Int
    while (k != 1) {
        t = 31 - Integer.numberOfLeadingZeros(k)
        if ((1 shl t) == k) {
            t--
        }
        k = k - (1 shl t)
        ans++
    }
    return ('a'.code + ans).toChar()
}
package c_march

/**
 *  Problem 8. Minimum Recolors to Get K Consecutive Black Blocks.
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
        Pair("WBBWWBBWBW", 7),
        Pair("WBWBBBW", 2),
        Pair("W", 1),
        Pair("B", 1),
        Pair("WBW", 1),
        Pair("WWW", 1),
    )

    testCases.forEach { test ->
        println("Result ==> ${minimumRecolors(test.first, test.second)}")
    }

}

fun minimumRecolors(blocks: String, k: Int): Int {
    var minOp = blocks.length
    var black = 0
    var white = 0

    for (i in blocks.indices) {
        val ch = blocks[i]
        if (ch == 'W') white++
        if (ch == 'B') black++
        if (white + black == k) {
            if (white <= minOp) minOp = white
            if (blocks[i - (k - 1)] == 'W') white-- else black--
        }
    }

    return minOp
}
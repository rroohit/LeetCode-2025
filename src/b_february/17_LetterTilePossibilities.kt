package b_february

/**
 *  Problem 17. Letter Tile Possibilities.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(2^n)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        "AAB",
        "AAABBC",
        "V"
    )

    testCases.forEach { tiles ->
        println("Result ==> ${numTilePossibilities(tiles)}")
    }

}

fun numTilePossibilities(tiles: String): Int {
    val charCount = IntArray(26)
    for (c in tiles) charCount[c.code - 'A'.code]++
    return findSequences(charCount)
}


private fun findSequences(charCount: IntArray): Int {
    var totalCount = 0
    for (pos in 0..25) {
        if (charCount[pos] == 0) continue
        totalCount++
        charCount[pos]--
        totalCount += findSequences(charCount)
        charCount[pos]++
    }
    return totalCount
}
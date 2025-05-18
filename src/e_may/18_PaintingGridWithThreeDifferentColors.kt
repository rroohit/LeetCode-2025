package e_may

import kotlin.math.pow

/**
 *  Problem 18. Painting a Grid With Three Different Colors.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N * 4^M)
 *
 *       - Space complexity: O(4^m)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(1, 1),
        Pair(1, 2),
        Pair(5, 5)
    )

    testCases.forEach { test ->
        println("Result ==> ${colorTheGrid(test.first, test.second)}")
    }

}

private const val MOD = 1_000_000_007
fun colorTheGrid(m: Int, n: Int): Int {
    val maxMask = 3.0.pow(m.toDouble()).toInt()

    val validMasks = mutableListOf<Int>()

    for (mask in 0..<maxMask) {
        if (isValidColumn(mask, m)) validMasks.add(mask)
    }
    val k = validMasks.size

    val compatibles = Array(k) { mutableListOf<Int>() }
    for (i in 0..<k) {
        for (j in 0..<k) {
            if (areCompatible(validMasks[i], validMasks[j], m)) {
                compatibles[i].add(j)
            }
        }
    }

    var dpPrev = LongArray(k) { 1L }
    var dpCurr = LongArray(k)

    // Process columns 2..n
    for (col in 2..n) {
        dpCurr.fill(0L)
        for (i in 0..<k) {
            val ways = dpPrev[i]
            if (ways == 0L) continue
            for (j in compatibles[i]) {
                dpCurr[j] = (dpCurr[j] + ways) % MOD
            }
        }
        dpPrev = dpCurr.also { dpCurr = dpPrev }
    }

    var result = 0L
    for (x in dpPrev) result = (result + x) % MOD
    return result.toInt()
}

private fun isValidColumn(mask: Int, m: Int): Boolean {
    var prevColor = -1
    var x = mask
    for (i in 0..<m) {
        val color = x % 3
        if (color == prevColor) return false
        prevColor = color
        x /= 3
    }
    return true
}

// Check two columns have no horizontal adjacent equal colors
private fun areCompatible(a: Int, b: Int, m: Int): Boolean {
    var x = a
    var y = b
    for (i in 0..<m) {
        if (x % 3 == y % 3) return false
        x /= 3
        y /= 3
    }
    return true
}
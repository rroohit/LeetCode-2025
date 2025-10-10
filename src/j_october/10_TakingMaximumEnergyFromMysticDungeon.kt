package j_october

import kotlin.math.max

/**
 *  Problem 10. Taking Maximum Energy From the Mystic Dungeon.
 *
 *  ## Intuition -
 *      Each room's maximum energy is the energy in that room plus the maximum
 *          energy reachable by jumping k steps ahead. We can reuse the array to
 *          store these cumulative values.
 *
 *  ## Approach -
 *      - Traverse the array from right to left.
 *      - For each index i, add energy[i + k] to energy[i] if i + k is within bounds.
 *      - Finally, return the maximum value in the updated energy array.
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *          — single pass to update + single pass to find max
 *
 *       - Space complexity: O(1)
 *          — in-place modification of the input array
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(5, 2, -10, -5, 1), 3
        ),
        Pair(
            intArrayOf(-2, -3, -1), 2
        )
    )

    testCases.forEach { (energy, k) ->
        println("Result ==> ${maximumEnergy(energy, k)}")
        println(energy.toList())
    }

}

fun maximumEnergy(energy: IntArray, k: Int): Int {
    val n = energy.size
    for (i in n - 1  downTo 0) {
        if (i + k >= n) continue
        energy[i] += energy[i + k]
    }
    var max = energy[0]
    for (en in energy) if (en > max) max = en
    return max
}


// TLE : TC - O(n^2) , SC - O(1)
fun maximumEnergy1(energy: IntArray, k: Int): Int {
    val n = energy.size
    var maxEn = Int.MIN_VALUE
    for (i in 0..<n) {
        var curr = energy[i]
        for (j in i + k..<n step k) curr += energy[j]
        maxEn = max(curr, maxEn)
    }
    return maxEn
}
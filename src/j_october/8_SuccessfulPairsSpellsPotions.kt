package j_october

/**
 * Problem 8. Successful Pairs of Spells and Potions.
 *
 * ## Intuition
 *      For each spell, we want to count potions that form a successful pair
 *      (spell * potion >= success). By sorting potions, we can efficiently
 *      find this count using binary search.
 *
 * ## Approach
 *      1. Sort the potions array.
 *      2. For each spell:
 *          - Compute the minimum required potion value using ceiling division:
 *              target = ceil(success / spell) = (success + spell - 1) / spell
 *          - Use binary search to find the first potion >= target.
 *          - Count of successful pairs = total potions - index found.
 *      3. Store counts in the spells array and return it.
 *
 * ## Complexity
 *      - Time: O((n + m) log m)
 *          where n = spells.size, m = potions.size
 *
 *      - Space: O(1)
 *          - extra (excluding output array)
 *
 * ## Code
 */
fun main() {

    val testCases = listOf(
        Triple(
            intArrayOf(5, 1, 3),
            intArrayOf(1, 2, 3, 4, 5),
            7L
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${successfulPairs(test.first, test.second, test.third).toList()}")
    }

}

fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
    potions.sort()
    for ((i, spell) in spells.withIndex()) {
        val target = (success + spell - 1) / spell
        spells[i] = getCount(potions, target)
    }
    return spells
}

private fun getCount(pot: IntArray, target: Long): Int {
    val n = pot.size
    var l = 0
    var r = n - 1
    while (l <= r) {
        val m = l + (r - l) / 2
        if (pot[m] >= target) {
            r = m - 1
        } else {
            l = m + 1
        }
    }
    return n - l
}















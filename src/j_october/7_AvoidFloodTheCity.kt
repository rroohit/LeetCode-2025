package j_october

import java.util.TreeSet

/**
 *  Problem 7. Avoid Flood in The City.
 *
 *  ## Intuition -
 *      We need to prevent any lake from overflowing. Each rainy day fills a lake, and dry days (0s) can be used
 *          to empty any previously filled lake before it rains there again.
 *
 *  ## Approach -
 *      - Maintain a map `mp` to record the last day each lake was filled.
 *      - Maintain a TreeSet `st` of indices of dry days.
 *      - When it rains on a lake that was already filled, find the earliest dry day (using `ceiling()`) after the
 *          last fill day to dry that lake. If none exists, return an empty array.
 *      - Otherwise, mark rainy days with `-1` and dry days with `1` by default or with the lake number when used to dry it.
 *
 *  ## Complexity:
 *       - Time complexity: O(n log n)
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(1, 2, 3, 4),
        intArrayOf(1, 2, 0, 0, 2, 1),
        intArrayOf(1, 2, 0, 1, 2)
    )

    testCases.forEach { rains ->
        println("Result ==> ${avoidFlood(rains)}")
    }

}

fun avoidFlood(rains: IntArray): IntArray {
    val ans = IntArray(rains.size) { 1 }
    val st = TreeSet<Int>()
    val mp: MutableMap<Int, Int> = HashMap<Int, Int>()
    for (i in rains.indices) {
        if (rains[i] == 0) {
            st.add(i)
        } else {
            ans[i] = -1
            if (mp.containsKey(rains[i])) {
                val it = st.ceiling(mp[rains[i]]) ?: return IntArray(0)
                ans[it] = rains[i]
                st.remove(it)
            }
            mp[rains[i]] = i
        }
    }
    return ans
}
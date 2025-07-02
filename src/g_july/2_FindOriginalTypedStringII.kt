package g_july

import java.util.*


/**
 *  Problem 2. Find the Original Typed String II.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n + k^2)
 *
 *       - Space complexity: O(k)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair("aabbccdd", 7)
    )

    testCases.forEach { (word, k) ->
        println("Result ==> ${possibleStringCount(word, k)}")
    }

}

private const val mod = 1000000007
fun possibleStringCount(word: String, k: Int): Int {
    val n = word.length
    var cnt = 1
    val freq: MutableList<Int> = ArrayList<Int>()
    for (i in 1..<n) {
        if (word[i] == word[i - 1]) {
            ++cnt
        } else {
            freq.add(cnt)
            cnt = 1
        }
    }
    freq.add(cnt)

    var ans: Long = 1
    for (o in freq) {
        ans = (ans * o) % mod
    }
    if (freq.size >= k) {
        return ans.toInt()
    }

    var f = IntArray(k)
    var g = IntArray(k)
    f[0] = 1
    Arrays.fill(g, 1)
    for (i in freq.indices) {
        val fNew = IntArray(k)
        for (j in 1..<k) {
            fNew[j] = g[j - 1]
            if (j - freq[i] - 1 >= 0) {
                fNew[j] = (fNew[j] - g[j - freq[i] - 1] + mod) % mod
            }
        }
        val gNew = IntArray(k)
        gNew[0] = fNew[0]
        for (j in 1..<k) {
            gNew[j] = (gNew[j - 1] + fNew[j]) % mod
        }
        f = fNew
        g = gNew
    }

    return ((ans - g[k - 1] + mod) % mod).toInt()
}

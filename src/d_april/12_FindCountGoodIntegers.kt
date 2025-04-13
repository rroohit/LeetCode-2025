package d_april

import java.util.*
import kotlin.math.pow


/**
 *  Problem 11. Find the Count of Good Integers.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n * k)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(3, 5),
        Pair(1, 4),
        Pair(5, 6)
    )

    testCases.forEach { test ->
        println("Result ==> ${countGoodIntegers(test.first, test.second)}")
    }

}

fun countGoodIntegers(n: Int, k: Int): Long {
    val dict: MutableSet<String> = HashSet()
    val base = 10.0.pow(((n - 1) / 2)).toInt()
    val skip = n and 1

    for (i in base..<base * 10) {
        var s = i.toString()
        s += StringBuilder(s).reverse().substring(skip)
        val palindromicInteger = s.toLong()
        if (palindromicInteger % k == 0L) {
            val chars = s.toCharArray()
            Arrays.sort(chars)
            dict.add(String(chars))
        }
    }

    val factorial = LongArray(n + 1)
    factorial[0] = 1
    for (i in 1..n) {
        factorial[i] = factorial[i - 1] * i
    }
    var ans: Long = 0
    for (s in dict) {
        val cnt = IntArray(10)
        for (c in s.toCharArray()) {
            cnt[c.code - '0'.code]++
        }
        var tot = (n - cnt[0]) * factorial[n - 1]
        for (x in cnt) {
            tot /= factorial[x]
        }
        ans += tot
    }

    return ans
}

package d_april

import kotlin.math.max


/**
 *  Problem 23. Count Largest Group.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n logn)
 *
 *       - Space complexity: O(logn)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        13,
        2
    )

    testCases.forEach { n: Int ->
        println("Result ==> ${countLargestGroup(n)}")
    }


}

fun countLargestGroup(n: Int): Int {
    val hashMap: MutableMap<Int, Int> = HashMap()
    var maxValue = 0
    for (i in 1..n) {
        var key = 0
        var i0 = i
        while (i0 != 0) {
            key += i0 % 10
            i0 /= 10
        }
        hashMap[key] = hashMap.getOrDefault(key, 0) + 1
        maxValue = max(maxValue.toDouble(), hashMap[key]!!.toDouble()).toInt()
    }

    var count = 0
    for ((_, value) in hashMap) {
        if (value == maxValue) {
            ++count
        }
    }
    return count
}


package f_june

import kotlin.math.min


/**
 *  Problem 22. Divide a String Into Groups of Size k.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(max(n,k))
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Triple("abcdefghi", 3, 'x'),
        Triple("abcdefghij", 3, 'x')
    )

    testCases.forEach { (s, k, fill) ->
        println("Result ==> ${divideString(s, k, fill).map { it }}")
    }

}

fun divideString(s: String, k: Int, fill: Char): Array<String> {
    val res: MutableList<String> = ArrayList()
    val n = s.length
    var curr = 0

    while (curr < n) {
        val end = min(curr + k, n)
        res.add(s.substring(curr, end))
        curr += k
    }

    var last: String = res[res.size - 1]
    if (last.length < k) {
        last += fill.toString().repeat(k - last.length)
        res[res.size - 1] = last
    }
    return res.toTypedArray<String>()
}

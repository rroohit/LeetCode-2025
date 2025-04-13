package d_april

/**
 *  Problem 13. Count Good Numbers.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(log n)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        1L,
        4L,
        50L
    )

    testCases.forEach { n ->
        println("Result ==> ${countGoodNumbers(n)}")
    }

}

private var mod: Long = 1000000007

fun countGoodNumbers(n: Long): Int {
    return ((quickmul(5, (n + 1) / 2) * quickmul(4, n / 2)) % mod).toInt()
}

fun quickmul(x: Int, y: Long): Long {
    var y = y
    var ret: Long = 1
    var mul = x.toLong()
    while (y > 0) {
        if (y % 2 == 1L) {
            ret = (ret * mul) % mod
        }
        mul = (mul * mul) % mod
        y /= 2
    }

    return ret
}

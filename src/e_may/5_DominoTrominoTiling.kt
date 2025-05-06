package e_may

/**
 *  Problem 5. Domino and Tromino Tiling.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        3, 1
    )

    testCases.forEach { n: Int ->
        println("Result ==> ${numTilings(n)}")
    }

}

fun numTilings(n: Int): Int {
    val MOD = 1_000_000_007
    if (n == 0) return 1
    if (n == 1) return 1
    if (n == 2) return 2

    val f = IntArray(n + 1)
    val p = IntArray(n + 1)

    f[0] = 1
    f[1] = 1
    f[2] = 2
    p[2] = 1

    for (i in 3..n) {
        p[i] = (p[i - 1] + f[i - 2]) % MOD
        f[i] = ((f[i - 1] + f[i - 2]) % MOD + 2L * p[i - 1] % MOD).toInt() % MOD
    }

    return f[n]
}

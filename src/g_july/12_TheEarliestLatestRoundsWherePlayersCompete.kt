package g_july

import kotlin.math.max
import kotlin.math.min

// The Earliest and Latest Rounds Where Players Compete

private val F = Array(30) { Array(30) { IntArray(30) } }
private val G = Array(30) { Array(30) { IntArray(30) } }
fun earliestAndLatest(n: Int, firstPlayer: Int, secondPlayer: Int): IntArray {
    var firstPlayer = firstPlayer
    var secondPlayer = secondPlayer
    if (firstPlayer > secondPlayer) {
        val temp = firstPlayer
        firstPlayer = secondPlayer
        secondPlayer = temp
    }

    val res = dp(n, firstPlayer, secondPlayer)
    return intArrayOf(res[0], res[1])
}

private fun dp(n: Int, f: Int, s: Int): IntArray {
    if (F[n][f][s] != 0) {
        return intArrayOf(F[n][f][s], G[n][f][s])
    }
    if (f + s == n + 1) {
        return intArrayOf(1, 1)
    }
    // F(n,f,s) = F(n, n + 1 - s, n + 1 - f)
    if (f + s > n + 1) {
        val res = dp(n, n + 1 - s, n + 1 - f)
        F[n][f][s] = res[0]
        G[n][f][s] = res[1]
        return intArrayOf(F[n][f][s], G[n][f][s])
    }

    var earliest = Int.Companion.MAX_VALUE
    var latest = Int.Companion.MIN_VALUE
    val nHalf = (n + 1) / 2

    if (s <= nHalf) {
        for (i in 0..<f) {
            for (j in 0..<s - f) {
                val res = dp(nHalf, i + 1, i + j + 2)
                earliest = min(earliest, res[0])
                latest = max(latest, res[1])
            }
        }
    } else {
        val sPrime = n + 1 - s
        val mid = (n - 2 * sPrime + 1) / 2
        for (i in 0..<f) {
            for (j in 0..<sPrime - f) {
                val res = dp(nHalf, i + 1, i + j + mid + 2)
                earliest = min(earliest, res[0])
                latest = max(latest, res[1])
            }
        }
    }

    F[n][f][s] = earliest + 1
    G[n][f][s] = latest + 1
    return intArrayOf(F[n][f][s], G[n][f][s])
}



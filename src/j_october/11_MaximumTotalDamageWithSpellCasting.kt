package j_october

import d_april.quickmul

/**
 *  Problem 11. Maximum Total Damage With Spell Casting
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O()
 *       - Space complexity: O()
 *
 * ## Code -
 */
fun main() {



}

class Solution1 {
    fun maximumTotalDamage(power: IntArray): Long {
        val count = java.util.TreeMap<Int, Int>()
        for (p in power) {
            count[p] = count.getOrDefault(p, 0) + 1
        }

        val vec = mutableListOf<IntArray>()
        vec.add(intArrayOf(-1_000_000_000, 0))
        for ((key, value) in count) {
            vec.add(intArrayOf(key, value))
        }

        val n = vec.size
        val f = LongArray(n)
        var mx = 0L
        var ans = 0L
        var j = 1

        for (i in 1 until n) {
            while (j < i && vec[j][0] < vec[i][0] - 2) {
                mx = maxOf(mx, f[j])
                j++
            }
            f[i] = mx + 1L * vec[i][0] * vec[i][1]
            ans = maxOf(ans, f[i])
        }

        return ans
    }
}


class Solution2 {

    fun quickmul(x: Long, y: Long, mod: Long): Long {
        var res = 1L
        var cur = x % mod
        var yVar = y
        while (yVar > 0) {
            if ((yVar and 1L) == 1L) {
                res = (res * cur) % mod
            }
            yVar = yVar shr 1
            cur = (cur * cur) % mod
        }
        return res
    }

    fun magicalSum(m: Int, k: Int, nums: IntArray): Int {
        val n = nums.size
        val mod = 1000000007L
        val fac = LongArray(m + 1)
        fac[0] = 1
        for (i in 1..m) {
            fac[i] = (fac[i - 1] * i) % mod
        }

        val ifac = LongArray(m + 1)
        ifac[0] = 1
        ifac[1] = 1
        for (i in 2..m) {
            ifac[i] = quickmul(i.toLong(), mod - 2, mod)
        }
        for (i in 2..m) {
            ifac[i] = (ifac[i - 1] * ifac[i]) % mod
        }

        val numsPower = Array(n) { LongArray(m + 1) }
        for (i in 0 until n) {
            numsPower[i][0] = 1
            for (j in 1..m) {
                numsPower[i][j] = (numsPower[i][j - 1] * nums[i]) % mod
            }
        }

        val f = Array(n) {
            Array(m + 1) {
                Array(m * 2 + 1) {
                    LongArray(k + 1)
                }
            }
        }

        for (j in 0..m) {
            f[0][j][j][0] = (numsPower[0][j] * ifac[j]) % mod
        }

        for (i in 0 until n - 1) {
            for (j in 0..m) {
                for (p in 0..(m * 2)) {
                    for (q in 0..k) {
                        val q2 = (p % 2) + q
                        if (q2 > k) break
                        for (r in 0..(m - j)) {
                            val p2 = p / 2 + r
                            f[i + 1][j + r][p2][q2] =
                                (f[i + 1][j + r][p2][q2] +
                                        (((f[i][j][p][q] * numsPower[i + 1][r]) % mod) * ifac[r]) % mod) % mod
                        }
                    }
                }
            }
        }

        var res = 0L
        for (p in 0..(m * 2)) {
            for (q in 0..k) {
                if (Integer.bitCount(p) + q == k) {
                    res = (res + (f[n - 1][m][p][q] * fac[m]) % mod) % mod
                }
            }
        }

        return res.toInt()
    }
}

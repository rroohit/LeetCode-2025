package j_october

/**
 *  Problem 19. Lexicographically Smallest String After Applying Operations.
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

    val testCases = listOf(
        Triple("5525", 9, 2)
    )

    testCases.forEach { (s, a, b) ->
        val solution = Solution19()
        println("Result ==> ${solution.findLexSmallestString(s, a, b)}")
    }

}

class Solution19 {

    fun findLexSmallestString(s: String, a: Int, b: Int): String {
        val n = s.length
        var res = s
        val doubled = s + s
        val g = gcd(b, n)

        for (i in 0 until n step g) {
            val t = doubled.substring(i, i + n).toCharArray()
            add(t, n, a, 1)
            if (b % 2 != 0) {
                add(t, n, a, 0)
            }
            val tStr = String(t)
            if (tStr < res) {
                res = tStr
            }
        }
        return res
    }

    private fun add(t: CharArray, n: Int, a: Int, start: Int) {
        var minVal = 10
        var times = 0
        for (i in 0 until 10) {
            val added = ((t[start] - '0') + i * a) % 10
            if (added < minVal) {
                minVal = added
                times = i
            }
        }
        for (i in start until n step 2) {
            t[i] = ('0'.code + (((t[i] - '0') + times * a) % 10)).toChar()
        }
    }

    private fun gcd(num1: Int, num2: Int): Int {
        var a = num1
        var b = num2
        while (b != 0) {
            val temp = a
            a = b
            b = temp % b
        }
        return a
    }
}










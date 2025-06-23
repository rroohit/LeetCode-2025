package f_june

/**
 *  Problem 23. Sum of k-Mirror Numbers.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(⎷10^10)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(2, 5),
        Pair(3, 7)
    )

    testCases.forEach { (k, n) ->
        println("Result ==> ${Solution23().kMirror(k, n)}")
    }


}

class Solution23 {
    private val digit = IntArray(100)

    fun kMirror(k: Int, n: Int): Long {
        var left = 1
        var count = 0
        var ans: Long = 0
        while (count < n) {
            val right = left * 10
            for (op in 0..1) {
                // enumerate i'
                var i = left
                while (i < right && count < n) {
                    var combined = i.toLong()
                    var x = (if (op == 0) i / 10 else i)
                    while (x > 0) {
                        combined = combined * 10 + (x % 10)
                        x /= 10
                    }
                    if (isPalindrome(combined, k)) {
                        ++count
                        ans += combined
                    }
                    ++i
                }
            }
            left = right
        }
        return ans
    }

    private fun isPalindrome(x: Long, k: Int): Boolean {
        var x = x
        var length = -1
        while (x > 0) {
            ++length
            digit[length] = (x % k).toInt()
            x /= k.toLong()
        }
        var i = 0
        var j = length
        while (i < j) {
            if (digit[i] != digit[j]) {
                return false
            }
            ++i
            --j
        }
        return true
    }
}
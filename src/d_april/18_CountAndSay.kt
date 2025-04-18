package d_april

/**
 *  Problem 18. Count and Say.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(2^n * n)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        4, 1, 30
    )

    testCases.forEach { n: Int ->
        println("Result ==> ${countAndSay(n)}")
    }

}

fun countAndSay(n: Int): String {
    var res = "1"
    repeat(n - 1) {
        var cur = ""
        var i = 0
        while (i < res.length) {
            var count = 1
            while (i + 1 < res.length && res[i] == res[i + 1]) {
                i++
                count++
            }
            cur += "$count${res[i]}"
            i++
        }
        res = cur
    }
    return res
}
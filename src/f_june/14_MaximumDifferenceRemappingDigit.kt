package f_june

/**
 *  Problem 14. Maximum Difference by Remapping a Digit.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity:  O(log num)
 *
 *
 *       - Space complexity: O(log num)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(11891, 90)

    testCases.forEach { num ->
        println("Result ==> ${minMaxDifference(num)}")
    }

}


fun minMaxDifference(num: Int): Int {
    var s = num.toString()
    var t = s
    var pos = 0

    while (pos < s.length && s[pos] == '9') {
        pos++
    }

    if (pos < s.length) {
        s = s.replace(s[pos], '9')
    }

    t = t.replace(t[0], '0')

    return s.toInt() - t.toInt()
}
package f_june

/**
 *  Problem 15. Max Difference You Can Get From Changing an Integer.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(log(num))
 *
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(555, 9, 22)

    testCases.forEach { num ->
        println("Result ==> ${maxDiff(num)}")
    }

}

fun maxDiff(num: Int): Int {
    val minNum = StringBuffer(num.toString())
    val maxNum = StringBuffer(num.toString())

    val maxLength = maxNum.length
    for (i in 0..<maxLength) {
        val digit = maxNum.get(i)
        if (digit != '9') {
            replace(maxNum, digit, '9')
            break
        }
    }

    val minLength = minNum.length
    for (i in 0..<minLength) {
        val digit = minNum.get(i)
        if (i == 0) {
            if (digit != '1') {
                replace(minNum, digit, '1')
                break
            }
        } else {
            if (digit != '0' && digit != minNum.get(0)) {
                replace(minNum, digit, '0')
                break
            }
        }
    }

    return (maxNum.toString().toInt() - minNum.toString().toInt())
}

fun replace(s: StringBuffer, x: Char, y: Char) {
    val length = s.length
    for (i in 0..<length) {
        if (s.get(i) == x) {
            s.setCharAt(i, y)
        }
    }
}

package z_test

fun main() {

    val testCases = listOf(
        3, 11, 34, 345, 45675, 10000, 500, 100
    )

    testCases.forEach { n ->
        println("Result ==> ${findNthDigit(n)}")
    }
}

fun findNthDigit(n: Int): Int {
    val stringLength = StringLength(n)
    for (i in 1..n) {
        for (ch in "$i") {
            val ans = stringLength.pushChar(ch)
            if (ans != -1) return ans
        }
    }
    return -1
}

class StringLength(private val n: Int) {
    var size = 0
    fun pushChar(char: Char): Int {
        if (++size == n) return char.digitToInt()
        return -1
    }
}
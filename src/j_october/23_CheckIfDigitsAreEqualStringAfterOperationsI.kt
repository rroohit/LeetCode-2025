package j_october

/**
 *  Problem 23. Check If Digits Are Equal in String After Operations I.
 *
 *  ## Intuition -
 *      Repeatedly combine adjacent digits (mod 10) until only two remain.
 *      If the final two digits are equal, return true.
 *
 *  ## Approach -
 *      1. Convert each character in the string to its numeric value.
 *      2. Iteratively replace each element with (nums[i-1] + nums[i]) % 10
 *     and reduce the effective length.
 *      3. Continue until only two digits remain, then compare them.
 *
 *  ## Complexity:
 *       - Time complexity: O(n²)
 *       - Space complexity: O(n)
 *
 *  ## Code -
 */
fun main() {

    val testCases = listOf(
        "3902",
        "34789"
    )

    testCases.forEach { s ->
        println("Result ==> ${hasSameDigits(s)}")
    }

}

fun hasSameDigits(s: String): Boolean {
    val nums = s.map { it.digitToInt() }.toMutableList()
    while (nums.size > 2) {
        for (i in 1..<nums.size) {
            nums[i - 1] = (nums[i - 1] + nums[i]) % 10
        }
        nums.removeLast()
    }
    return nums[0] == nums[1]
}


fun hasSameDigits2(s: String): Boolean {
    val nums = ArrayList<Int>()
    for (ch in s) nums.add(ch.getDigit())

    var len = s.length
    while (len > 2) {
        for (i in 1..<len--) {
            nums[i - 1] = (nums[i - 1] + nums[i]) % 10
        }
    }
    return nums[0] == nums[1]
}

private fun Char.getDigit(): Int {
    return when (this) {
        '1' -> 1
        '2' -> 2
        '3' -> 3
        '4' -> 4
        '5' -> 5
        '6' -> 6
        '7' -> 7
        '8' -> 8
        '9' -> 9
        else -> 0
    }
}

fun hasSameDigits1(s: String): Boolean {
    var last = s
    while (last.length > 2) {
        val curr = StringBuilder()
        for (i in 1..<last.length) {
            val op = (last[i - 1].digitToInt() + last[i].digitToInt()) % 10
            curr.append(op)
        }
        last = curr.toString()
    }
    return last[0] == last[1]
}
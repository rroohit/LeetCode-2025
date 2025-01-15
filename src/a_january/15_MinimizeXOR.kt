package a_january

/**
 *  Problem 15. Minimize XOR.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(logn)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(3, 5),
        Pair(1, 12)
    )

    testCases.forEach { test ->
        println("Result ==> ${minimizeXor(test.first, test.second)}")
    }

}

fun minimizeXor(num1: Int, num2: Int): Int {
    var result = num1

    val targetSetBitsCount = Integer.bitCount(num2)
    var setBitsCount = Integer.bitCount(result)

    var currentBit = 0
    while (setBitsCount < targetSetBitsCount) {
        if (!isSet(result, currentBit)) {
            result = setBit(result, currentBit)
            setBitsCount++
        }
        currentBit++
    }

    while (setBitsCount > targetSetBitsCount) {
        if (isSet(result, currentBit)) {
            result = unsetBit(result, currentBit)
            setBitsCount--
        }
        currentBit++
    }

    return result
}

private fun isSet(x: Int, bit: Int): Boolean {
    return (x and (1 shl bit)) != 0
}

private fun setBit(x: Int, bit: Int): Int {
    return x or (1 shl bit)
}

private fun unsetBit(x: Int, bit: Int): Int {
    return x and (1 shl bit).inv()
}
package a_january

/**
 *  Problem 17. Neighboring Bitwise XOR.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(1, 1, 0),
        intArrayOf(1, 1),
        intArrayOf(1, 0)
    )

    testCases.forEach { derived ->
        println("Result ==> ${doesValidArrayExist(derived)}")
    }

}

fun doesValidArrayExist(derived: IntArray): Boolean {
    var XOR = 0
    for (element in derived) {
        XOR = XOR xor element
    }
    return XOR == 0
}

fun doesValidArrayExist1(derived: IntArray): Boolean {
    val original = IntArray(derived.size + 1)
    original[0] = 0
    for (i in derived.indices) {
        original[i + 1] = derived[i] xor original[i]
    }
    val checkForZero = (original[0] == original[original.size - 1])

    original[0] = 1
    for (i in derived.indices) {
        original[i + 1] = derived[i] xor original[i]
    }
    val checkForOne = (original[0] == original[original.size - 1])

    return checkForZero || checkForOne
}
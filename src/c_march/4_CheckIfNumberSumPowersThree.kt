package c_march

import kotlin.math.pow

/**
 *  Problem 4. Check if Number is a Sum of Powers of Three.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(log3 n)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        12, 91, 21
    )

    testCases.forEach { n: Int ->
        println("Result ==> ${checkPowersOfThree(n)}")
    }

}

fun checkPowersOfThree(n: Int): Boolean {
    var k = n
    while (k > 0) {
        if (k % 3 == 2) {
            return false
        }
        k /= 3
    }
    return true
}

// TC - O(log3N) :: SC - O(1)
fun checkPowersOfThree2(n: Int): Boolean {
    var k = n
    var power = 0

    while (3.0.pow(power.toDouble()) <= k) {
        power++
    }

    while (k > 0) {
        if (k >= 3.0.pow(power.toDouble())) {
            k -= 3.0.pow(power.toDouble()).toInt()
        }
        if (k >= 3.0.pow(power.toDouble())) {
            return false
        }
        power--
    }

    return true
}

// TC - O(2 ^ log2n) :: SC - O(log3N)
fun checkPowersOfThree1(n: Int): Boolean {
    return checkPowersOfThreeHelper(0.0, n.toDouble())
}

private fun checkPowersOfThreeHelper(power: Double, n: Double): Boolean {
    if (n == 0.0) return true
    if (3.0.pow(power) > n) return false

    val addPower = checkPowersOfThreeHelper(
        power + 1,
        n - 3.0.pow(power)
    )

    val skipPower = checkPowersOfThreeHelper(power + 1, n)

    return addPower || skipPower
}
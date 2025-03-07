package c_march

import kotlin.math.sqrt


/**
 *  Problem 7. Closest Prime Numbers in Range.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(min(1452, R - L) * sqrt(R))
 *
 *       - Space complexity: O(R - L)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(10, 19),
        Pair(4, 6)
    )

    testCases.forEach { test ->
        println("Result ==> ${closestPrimes(test.first, test.second).toList()}")
    }

}

fun closestPrimes(left: Int, right: Int): IntArray {
    val primeNumbers: MutableList<Int> = ArrayList()

    for (candidate in left..right) {
        if (candidate % 2 == 0 && candidate > 2) {
            continue
        }
        if (isPrime(candidate)) {
            if (primeNumbers.isNotEmpty() &&
                candidate <= primeNumbers[primeNumbers.size - 1] + 2
            ) {
                return intArrayOf(
                    primeNumbers[primeNumbers.size - 1],
                    candidate,
                )
            }
            primeNumbers.add(candidate)
        }
    }

    if (primeNumbers.size < 2) {
        return intArrayOf(-1, -1)
    }

    var closestPair = intArrayOf(-1, -1)
    var minDifference = 1000000
    for (index in 1..<primeNumbers.size) {
        val difference = primeNumbers[index] - primeNumbers[index - 1]
        if (difference < minDifference) {
            minDifference = difference
            closestPair = intArrayOf(
                primeNumbers[index - 1],
                primeNumbers[index],
            )
        }
    }

    return closestPair
}

private fun isPrime(number: Int): Boolean {
    if (number == 1) return false
    for (divisor in 2..sqrt(number.toDouble()).toInt()) {
        if (number % divisor == 0) return false
    }
    return true
}
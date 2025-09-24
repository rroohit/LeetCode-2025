package i_september

import kotlin.math.abs

/**
 *  Problem 24. Fraction to Recurring Decimal.
 *
 *  ## Intuition -
 *      - Convert fraction to decimal, detect repeating parts using remainders.
 *
 *  ## Approach -
 *      - Handle sign and integer part.
 *      - Use a map to store seen remainders and their positions.
 *      - When a remainder repeats, insert "(" and ")" to mark the cycle.
 *
 *  ## Complexity:
 *       - Time complexity: O(n) where n is length of non-repeating + repeating part.
 *
 *       - Space complexity: O(n) for storing remainders.
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(1, 2),
        Pair(2, 1),
        Pair(4, 333)
    )

    testCases.forEach { (numerator, denominator) ->
        println("Result ==> ${fractionToDecimal(numerator, denominator)}")
        println()
    }

}


fun fractionToDecimal(numerator: Int, denominator: Int): String {
    if (numerator == 0) return "0"

    val sb = StringBuilder()

    if ((numerator.toLong() < 0) xor (denominator.toLong() < 0)) {
        sb.append("-")
    }

    val num = abs(numerator.toLong())
    val den = abs(denominator.toLong())

    sb.append(num / den)
    var remainder = num % den

    if (remainder == 0L) return sb.toString()

    sb.append(".")

    val map = hashMapOf<Long, Int>()

    while (remainder != 0L) {
        if (map.containsKey(remainder)) {
            val index = map[remainder]!!
            sb.insert(index, "(")
            sb.append(")")
            break
        }

        map[remainder] = sb.length

        remainder *= 10
        sb.append(remainder / den)
        remainder %= den
    }

    return sb.toString()
}

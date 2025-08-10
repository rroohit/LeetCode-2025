package h_august

/**
 *  Problem 869. Reordered Power of 2.
 *
 *  ## Intuition -
 *  If two numbers have the same sorted digits, they are digit permutations.
 *  A number can be reordered to a power of 2 if its sorted digits match
 *  the sorted digits of some power of 2.
 *
 *  ## Approach -
 *  1. Convert n to a sorted string (signature).
 *  2. Precompute sorted signatures of all powers of 2 up to 10^9.
 *  3. Return true if n's signature is in that set.
 *
 *  ## Complexity:
 *       - Time complexity: O(1) (O(d log d) with d ≤ 10)
 *       - Space complexity: O(1)
 *
 *  ## Code -
 */
fun main() {

    val testCases = listOf(
        1, 10, 46
    )

    testCases.forEach { n ->
        println("Result ==> ${reorderedPowerOf2(n)}")
    }

}

fun reorderedPowerOf2(n: Int): Boolean {
    val signature = n.toString().toCharArray().sorted().joinToString("")
    val powerSet = mutableSetOf<String>()

    var power = 1
    (0..29).forEach { i ->
        val sortedDigits = power.toString().toCharArray().sorted().joinToString("")
        powerSet.add(sortedDigits)
        power = power shl 1
    }

    return signature in powerSet
}
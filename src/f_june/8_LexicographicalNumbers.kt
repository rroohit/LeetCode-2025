package f_june

/**
 *  Problem 7. Lexicographical Numbers.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O()
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */

fun main() {

    val testCases = listOf(
        13, 2
    )

    testCases.forEach { n ->
        println("Result ==> ${lexicalOrder(n)}")
    }

}

fun lexicalOrder(n: Int): List<Int> {
    val lexicographicalNumbers = mutableListOf<Int>()
    var currentNumber = 1

    repeat(n) {
        lexicographicalNumbers.add(currentNumber)

        if (currentNumber * 10 <= n) {
            currentNumber *= 10
        } else {
            while (currentNumber % 10 == 9 || currentNumber >= n) {
                currentNumber /= 10
            }
            currentNumber += 1
        }
    }

    return lexicographicalNumbers
}
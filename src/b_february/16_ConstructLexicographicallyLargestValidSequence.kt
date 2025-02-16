package b_february

/**
 *  Problem 16. Construct the Lexicographically Largest Valid Sequence.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n!)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        3, 5, 6
    )

    testCases.forEach { targetNumber ->
        println("Result ==> ${constructDistancedSequence(targetNumber).toList()}")
    }


}

fun constructDistancedSequence(targetNumber: Int): IntArray {
    val resultSequence = IntArray(targetNumber * 2 - 1)

    val isNumberUsed = BooleanArray(targetNumber + 1)

    findLexicographicallyLargestSequence(
        0,
        resultSequence,
        isNumberUsed,
        targetNumber
    )

    return resultSequence
}

private fun findLexicographicallyLargestSequence(
    currentIndex: Int,
    resultSequence: IntArray,
    isNumberUsed: BooleanArray,
    targetNumber: Int
): Boolean {
    if (currentIndex == resultSequence.size) return true

    if (resultSequence[currentIndex] != 0) {
        return findLexicographicallyLargestSequence(
            currentIndex + 1,
            resultSequence,
            isNumberUsed,
            targetNumber
        )
    }

    for (numberToPlace in targetNumber downTo 1) {
        if (isNumberUsed[numberToPlace]) continue

        isNumberUsed[numberToPlace] = true
        resultSequence[currentIndex] = numberToPlace

        if (numberToPlace == 1) {
            if (findLexicographicallyLargestSequence(
                    currentIndex + 1,
                    resultSequence,
                    isNumberUsed,
                    targetNumber
                )
            ) {
                return true
            }
        } else if (currentIndex + numberToPlace < resultSequence.size &&
            resultSequence[currentIndex + numberToPlace] == 0
        ) {
            resultSequence[currentIndex + numberToPlace] = numberToPlace

            if (findLexicographicallyLargestSequence(
                    currentIndex + 1,
                    resultSequence,
                    isNumberUsed,
                    targetNumber
                )
            ) {
                return true
            }

            resultSequence[currentIndex + numberToPlace] = 0
        }

        resultSequence[currentIndex] = 0
        isNumberUsed[numberToPlace] = false
    }

    return false
}
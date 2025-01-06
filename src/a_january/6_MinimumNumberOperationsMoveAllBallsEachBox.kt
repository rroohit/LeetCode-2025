package a_january

import kotlin.math.abs

/**
 *  Problem 6. Minimum Number of Operations to Move All Balls to Each Box.
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
        "110",
        "001011"
    )

    testCases.forEach { boxes ->
        println("Result ==> ${minOperations(boxes).toList()}")
    }

}

// TC - O(N) :: SC - O(1)
fun minOperations(boxes: String): IntArray {
    val answer = IntArray(boxes.length)
    var left = 0
    var movesL = 0
    var right = 0
    var movesR = 0

    for (i in boxes.indices) {
        answer[i] += movesL
        left += if (boxes[i] == '1') 1 else 0
        movesL += left

        val j = boxes.length - 1 - i
        answer[j] += right
        movesR += if (boxes[j] == '1') 1 else 0
        right += movesR
    }
    return answer
}

// TC - O(N^2) :: SC - O(1)
@Suppress("unused")
fun minOperations1(boxes: String): IntArray {
    val answer = IntArray(boxes.length)
    for (i in boxes.indices) {
        if (boxes[i] == '1') { // need to distribute this ball
            for (j in boxes.indices) {
                answer[j] += abs(j - i)
            }
        }
    }
    return answer
}
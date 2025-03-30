package c_march

import kotlin.math.max


/**
 *  Problem 30. Partition Labels.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(26) :: O(k)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        "ababcbacadefegdehijhklij"
    )

    testCases.forEach { s ->
        println("Result ==> ${partitionLabels(s)}")
    }

}

fun partitionLabels(s: String): List<Int> {
    val lastInd = IntArray(26)
    for (i in s.indices) lastInd[s[i] - 'a'] = i

    val result = ArrayList<Int>()
    var start = 0
    var end = 0
    for (i in s.indices) {
        end = max(end, lastInd[s[i] - 'a'])
        if (i == end) {
            result.add(i - start + 1)
            start = i + 1
        }
    }

    return result
}
package a_january

import kotlin.math.max

/**
 *  Problem  10. Word Subsets.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n * avgWordLen + m * maxLen)
 *              - n is size of the words1 array
 *              - m is size of the words2 array
 *
 *       - Space complexity: O(n * avgWordLen)
 *              - n is size fo the words2 array
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            arrayOf("amazon", "apple", "facebook", "google", "leetcode"),
            arrayOf("e", "o")
        ),
        Pair(
            arrayOf("amazon", "apple", "facebook", "google", "leetcode"),
            arrayOf("l", "e")
        ),
        Pair(
            arrayOf("amazon", "apple", "facebook", "google", "leetcode"),
            arrayOf("lo", "eo")
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${wordSubsets(test.first, test.second)}")
    }

}

// TC -
fun wordSubsets(words1: Array<String>, words2: Array<String>): List<String> {
    val result = mutableListOf<String>()
    val newCount = IntArray(26)

    for (word in words2) {
        val cnt = word.createCharCount()
        for (i in 0..25) {
            newCount[i] = max(newCount[i], cnt[i])
        }
    }

    for (word in words1) {
        var isUniversal = true
        val mapCount = word.createCharCount()
        for (i in mapCount.indices) {
            if (mapCount[i] < newCount[i]) {
                isUniversal = false
                break
            }
        }

        if (isUniversal) result.add(word)
    }

    return result
}

private fun String.createCharCount(): IntArray {
    val count = IntArray(26)
    for (i in indices) count[get(i) - 'a']++
    return count
}
package a_january

/**
 *  Problem 2. Count Vowel Strings in Ranges.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n + m)
 *
 *       - Space complexity: O(n + m)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            arrayOf("aba", "bcb", "ece", "aa", "e"),
            arrayOf(intArrayOf(0, 2), intArrayOf(1, 4), intArrayOf(1, 1))
        ),
        Pair(
            arrayOf("a", "e", "i"),
            arrayOf(intArrayOf(0, 2), intArrayOf(0, 1), intArrayOf(2, 2))
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${vowelStrings(test.first, test.second).toList()}")
    }

}

fun vowelStrings(words: Array<String>, queries: Array<IntArray>): IntArray {
    val prefixSum = IntArray(words.size + 1) // SC - O(n) -  n size of words.
    for (i in words.indices) { // TC - O(n) - n size of words.
        prefixSum[i + 1] = prefixSum[i] + if (words[i].isValidString()) 1 else 0
    }

    val result = IntArray(queries.size)
    for (i in queries.indices) { // TC - O(m) - size of of queries
        val (start, end) = queries[i] // O(1)
        result[i] = prefixSum[end + 1] - prefixSum[start] // O(n)
    }
    return result
}


fun vowelStrings1(words: Array<String>, queries: Array<IntArray>): IntArray {
    val prefixSum = IntArray(words.size)
    var currSum = 0

    for (i in words.indices) {
        prefixSum[i] = currSum
        currSum += if (words[i].isValidString()) 1 else 0
    }

    val result = IntArray(queries.size)
    for (i in queries.indices) {
        val (start, end) = queries[i]
        var totalString = prefixSum[end] - prefixSum[start]
        totalString += if (words[end].isValidString()) 1 else 0
        result[i] = totalString
    }

    return result
}

private fun String.isValidString(): Boolean {
    if (isEmpty()) return false
    val vowels = setOf('a', 'e', 'i', 'o', 'u')
    return vowels.contains(first()) && vowels.contains(last())
}
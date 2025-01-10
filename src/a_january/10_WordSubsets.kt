package a_january

/**
 *  Problem  10. Word Subsets.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity:
 *
 *       - Space complexity:
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
    val charCount = Array(words2.size) { IntArray(26) } // sp - O(m * 26)
    for (i in words2.indices) { // TC - O(m + maxLen)
        charCount[i] = words2[i].createCharCount() // TC - O(len)
    }

    for (word in words1) { // TC - O(n * m)
        var isUniversal = true
        val mapCount = word.createCharCount() // O(len)
        for (ints in charCount) { // TC - O(m * 26)
            for (i in mapCount.indices) { // TC - O(26)
                if (mapCount[i] >= ints[i]) continue
                isUniversal = false
                break
            }
            if (!isUniversal) break
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
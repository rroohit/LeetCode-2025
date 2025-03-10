package c_march


/**
 *  Problem 10. Count of Substrings Containing Every Vowel and K Consonants II.
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
        Pair("aeioqq", 1),
        Pair("aeiou", 0),
        Pair("ieaouqqieaouqq", 1)
    )

    testCases.forEach { test ->
        println("Result ==> ${countOfSubstrings(test.first, test.second)}")
    }


}

fun countOfSubstrings(word: String, k: Int): Long {
    return atLeastK(word, k) - atLeastK(word, k + 1)
}

private fun atLeastK(word: String, k: Int): Long {
    var numValidSubstrings = 0L
    var start = 0
    var end = 0
    val vowelCount = HashMap<Char, Int>()
    var consonantCount = 0

    while (end < word.length) {
        val newLetter = word[end]

        if (isVowel(newLetter)) {
            vowelCount[newLetter] = vowelCount.getOrDefault(newLetter, 0) + 1
        } else {
            consonantCount++
        }

        while (vowelCount.size == 5 && consonantCount >= k) {
            numValidSubstrings += (word.length - end)
            val startLetter = word[start]
            if (isVowel(startLetter)) {
                vowelCount[startLetter] = vowelCount[startLetter]!! - 1
                if (vowelCount[startLetter] == 0) {
                    vowelCount.remove(startLetter)
                }
            } else {
                consonantCount--
            }
            start++
        }
        end++
    }

    return numValidSubstrings
}

private fun isVowel(c: Char): Boolean {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
}
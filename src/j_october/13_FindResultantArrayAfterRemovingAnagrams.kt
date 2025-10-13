package j_october

/**
 * Problem 13. Find Resultant Array After Removing Anagrams.
 *
 * ## Intuition -
 *      If two adjacent words are anagrams of each other, they contain the same characters
 *          with the same frequency. We can remove the later one since it doesn't change the sequence meaningfully.
 *
 * ## Approach -
 *      - Compute a frequency key for each word (representing character counts).
 *      - Keep the first word and iterate through the rest.
 *      - For each word, compare its key with the previous word’s key.
 *      - If they are different, add the word to the result; otherwise, skip it.
 *
 * ## Complexity:
 *      - Time complexity: O(n * k)
 *          — where n is the number of words and k is the average word length.
 *
 *      - Space complexity: O(1)
 *          — constant extra space for frequency array and keys (excluding output).
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        arrayOf("abba", "baba", "bbaa", "cd", "cd"),
        arrayOf("a", "b", "a")
    )

    testCases.forEach { words ->
        println("Result ==> ${removeAnagrams(words)}")
    }
}


fun removeAnagrams(words: Array<String>): List<String> {
    val result = ArrayList<String>()
    var lastCode: Int? = null
    for (word in words) {
        val freq = IntArray(26) { 0 }
        for (ch in word) freq[ch - 'a']++
        val currCode = freq.contentHashCode()
        if (currCode != lastCode) {
            lastCode = currCode
            result.add(word)
        }
    }
    return result
}

fun removeAnagrams2(words: Array<String>): List<String> {
    val result = ArrayList<String>().apply {
        add(words[0])
    }
    var lastWord = getWordKey(words[0])
    for (i in 1..<words.size) {
        val currWord = getWordKey(words[i])
        if (lastWord != currWord) {
            result.add(words[i])
            lastWord = currWord
        }
    }
    return result
}

private fun getWordKey(word: String): String {
    val chars = word.toCharArray()
    chars.sort()
    return String(chars)
}


private fun removeAnagrams1(words: Array<String>): List<String> {
    val result = ArrayList<String>().apply {
        add(words[0])
    }

    var lastKey = getKey(words[0])
    for (i in 1..<words.size) {
        val currKey = getKey(words[i])
        if (currKey != lastKey) {
            result.add(words[i])
            lastKey = currKey
        }
    }

    return result
}

private fun getKey(word: String): String {
    val ind = IntArray(26) { 0 }
    for (ch in word) {
        ind[ch - 'a']++
    }
    return ind.joinToString("*")
}
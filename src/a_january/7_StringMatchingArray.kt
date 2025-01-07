package a_january


/**
 *  Problem 7. String Matching in an Array.
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
        arrayOf("mass", "as", "hero", "superhero"),
        arrayOf("leetcode", "et", "code"),
        arrayOf("blue", "green", "bu")
    )

    testCases.forEach { words ->
        println("Result ==> ${stringMatching(words)}")
    }

}

// TC - O(n^2 * k) :: SC - O(n * k)
fun stringMatching(words: Array<String>): List<String> {
    val result = mutableListOf<String>()
    for (word in words) { // O(n)
        if (weHaveSubString(words, word)) result.add(word)
    }
    return result
}

private fun weHaveSubString(words: Array<String>, word: String): Boolean {
    var currCount = 0
    for (word1 in words) { // O(n)
        if (word1.contains(word)) currCount++
        if (currCount >= 2) return true
    }
    return false
}

private class Solution7 {
    private data class TrieNode(
        var frequency: Int = 0, // Tracks how many times this substring appears in the Trie.
        var childNodes: MutableMap<Char, TrieNode> = HashMap()  // Maps characters to their respective child nodes.
    )

    fun stringMatching(words: Array<String>): List<String> {
        val matchingWords: MutableList<String> = ArrayList()
        val root = TrieNode()
        for (word in words) {
            for (startIndex in word.indices) {
                insertWord(root, word.substring(startIndex))
            }
        }

        for (word in words) {
            if (isSubstring(root, word)) {
                matchingWords.add(word)
            }
        }

        return matchingWords
    }

    private fun insertWord(root: TrieNode, word: String) {
        var currentNode: TrieNode? = root
        for (c in word.toCharArray()) {
            currentNode!!.childNodes.putIfAbsent(c, TrieNode())
            currentNode = currentNode.childNodes[c]
            currentNode!!.frequency++
        }
    }

    private fun isSubstring(root: TrieNode, word: String): Boolean {
        var currentNode: TrieNode? = root
        for (c in word.toCharArray()) currentNode = currentNode!!.childNodes[c]
        return currentNode!!.frequency > 1
    }
}


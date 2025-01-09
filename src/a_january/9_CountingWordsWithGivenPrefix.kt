package a_january

import kotlin.math.min

/**
 *  Problem 9. Counting Words With a Given Prefix.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N * M)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            arrayOf("pay", "attention", "practice", "attend"), "at"

        ),
        Pair(arrayOf("leetcode", "win", "loops", "success"), "code"),
        Pair(arrayOf("leetcode", "win", "loops", "success"), "code"),
        Pair(
            arrayOf(
                "pre",
                "prefix",
                "preview",
                "prepare",
                "presentation",
                "preventive",
                "premeditation",
                "apple",
                "banana",
                "grape"
            ), "pre"
        ),
        Pair(
            arrayOf(
                "pre",
                "prefix",
                "preview",
                "prepare",
                "presentation",
                "preventive",
                "premeditation",
                "apple",
                "banana",
                "grape"
            ), "apple"
        ),
        Pair(
            arrayOf("wb", "tdkecwp", "jtuqfks", "w", "c", "f"), "jcsdgs"
        )
    )

    testCases.forEach { test ->

        println("Result ==> ${prefixCount(test.first, test.second)}")
    }

}

// a  | b  | c  | d  | e  | f  | g  | h  | i  | j  | k  | l  | m  | n  | o  | p  | q  | r  | s  | t  | u  | v  | w  | x  | y  | z
// 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  | 10 | 11 | 12 | 13 | 14 | 15 | 16 | 17 | 18 | 19 | 20 | 21 | 22 | 23 | 24 | 25
fun prefixCount(words: Array<String>, pref: String): Int {
    val trie = TrieC()
    for (word in words) {
        if (word.length < pref.length) continue
        trie.insertWord(word, pref.length)
    }
    return trie.findPrefix(pref)
}

private class TrieC {
    val root = TrieNodeC()
    fun insertWord(word: String, size: Int) {
        var currNode: TrieNodeC = root
        for (i in 0..<size) {
            val index = word[i] - 'a'
            if (currNode.chars[index] == null) currNode.chars[index] = TrieNodeC()
            currNode.chars[index]!!.freq++
            currNode = currNode.chars[index]!!
        }
    }

    fun findPrefix(pref: String): Int {
        var curr = root
        for (ch in pref) {
            val index = ch - 'a'
            if (curr.chars[index] == null) return 0
            curr = curr.chars[index]!!
        }
        return curr.freq
    }
}

private data class TrieNodeC(
    var freq: Int = 0, // Frequency of nodes i.e. how many string characters pass from here
    val chars: Array<TrieNodeC?> = Array(26) { null }
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TrieNodeC

        if (freq != other.freq) return false
        if (!chars.contentEquals(other.chars)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = freq
        result = 31 * result + chars.contentHashCode()
        return result
    }
}


// TC - O(N * M) :: SC - O(n)
fun prefixCount2(words: Array<String>, pref: String): Int {
    var prefCount = 0
    for (word in words) if (word.startsWith(pref)) prefCount++
    return prefCount
}

// TC - O(N * M) :: SC - O(n)
fun prefixCount1(words: Array<String>, pref: String): Int {
    var prefCount = 0
    for (word in words) {
        var i = 0
        while (i < min(word.length, pref.length) && pref[i] == word[i]) i++
        if (i == pref.length) prefCount++
    }
    return prefCount
}
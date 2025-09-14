package i_september

import java.util.*

/**
 *  Problem 14. Vowel Spellchecker.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(C)
 *       - Space complexity: O(C)
 *          where C is the total content of wordlist and queries.
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            arrayOf("KiTe", "kite", "hare", "Hare"),
            arrayOf("kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto")
        ), Pair(
            arrayOf("yellow"), arrayOf("YellOw")
        )
    )

    testCases.forEach { (wordList, queries) ->
        println("Result ==> ${spellchecker(wordList, queries).toList()}")
    }

}

var wordsPerfect: MutableSet<String> = hashSetOf()
var wordsCap: HashMap<String, String> = hashMapOf()
var wordsVow: HashMap<String, String> = hashMapOf()

fun spellchecker(wordlist: Array<String>, queries: Array<String>): Array<String?> {
    for (word in wordlist) {
        wordsPerfect.add(word)

        val wordlow = word.lowercase()
        wordsCap.putIfAbsent(wordlow, word)

        val wordlowDV = devowel(wordlow)
        wordsVow.putIfAbsent(wordlowDV, word)
    }

    val ans = arrayOfNulls<String>(queries.size)
    var t = 0
    for (query in queries) ans[t++] = solve(query)
    return ans
}

fun solve(query: String): String? {
    if (wordsPerfect.contains(query)) return query

    val queryL = query.lowercase()
    if (wordsCap.containsKey(queryL)) return wordsCap[queryL]

    val queryLV = devowel(queryL)
    if (wordsVow.containsKey(queryLV)) return wordsVow.get(queryLV)

    return ""
}

fun devowel(word: String): String {
    val ans = StringBuilder()
    for (c in word.toCharArray()) ans.append(if (isVowel(c)) '*' else c)
    return ans.toString()
}

fun isVowel(c: Char): Boolean {
    return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
}




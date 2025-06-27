package f_june

import java.util.*

/**
 *  Problem 27. Longest Subsequence Repeated k Times.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n * |n / k|!)
 *
 *       - Space complexity: O(|n/k|!)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            "letsleetcode", 2
        )
    )

    testCases.forEach { (s, k) ->
        println("Result ==> ${longestSubsequenceRepeatedK(s, k)}")
    }
}

fun longestSubsequenceRepeatedK(s: String, k: Int): String {
    val freq = IntArray(26)
    for (ch in s.toCharArray()) {
        freq[ch.code - 'a'.code]++
    }
    val candidate: MutableList<Char?> = ArrayList<Char?>()
    for (i in 25 downTo 0) {
        if (freq[i] >= k) {
            candidate.add(('a'.code + i).toChar())
        }
    }

    val q: Queue<String> = LinkedList()
    for (ch in candidate) {
        q.add(ch.toString())
    }
    var ans = ""
    while (!q.isEmpty()) {
        val curr = q.poll()
        if (curr.length > ans.length) {
            ans = curr
        }
        // generate the next candidate string
        for (ch in candidate) {
            val next = curr + ch
            if (isKRepeatedSubsequence(s, next, k)) {
                q.add(next)
            }
        }
    }

    return ans
}

private fun isKRepeatedSubsequence(s: String, t: String, k: Int): Boolean {
    var pos = 0
    var matched = 0
    val m = t.length
    for (ch in s.toCharArray()) {
        if (ch == t[pos]) {
            pos++
            if (pos == m) {
                pos = 0
                matched++
                if (matched == k) {
                    return true
                }
            }
        }
    }
    return false
}

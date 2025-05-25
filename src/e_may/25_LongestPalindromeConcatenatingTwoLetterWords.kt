package e_may


/**
 *  Problem 25. Longest Palindrome by Concatenating Two Letter Words.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        arrayOf("lc", "cl", "gg"),
        arrayOf("ab", "ty", "yt", "lc", "cl", "ab"),
        arrayOf("cc", "ll", "xx")
    )

    testCases.forEach { words ->
        println("Result ==> ${longestPalindrome(words)}")
    }

}

fun longestPalindrome(words: Array<String>): Int {
    val freq: MutableMap<String, Int> = HashMap()
    var length = 0
    var hasMiddle = false

    for (word in words) {
        val reversed = StringBuilder(word).reverse().toString()

        if (freq.getOrDefault(reversed, 0) > 0) {
            freq[reversed] = freq[reversed]!! - 1
            length += 4
        } else {
            freq[word] = freq.getOrDefault(word, 0) + 1
        }
    }

    for (word in freq.keys) {
        if (word[0] == word[1] && freq[word]!! > 0) {
            hasMiddle = true
            break
        }
    }

    if (hasMiddle) {
        length += 2
    }

    return length
}





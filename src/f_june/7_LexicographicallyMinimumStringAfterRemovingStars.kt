package f_june

/**
 *  Problem 7. Lexicographically Minimum String After Removing Stars.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O()
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf("aaba*", "abc")

    testCases.forEach { s ->
        println("Result ==> ${clearStars(s)}")
    }

}

fun clearStars(s: String): String {
    val cnt = Array(26) { ArrayDeque<Int>() }
    val arr = s.toCharArray()

    for (i in arr.indices) {
        if (arr[i] != '*') {
            cnt[arr[i] - 'a'].addFirst(i)
        } else {
            for (j in 0 until 26) {
                if (cnt[j].isNotEmpty()) {
                    arr[cnt[j].removeFirst()] = '*'
                    break
                }
            }
        }
    }

    val ans = StringBuilder()
    for (c in arr) {
        if (c != '*') {
            ans.append(c)
        }
    }
    return ans.toString()
}

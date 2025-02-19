package b_february

/**
 *  Problem 19. The k-th Lexicographical String of All Happy Strings of Length n.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n * 2^n)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(1, 3),
        Pair(1, 4),
        Pair(3, 9)
    )

    testCases.forEach { test ->
        println("Result ==> ${getHappyString(test.first, test.second)}")
    }

}


fun getHappyString(n: Int, k: Int): String {
    val currentString = StringBuilder()
    val result = arrayOfNulls<String>(1)
    val indexInSortedList = IntArray(1)

    generateHappyStrings(n, k, currentString, indexInSortedList, result)
    return if (result[0] == null) "" else result[0]!!
}

private fun generateHappyStrings(
    n: Int,
    k: Int,
    currentString: StringBuilder,
    indexInSortedList: IntArray,
    result: Array<String?>
) {
    if (currentString.length == n) {
        indexInSortedList[0]++
        if (indexInSortedList[0] == k) result[0] = currentString.toString()
        return
    }

    var currentChar = 'a'
    while (currentChar <= 'c') {
        if (currentString.isNotEmpty() && currentString[currentString.length - 1] == currentChar) {
            currentChar++
            continue
        }

        currentString.append(currentChar)
        generateHappyStrings(
            n,
            k,
            currentString,
            indexInSortedList,
            result
        )
        if (result[0] != null) return
        currentString.deleteCharAt(currentString.length - 1)
        currentChar++
    }
}

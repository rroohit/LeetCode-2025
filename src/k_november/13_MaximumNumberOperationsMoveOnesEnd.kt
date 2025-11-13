package k_november

/**
 * Problem 13. Maximum Number of Operations to Move Ones to the End.
 *
 * ## Intuition -
 *      We count how many '1's have appeared so far while traversing the string.
 *      Each time we encounter a '1' after a '0', or if the string ends with '0',
 *          it contributes operations equal to the number of '1's seen before.
 *
 * ## Approach -
 *      - Initialize a counter `ones` for the number of '1's encountered.
 *      - Traverse the string from left to right.
 *      - When a '1' follows a '0', add the current `ones` count to the result.
 *      - Increment `ones` for each '1'.
 *      - If the last character is '0', also add the total `ones` to the result.
 *
 * ## Complexity:
 *      - Time complexity: O(n)
 *      - Space complexity: O(1)
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        "1001101",
        "00111",
        "1000000001",
        "000000001"
    )

    testCases.forEach { s ->
        println("Result ==> ${maxOperations(s)}")
    }

}

// TC - O(n) :: SC - O(1)
fun maxOperations(s: String): Int {
    val n = s.length
    var op = 0
    var ones = if (s[0] == '1') 1 else 0
    for (i in 1..<n) {
        if (s[i] == '1') {
            if (s[i - 1] == '0') op += ones
            ones++
        } else {
            if (i == n - 1 && s[i] == '0') op += ones
        }
    }
    return op
}

// TC - O(n) :: SC - O(1)
fun maxOperations2(s: String): Int {
    val n = s.length
    var op = 0
    var ones = 0
    var i = 0
    while (i < n) {
        if (s[i] == '0') {
            while (i + 1 < n && s[i + 1] == '0') i++
            op += ones
        } else {
            ones++
        }
        i++
    }
    return op
}

// TLE :: TC - O(n^2) : SC - O(n)
fun maxOperations1(s: String): Int {
    val n = s.length - 1
    val arr = s.toCharArray()
    var op = 0
    while (true) {
        var i = 0
        while (true) {
            if (i == n || arr[i] == '1' && arr[i + 1] == '0') break
            i++
        }
        if (i == n) break
        val j = i
        while (i < n && arr[i + 1] == '0') i++
        arr[j] = '0'
        arr[i] = '1'
        op++
    }
    return op
}
package a_january

/**
 *  Problem 5. Shifting Letters II.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n + m)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            "abc", // ace
            arrayOf(
                intArrayOf(0, 1, 0),
                intArrayOf(1, 2, 1),
                intArrayOf(0, 2, 1)
            )
        ),
        Pair(
            "dztz", // "catz"
            arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(1, 1, 1)
            )
        ),
        Pair(
            "xuwdbdqik",
            arrayOf(
                intArrayOf(4, 8, 0),
                intArrayOf(4, 4, 0),
                intArrayOf(2, 4, 0),
                intArrayOf(2, 4, 0),
                intArrayOf(6, 7, 1),
                intArrayOf(2, 2, 1),
                intArrayOf(0, 2, 1),
                intArrayOf(8, 8, 0),
                intArrayOf(1, 3, 1)
            ) // "ywxcxcqii"
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${shiftingLetters(test.first, test.second)}")
    }

}

fun shiftingLetters(s: String, shifts: Array<IntArray>): String {
    val n = s.length
    val diffArray = IntArray(n)

    for (shift in shifts) {
        if (shift[2] == 1) { // If direction is forward (1)
            diffArray[shift[0]]++ // Increment at the start index
            if (shift[1] + 1 < n) {
                diffArray[shift[1] + 1]-- // Decrement at the end+1 index
            }
        } else { // If direction is backward (0)
            diffArray[shift[0]]-- // Decrement at the start index
            if (shift[1] + 1 < n) {
                diffArray[shift[1] + 1]++ // Increment at the end+1 index
            }
        }
    }

    val result = StringBuilder(s)
    var numberOfShifts = 0

    for (i in 0..<n) {
        numberOfShifts = (numberOfShifts + diffArray[i]) % 26
        if (numberOfShifts < 0) numberOfShifts += 26 // handle non-negative shifts

        val shiftedChar = ('a'.code + ((s[i].code - 'a'.code + numberOfShifts) % 26)).toChar()
        result.setCharAt(i, shiftedChar)
    }

    return result.toString()
}

// Time Limit exceeds
@Suppress("unused")
fun shiftingLetters1(s: String, shifts: Array<IntArray>): String {
    val alphabets = ('a'..'z').toList()
    val reqShifts = IntArray(s.length) { 0 }

    for (shift in shifts) {
        val num = if (shift[2] == 1) 1 else -1
        for (i in shift[0]..shift[1]) {
            reqShifts[i] = (reqShifts[i] + num) % 26
        }
    }

    val result = StringBuilder()
    for (i in s.indices) {
        val newCharInd = ((s[i] - 'a') + reqShifts[i])
        result.append(alphabets[getValidIndex(newCharInd)])
    }

    return result.toString()
}

private fun getValidIndex(index: Int): Int {
    return if (index < 0) (26 + index) % 26 else index % 26
}







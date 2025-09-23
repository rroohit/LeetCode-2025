package i_september

import kotlin.math.max

/**
 *  Problem 23. Compare Version Numbers.
 *
 *  ## Intuition -
 *  Compare each numeric chunk of the two version strings one by one.
 *  Treat missing chunks as 0. The first difference determines the result.
 *
 *  ## Approach -
 *  Use two pointers to traverse both strings.
 *  For each segment (separated by '.'), parse it into an integer and compare.
 *  If equal, move to the next segment until both strings are processed.
 *
 *  ## Complexity:
 *       - Time complexity: O(max(n1, n2))  // each character processed once
 *       - Space complexity: O(1)           // only integer variables used
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair("1.2", "1.10"),
        Pair("1.22", "1.022"),
    )

    testCases.forEach { (version1, version2) ->
        println("Result ==> ${compareVersion(version1, version2)}")
    }

}

fun compareVersion(version1: String, version2: String): Int {
    val n1 = version1.length
    val n2 = version2.length
    var i = 0
    var j = 0

    while (i < n1 || j < n2) {
        var start = i
        while (i < n1 && version1[i] != '.') i++
        val a = if (start < n1) version1.substring(start, i).toInt() else 0

        start = j
        while (j < n2 && version2[j] != '.') j++
        val b = if (start < n2) version2.substring(start, j).toInt() else 0

        if (a != b) return if (a > b) 1 else -1

        i++
        j++
    }

    return 0
}

fun compareVersion2(version1: String, version2: String): Int {
    val n1 = version1.length
    val n2 = version2.length
    var i = 0
    var j = 0

    while (i < n1 || j < n2) {
        var a = 0
        while (i < n1 && version1[i] != '.') {
            a = a * 10 + version1[i++].digitToInt()
        }

        var b = 0
        while (j < n2 && version2[j] != '.') {
            b = b * 10 + version2[j++].digitToInt()
        }

        if (a > b) return 1
        if (a < b) return -1

        i++
        j++
    }

    return 0
}

fun compareVersion1(version1: String, version2: String): Int {
    val list1 = version1.split(".").map { it.toInt() }
    val list2 = version2.split(".").map { it.toInt() }

    val last = max(list1.size, list2.size)

    for (i in 0..<last) {
        val inV1 = if (i >= list1.size) 0 else list1[i]
        val inV2 = if (i >= list2.size) 0 else list2[i]
        if (inV1 == inV2) continue

        return if (inV1 > inV2) 1 else -1
    }

    return 0
}

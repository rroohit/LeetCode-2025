package e_may

/**
 *  Problem 4. Number of Equivalent Domino Pairs.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        arrayOf(intArrayOf(1, 2), intArrayOf(2, 1), intArrayOf(3, 4), intArrayOf(5, 6)),
        arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 2),
            intArrayOf(1, 1),
            intArrayOf(1, 2),
            intArrayOf(1, 2),
            intArrayOf(1, 1)
        )
    )

    testCases.forEach { dominoes ->
        println("Result ==> ${numEquivDominoPairs(dominoes)}")
    }

}

fun numEquivDominoPairs(dominoes: Array<IntArray>): Int {
    val seen = IntArray(100)
    var count = 0
    for ((a, b) in dominoes) {
        val key = if (a <= b) a * 10 + b else b * 10 + a
        count += seen[key]
        seen[key]++
    }
    return count
}

fun numEquivDominoPairs2(dominoes: Array<IntArray>): Int {
    val seen = HashMap<String, Int>()
    var count = 0
    for ((a, b) in dominoes) {
        val key = if (a <= b) "$a$b" else "$b$a"
        count += seen.getOrDefault(key, 0)
        seen[key] = seen.getOrDefault(key, 0) + 1
    }

    return count
}

fun numEquivDominoPairs1(dominoes: Array<IntArray>): Int {
    val seen = HashMap<String, Int>()
    var count = 0

    for ((a, b) in dominoes) {
        val keyOne = "$a$b"
        val keyTwo = "$b$a"
        if (seen[keyOne] != null || seen[keyTwo] != null) {
            count += seen[keyOne]!!
        }
        seen[keyOne] = seen.getOrDefault(keyOne, 0) + 1
        if (keyOne != keyTwo) seen[keyTwo] = seen.getOrDefault(keyTwo, 0) + 1
    }

    return count
}
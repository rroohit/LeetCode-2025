package d_april

/**
 *  Problem 20. Rabbits in Forest.
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
        intArrayOf(1, 1, 2),
        intArrayOf(10, 10, 10)
    )

    testCases.forEach { answers ->
        println("Result ==> ${numRabbits(answers)}")
    }

}

fun numRabbits(answers: IntArray): Int {
    var total = 0
    val rabCnt = HashMap<Int, Int>()
    for (num in answers) {
        if (num == 0) {
            total++
        } else {
            rabCnt[num] = rabCnt.getOrDefault(num, 0) + 1
        }
    }

    for ((key, cnt) in rabCnt) {
        total += ((cnt + key) / (key + 1)) * (key + 1)
    }

    return total
}
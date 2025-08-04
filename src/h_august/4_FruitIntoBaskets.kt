package h_august

/**
 *  Problem 4. Fruit Into Baskets.
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
        intArrayOf(1, 2, 1),
        intArrayOf(0, 1, 2, 2),
        intArrayOf(1, 2, 3, 2, 2),
        intArrayOf(0, 2, 3, 4, 1)
    )

    testCases.forEach { fruits ->
        println("Result ==> ${totalFruit(fruits)}")
    }

}

fun totalFruit(fruits: IntArray): Int {
    var start = 0
    var maxFruits = 0
    val countMap = mutableMapOf<Int, Int>()

    for (end in fruits.indices) {
        countMap[fruits[end]] = countMap.getOrDefault(fruits[end], 0) + 1

        while (countMap.size > 2) {
            val leftFruit = fruits[start]
            countMap[leftFruit] = countMap[leftFruit]!! - 1
            if (countMap[leftFruit] == 0) {
                countMap.remove(leftFruit)
            }
            start++
        }

        maxFruits = maxOf(maxFruits, end - start + 1)
    }

    return maxFruits
}
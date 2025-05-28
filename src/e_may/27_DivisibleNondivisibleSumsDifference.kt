package e_may

/**
 *  Problem 27. Divisible and Non-divisible Sums Difference.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *          - where n is the number of nodes, e is the number of edges.
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(10, 3)
    )

    testCases.forEach { (n, m) ->
        println("Resul ==> ${differenceOfSums(n, m)}")
    }

}

fun differenceOfSums(n: Int, m: Int): Int {
    var sum = 0
    for (num in 1..n) {
        if (num % m == 0) {
            sum -= num
        } else {
            sum += num
        }
    }
    return sum
}

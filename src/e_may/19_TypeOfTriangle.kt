package e_may

/**
 *  Problem 19. Type of Triangle.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(1)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(3, 3, 3),
        intArrayOf(3, 4, 5)
    )

    testCases.forEach { nums ->
        println("Result ==> ${triangleType(nums)}")
    }

}

fun triangleType(nums: IntArray): String {
    val (a, b, c) = nums
    if (a + b <= c || a + c <= b || b + c <= a) return "none"
    if (a == b && b == c) return "equilateral"
    if (a == b || a == c || b == c) return "isosceles"
    return "scalene"
}
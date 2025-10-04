package j_october

/**
 *  Problem 4. Container With Most Water.
 *
 *  ## Intuition -
 *      We want to maximize the area formed between two vertical lines on the x-axis.
 *      The area depends on the shorter of the two lines and the distance between them.
 *      To maximize, we need to check pairs of lines while moving pointers inward.
 *
 *  ## Approach -
 *      Use two pointers: one at the leftmost index and the other at the rightmost index.
 *      Calculate the area at each step using the shorter line as height.
 *      Move the pointer pointing to the shorter line inward, since moving the taller one
 *          cannot increase area. Keep track of the maximum area found.
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7),
        intArrayOf(1, 1, 2, 2)
    )

    testCases.forEach { height ->
        println("Result ==> ${maxArea(height)}")
    }

}

private fun maxArea(height: IntArray): Int {
    val n = height.size
    var area = 0
    var l = 0
    var r = n - 1
    while (l < r) {
        val ht = if (height[l] < height[r]) height[l] else height[r]
        if ((r - l) * ht > area) area = (r - l) * ht
        if (height[l] < height[r]) l++ else r--
    }
    return area
}

package k_november

/**
 *  Problem 10. Minimum Operations to Convert All Elements to Zero.
 *
 *  ## Intuition -
 *  Each operation reduces a segment of numbers by their minimum value. To avoid redundant operations,
 *  we only count when a new increasing height (non-zero) appears after smaller ones are removed.
 *
 *  ## Approach -
 *  - Use a stack `s` to maintain the increasing sequence of numbers.
 *  - For each `num`:
 *      - Remove all larger elements from the stack (since they will be reduced before `num`).
 *      - Skip zeros as they need no operation.
 *      - If the stack is empty or the top element is smaller than `num`, increment the operation count and push `num`.
 *  - Return the total operations.
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *       - Space complexity: O(n)
 *
 *  ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(0, 2),
        intArrayOf(3, 1, 2, 1),
        intArrayOf(1, 2, 1, 2, 1, 2)
    )

    testCases.forEach { nums ->
        println("Result ==> ${minOperations(nums)}")
    }

}

fun minOperations(nums: IntArray): Int {
    val s = ArrayList<Int>()
    var op = 0
    for (num in nums) {
        while (s.isNotEmpty() && s.last() > num) {
            s.removeLast()
        }
        if (num == 0) continue
        if (s.isEmpty() || s.last() < num) {
            op++
            s.add(num)
        }
    }
    return op
}
package d_april

/**
 *  Problem 15. Count Good Triplets in an Array.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n logn)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(2, 0, 1, 3),
            intArrayOf(0, 1, 2, 3)
        ),
        Pair(
            intArrayOf(4, 0, 1, 3, 2),
            intArrayOf(4, 1, 0, 2, 3)
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${goodTriplets(test.first, test.second)}")
    }

}

fun goodTriplets(nums1: IntArray, nums2: IntArray): Long {
    val n = nums1.size
    val pos2 = IntArray(n)
    val reversedIndexMapping = IntArray(n)
    for (i in 0..<n) {
        pos2[nums2[i]] = i
    }
    for (i in 0..<n) {
        reversedIndexMapping[pos2[nums1[i]]] = i
    }
    val tree = FenwickTree(n)
    var res: Long = 0
    for (value in 0..<n) {
        val pos = reversedIndexMapping[value]
        val left = tree.query(pos)
        tree.update(pos, 1)
        val right = (n - 1 - pos) - (value - left)
        res += left.toLong() * right
    }
    return res
}

class FenwickTree(size: Int) {
    private val tree = IntArray(size + 1)

    fun update(i: Int, delta: Int) {
        var index = i
        index++
        while (index < tree.size) {
            tree[index] += delta
            index += index and -index
        }
    }

    fun query(i: Int): Int {
        var index = i
        index++
        var res = 0
        while (index > 0) {
            res += tree[index]
            index -= index and -index
        }
        return res
    }
}

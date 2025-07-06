package g_july


/**
 *  Problem 6. Finding Pairs With a Certain Sum.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n + m + q1 + q2 * n)
 *
 *       - Space complexity: O(n + m)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Data6(
            intArrayOf(1, 1, 2, 2, 2, 3),
            intArrayOf(1, 4, 5, 2, 5, 4),
            listOf(
                Triple("count", 7, -1),
                Triple("add", 3, 2),
                Triple("count", 8, -1),
                Triple("count", 4, -1),
                Triple("add", 0, 1),
                Triple("add", 1, 1),
                Triple("count", 7, -1),

                )
        )
    )

    testCases.forEach { test ->
        val findSumPairs = FindSumPairs(test.nums1, test.nums2)
        test.calls.forEach { call ->
            if (call.first == "count") {
                print("${findSumPairs.count(call.second)}")
            } else {
                // add
                findSumPairs.add(call.second, call.third)
            }
        }
    }

}

internal class FindSumPairs(private val nums1: IntArray, private val nums2: IntArray) {
    private val cnt = HashMap<Int, Int>()

    init {
        for (num in nums2) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1)
        }
    }

    fun add(index: Int, `val`: Int) {
        val oldVal = nums2[index]
        cnt.put(oldVal, cnt.get(oldVal)!! - 1)
        nums2[index] += `val`
        cnt.put(nums2[index], cnt.getOrDefault(nums2[index], 0) + 1)
    }

    fun count(tot: Int): Int {
        var ans = 0
        for (num in nums1) {
            val rest = tot - num
            ans += cnt.getOrDefault(rest, 0)
        }
        return ans
    }
}

private data class Data6(
    val nums1: IntArray,
    val nums2: IntArray,
    val calls: List<Triple<String, Int, Int>>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Data6

        if (!nums1.contentEquals(other.nums1)) return false
        if (!nums2.contentEquals(other.nums2)) return false
        if (calls != other.calls) return false

        return true
    }

    override fun hashCode(): Int {
        var result = nums1.contentHashCode()
        result = 31 * result + nums2.contentHashCode()
        result = 31 * result + calls.hashCode()
        return result
    }
}
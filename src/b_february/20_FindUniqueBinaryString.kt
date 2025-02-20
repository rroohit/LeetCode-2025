package b_february

/**
 *  Problem 20. Find Unique Binary String.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n^2)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        arrayOf("01", "10"),
        arrayOf("00", "01"),
        arrayOf("111", "011", "001")
    )

    testCases.forEach { nums ->
        println("Result ==> ${findDifferentBinaryString(nums)}")
    }

}

private var nn = 0
private var binSet = HashSet<String>()
fun findDifferentBinaryString(nums: Array<String>): String {
    nn = nums.size
    for (str in nums) binSet.add(str)
    return generateStr("")
}

private fun generateStr(curr: String): String {
    if (curr.length == nn) {
        if (!binSet.contains(curr)) return curr
        return ""
    }
    val str = generateStr(curr + "0")
    if (str.isNotEmpty()) return str
    return generateStr(curr + "1")
}
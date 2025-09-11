package h_august

// Maximum 69 Number
fun main() {

    val testCases = listOf(
        9669, 9996, 9999
    )

    testCases.forEach { nums ->
        println("Result ==> ${maximum69Number(nums)}")
    }

}

fun maximum69Number(num: Int): Int {
    val nums = "$num".toCharArray()
    var ans = 0
    var changed = false
    for (ch in nums) {
        if (!changed && ch.digitToInt() == 6) {
            ans = ans * 10 + 9
            changed = true
        } else {
            ans = ans * 10 + ch.digitToInt()
        }
    }

    return ans
}

fun maximum69Number1(num: Int): Int {
    val nums = "$num".toCharArray()

    for (i in nums.indices) {
        if (nums[i] == '6') {
            nums[i] = '9'
            break
        }
    }

    return nums.joinToString("").toInt()
}
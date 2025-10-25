package j_october

/**
 *  Problem 25. Calculate Money in Leetcode Bank.
 *
 *  ## Intuition -
 *      Each week, the deposit amount starts from one more than the previous week's start
 *          and increases by 1 each day within the week.
 *
 *  ## Approach -
 *      - Use `repeat(n)` to simulate each day.
 *      - Increase the weekly base (`mon`) every 7 days.
 *      - Add `mon + day` to total for each day, where `day` is day index in the week.
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(4, 10, 20)

    testCases.forEach { n ->
        println("Result ==> ${totalMoney(n)}")
    }

}

fun totalMoney(n: Int): Int {
    var total = 0
    var mon = 0
    repeat(n) { i ->
        val day = i % 7
        if (day == 0) mon++
        total += mon + day
    }
    return total
}

fun totalMoney1(n: Int): Int {
    val days = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    var total = 0
    repeat(n) { i ->
        val day = i % 7
        total += days[day]
        days[day]++
    }
    return total
}
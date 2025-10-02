package j_october

/**
 *  Problem 1. Water Bottles.
 *
 *  ## Intuition -
 *      You start with a certain number of full bottles. Each time you drink, you get an empty bottle.
 *          After drinking, you can exchange a fixed number of empty bottles for new full bottles.
 *          The problem is essentially about repeatedly consuming and exchanging bottles until no more exchanges are possible.
 *
 *  ## Approach -
 *      - Keep track of the current full bottles and total consumed.
 *      - After drinking, calculate how many empty bottles you have (current + carried over).
 *      - Exchange as many as possible into new full bottles, carry forward the remainder.
 *      - Repeat until you cannot get new full bottles.
 *
 *  ## Complexity:
 *       - Time complexity: O(numBottles)
 *          - in the worst case, since each bottle is consumed once.
 *
 *       - Space complexity: O(1)
 *          - as we only use a few variables for tracking.
 *
 *  ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(9, 3)
    )

    testCases.forEach { (numBottles, numExchange) ->
        println("Result ==> ${numWaterBottles(numBottles, numExchange)}")
    }

}

fun numWaterBottles(numBottles: Int, numExchange: Int): Int {
    var ans = 0
    var currBt = numBottles
    var carryBt = 0
    while (currBt > 0) {
        ans += currBt
        val empty = currBt + carryBt
        currBt = empty / numExchange
        carryBt = empty % numExchange
    }
    return ans
}

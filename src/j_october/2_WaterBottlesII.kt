package j_october

/**
 * Problem: 2. Water Bottles II.
 *
 * ## Intuition
 *      Each empty bottle can be exchanged for a new one if enough empties are available.
 *      After each exchange, the required bottles to exchange increases by 1.
 *
 * ## Approach
 *      - Start with initial full bottles (drunk = numBottles)
 *      - Track empties and repeatedly exchange when possible
 *      - After each exchange, increase drunk count and update exchange cost
 *
 * ## Complexity
 *      - Time: O(numBottles) (each iteration represents drinking at most one extra bottle)
 *      - Space: O(1)
 */
fun main() {

    val testCases = listOf(
        Pair(13, 6),
        Pair(10, 3),
    )

    testCases.forEach { (numBottles, numExchange) ->
        println("Result ==> ${maxBottlesDrunk(numBottles, numExchange)}")
    }

}

fun maxBottlesDrunk(numBottles: Int, numExchange: Int): Int {
    var drunk = numBottles
    var empty = numBottles
    var exCh = numExchange
    while (empty >= exCh) {
        empty -= exCh
        drunk++
        empty++
        exCh++
    }
    return drunk
}
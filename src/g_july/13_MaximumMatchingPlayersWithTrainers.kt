package g_july

/**
 *  Problem 13. Maximum Matching of Players With Trainers.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(m logm + n logn)
 *
 *       - Space complexity: O(logm + logn)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(4, 7, 9),
            intArrayOf(8, 2, 5, 8)
        ),
        Pair(
            intArrayOf(1, 1, 1),
            intArrayOf(10)
        )
    )

    testCases.forEach { (players, trainers) ->
        println("Result ==> ${matchPlayersAndTrainers(players, trainers)}")
    }

}

fun matchPlayersAndTrainers(players: IntArray, trainers: IntArray): Int {
    players.sort()
    trainers.sort()
    var pairs = 0
    var p = 0
    var t = 0

    while (p < players.size && t < trainers.size) {
        if (players[p] <= trainers[t]) {
            pairs++
            p++
        }
        t++
    }

    return pairs
}


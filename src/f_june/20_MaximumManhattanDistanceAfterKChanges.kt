package f_june

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

/**
 *  Problem 20. Maximum Manhattan Distance After K Changes.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair("NWSE", 1)
    )

    testCases.forEach { (s, k) ->
        println("Result ==> ${maxDistance(s, k)}")
    }

}

fun maxDistance(s: String, k: Int): Int {
    var latitude = 0
    var longitude = 0
    var ans = 0
    val n = s.length
    for (i in 0..<n) {
        val c = s[i]
        when (c) {
            'N' -> latitude++
            'S' -> latitude--
            'E' -> longitude++
            'W' -> longitude--
        }
        ans = max(
            ans,
            min(
                abs(latitude) + abs(longitude) + k * 2,
                i + 1
            )
        )
    }
    return ans
}

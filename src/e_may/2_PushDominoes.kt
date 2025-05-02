package e_may

import kotlin.math.max

/**
 *  Problem 2. Push Dominoes.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        "RR.L",
        ".L.R...LR..L.."
    )

    testCases.forEach { dominoes ->
        println("Result ==> ${pushDominoes(dominoes)}")
    }

}

fun pushDominoes(S: String): String {
    val A = S.toCharArray()
    val N = A.size
    val forces = IntArray(N)

    // Populate forces going from left to right
    var force = 0
    for (i in 0..<N) {
        force = if (A[i] == 'R') N
        else if (A[i] == 'L') 0
        else max((force - 1).toDouble(), 0.0).toInt()
        forces[i] += force
    }

    // Populate forces going from right to left
    force = 0
    for (i in N - 1 downTo 0) {
        force = if (A[i] == 'L') N
        else if (A[i] == 'R') 0
        else max((force - 1).toDouble(), 0.0).toInt()
        forces[i] -= force
    }

    val ans = StringBuilder()
    for (f in forces) ans.append(if (f > 0) 'R' else if (f < 0) 'L' else '.')
    return ans.toString()
}

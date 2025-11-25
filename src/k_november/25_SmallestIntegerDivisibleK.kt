package k_november

/**
 *  Problem 25. Smallest Integer Divisible by K.
 *
 *  ## Intuition
 *  We need the smallest number made only of digit '1' (1, 11, 111...) that is divisible by K.
 *  Instead of building huge numbers, we track only the remainder.
 *  Appending a '1' updates remainder as: rem = (rem * 10 + 1) % K.
 *
 *  ## Approach
 *  - If K is divisible by 2 or 5, no such number exists → return -1.
 *  - Start with rem = 1 % K and length = 1 (number = "1").
 *  - Repeatedly append '1' by updating rem = (rem * 10 + 1) % K.
 *  - When rem becomes 0, the length is the answer.
 *
 *  ## Complexity
 *      - Time complexity: O(K)   // at most K unique remainders
 *      - Space complexity: O(1)
 *
 *  ## Code
 */
fun main() {

    val testCases = listOf(
        1, 2, 34, 45,
    )

    testCases.forEach { k ->
        println("Result ==> ${smallestRepunitDivByK(k)}")
    }
}


fun smallestRepunitDivByK(k: Int): Int {
    if (k % 2 == 0 || k % 5 == 0) return -1
    var rem = 1 % k
    var len = 1
    while (rem > 0) {
        rem = (rem * 10 + 1) % k
        len++
    }
    return len
}
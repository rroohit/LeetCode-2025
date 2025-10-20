package j_october

/**
 *  Problem 20. Final Value of Variable After Performing Operations.
 *
 *  ## Intuition
 *      Each operation either increments or decrements the variable `x` by 1.
 *      The goal is to compute the final value after all operations.
 *
 *  ## Approach
 *      Initialize `x` to 0.
 *      Iterate through each operation string:
 *          - If it contains a '+', increment `x`.
 *          - Otherwise, decrement `x`.
 *      Return the final value of `x`.
 *
 *  ## Complexity
 *      - Time complexity: O(n) — iterate once over all operations.
 *      - Space complexity: O(1) — only a single variable is used.
 *
 *  ## Code
 */
fun main() {

    val testCases = listOf(
        arrayOf("--X", "X++", "X++"),
        arrayOf("++X", "++X", "X++")
    )

    testCases.forEach { operations ->
        println("Result ==> ${finalValueAfterOperations(operations)}")
    }

}

fun finalValueAfterOperations(operations: Array<String>): Int {
    var x = 0
    for (op in operations) if (op[1] == '+') x++ else x--
    return x
}
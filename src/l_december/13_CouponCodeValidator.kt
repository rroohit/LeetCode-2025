package l_december

/**
 * Problem 13. Coupon Code Validator.
 *
 * ## Intuition
 *      Filter only active coupons with valid codes and allowed business lines,
 *          then sort them by business line priority and coupon code.
 *
 * ## Approach
 *      Iterate through all coupons and keep the valid ones.
 *      Validate codes using allowed characters.
 *      Sort the filtered coupons by predefined business-line order,
 *          and lexicographically by code.
 *
 * ## Complexity
 *      - Time: O(n · m + k · log k · m), where
 *          n = total coupons, m = average code length, k = valid coupons
 *      - Space: O(k) for storing valid coupons
 */
fun main() {

    val testCases = listOf(
        Triple(
            arrayOf("SAVE20", "", "PHARMA5", "SAVE@20"),
            arrayOf("restaurant", "grocery", "pharmacy", "restaurant"),
            booleanArrayOf(true, true, true, true)
        ),
        Triple(
            arrayOf("GROCERY15", "ELECTRONICS_50", "DISCOUNT10"),
            arrayOf("grocery", "electronics", "invalid"),
            booleanArrayOf(false, true, true)
        )
    )

    testCases.forEach { (code, businessLine, isActive) ->
        println("Result ==> ${validateCoupons(code, businessLine, isActive)}")
    }

}

fun validateCoupons(code: Array<String>, businessLine: Array<String>, isActive: BooleanArray): List<String> {
    val order = mapOf(
        "electronics" to 0,
        "grocery" to 1,
        "pharmacy" to 2,
        "restaurant" to 3
    )
    val validCoupons = mutableListOf<Pair<String, String>>()
    for (i in 0..<code.size) {
        val c = code[i]
        val b = businessLine[i]
        val a = isActive[i]
        if (a && c.isNotEmpty() && isCodeValid(c) && order.containsKey(b)) {
            validCoupons.add(b to c)
        }
    }
    validCoupons.sortWith(compareBy<Pair<String, String>> { order[it.first]!! }
        .thenBy { it.second })
    return validCoupons.map { it.second }
}

private fun isCodeValid(str: String): Boolean {
    for (ch in str) {
        if (!charSet.contains(ch)) return false
    }
    return true
}

private val charSet = hashSetOf(
    '_',
    'a',
    'b',
    'c',
    'd',
    'e',
    'f',
    'g',
    'h',
    'i',
    'j',
    'k',
    'l',
    'm',
    'n',
    'o',
    'p',
    'q',
    'r',
    's',
    't',
    'u',
    'v',
    'w',
    'x',
    'y',
    'z',
    'A',
    'B',
    'C',
    'D',
    'E',
    'F',
    'G',
    'H',
    'I',
    'J',
    'K',
    'L',
    'M',
    'N',
    'O',
    'P',
    'Q',
    'R',
    'S',
    'T',
    'U',
    'V',
    'W',
    'X',
    'Y',
    'Z',
    '0',
    '1',
    '2',
    '3',
    '4',
    '5',
    '6',
    '7',
    '8',
    '9',
)

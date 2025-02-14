package b_february

/**
 *  Problem 14. Product of the Last K Numbers.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(1)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        listOf(
            Pair("add", 3),
            Pair("add", 0),
            Pair("add", 2),
            Pair("add", 5),
            Pair("add", 4),
            Pair("getProduct", 2),
            Pair("getProduct", 3),
            Pair("getProduct", 4),
            Pair("add", 8),
            Pair("getProduct", 2)

        )
    )

    testCases.forEach { test ->
        val productOfNumbers = ProductOfNumbers()
        for ((func, num) in test) {
            when (func) {
                "add" -> {
                    productOfNumbers.add(num)
                    println("null")
                }

                "getProduct" -> {
                    println(productOfNumbers.getProduct(num))
                }
            }
        }
    }

}

class ProductOfNumbers() {
    private var stream = ArrayList<Int>()
    private var size = 0

    init {
        stream.add(1)
    }

    fun add(num: Int) {
        if (num == 0) {
            stream = ArrayList()
            stream.add(1)
            size = 0
        } else {
            stream.add(stream[size] * num)
            size += 1
        }
    }

    fun getProduct(k: Int): Int {
        return if (k > size) 0 else stream[size] / stream[size - k]
    }

}

class ProductOfNumbers1() {
    private val stream = mutableListOf<Int>()
    fun add(num: Int) {
        stream.add(num)
    }

    fun getProduct(k: Int): Int {
        var pro = 1
        for (i in stream.size - 1 downTo stream.size - k) {
            pro *= stream[i]
        }
        return pro
    }

}
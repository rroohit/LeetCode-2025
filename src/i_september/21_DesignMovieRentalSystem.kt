package i_september

import java.util.*

/**
 *  Problem 21. Design Movie Rental System.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O()
 *       - Space complexity: O()
 *
 * ## Code -
 */
fun main() {


}


class MovieRentingSystem(n: Int, entries: Array<IntArray>) {
    private val priceMap = mutableMapOf<Pair<Int, Int>, Int>()
    private val available = mutableMapOf<Int, TreeSet<Node>>()
    private val rented = TreeSet(
        compareBy<Node> { it.price }
            .thenBy { it.shop }
            .thenBy { it.movie }
    )

    init {
        for (e in entries) {
            val shop = e[0]
            val movie = e[1]
            val price = e[2]

            priceMap[shop to movie] = price

            available.computeIfAbsent(movie) {
                TreeSet(compareBy<Node> { it.price }.thenBy { it.shop })
            }

            available[movie]!!.add(Node(price, shop, movie))
        }
    }

    fun search(movie: Int): List<Int> {
        val result = mutableListOf<Int>()
        val set = available[movie] ?: return result
        var count = 0
        for (node in set) {
            if (count++ == 5) break
            result.add(node.shop)
        }
        return result
    }

    fun rent(shop: Int, movie: Int) {
        val price = priceMap[shop to movie]!!
        val node = Node(price, shop, movie)
        available[movie]!!.remove(node)
        rented.add(node)
    }

    fun drop(shop: Int, movie: Int) {
        val price = priceMap[shop to movie]!!
        val node = Node(price, shop, movie)
        rented.remove(node)
        available[movie]!!.add(node)
    }

    fun report(): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        var count = 0
        for (node in rented) {
            if (count++ == 5) break
            result.add(listOf(node.shop, node.movie))
        }
        return result
    }

    data class Node(
        val price: Int,
        val shop: Int,
        val movie: Int
    )
}







package i_september

import java.util.*

/**
 *  Problem 17. Design a Food Rating System.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n log n)
 *
 *       - Space complexity: O(n + q)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        FoodRatingData(
            arrayOf("kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"),
            arrayOf("korean", "japanese", "japanese", "greek", "japanese", "korean"),
            intArrayOf(9, 12, 8, 15, 14, 7),
            listOf(
                Pair(
                    "korean", -1,
                ),
                Pair(
                    "japanese", -1,
                ),
                Pair(
                    "sushi", 16,
                ),
                Pair(
                    "japanese", -1,
                ),
                Pair(
                    "ramen", 16
                ),
                Pair(
                    "japanese", -1,
                )
            )
        )
    )

    testCases.forEach { (foods, cuisines, ratings, funCalls) ->
        val foodRatings = FoodRatings(foods, cuisines, ratings)
        print("[")
        funCalls.forEach { (cuisineOrFood, rating) ->
            if (rating != -1) {
                // add rating
                foodRatings.changeRating(cuisineOrFood, rating)
                print("null, ")
            } else {
                // get highestRated Cuisines
                val result = foodRatings.highestRated(cuisineOrFood)
                print("$result, ")
            }
        }
        print("]")
        println()
    }

}

class FoodRatings(foods: Array<String>, cuisines: Array<String>, ratings: IntArray) {

    private val foodsHM = HashMap<String, FoodData>() // foodName -> FoodData
    private val cuisinesHM = HashMap<String, PriorityQueue<FoodData>>() // cuisineName -> max heap of foods

    private val foodComparator = compareByDescending<FoodData> { it.rating }
        .thenBy { it.foodName }

    init {
        for (i in foods.indices) {
            val foodName = foods[i]
            val cuisineName = cuisines[i]
            val rating = ratings[i]

            val foodData = FoodData(foodName, cuisineName, rating)
            foodsHM[foodName] = foodData

            cuisinesHM.computeIfAbsent(cuisineName) { PriorityQueue(foodComparator) }
                .add(foodData)
        }
    }

    fun changeRating(food: String, newRating: Int) {
        val oldData = foodsHM[food] ?: return
        val newData = FoodData(food, oldData.cuisineName, newRating)

        foodsHM[food] = newData
        cuisinesHM[oldData.cuisineName]?.add(newData)
    }

    fun highestRated(cuisine: String): String {
        val pq = cuisinesHM[cuisine] ?: return ""

        while (true) {
            val top = pq.peek() ?: return ""
            val current = foodsHM[top.foodName]!!
            if (top.rating == current.rating) {
                return top.foodName
            } else {
                pq.poll()
            }
        }
    }

    private data class FoodData(
        val foodName: String,
        val cuisineName: String,
        val rating: Int
    )
}


private data class FoodRatingData(
    val foods: Array<String>,
    val cuisines: Array<String>,
    val ratings: IntArray,
    val functionCall: List<Pair<String, Int>>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as FoodRatingData

        if (!foods.contentEquals(other.foods)) return false
        if (!cuisines.contentEquals(other.cuisines)) return false
        if (!ratings.contentEquals(other.ratings)) return false
        if (functionCall != other.functionCall) return false

        return true
    }

    override fun hashCode(): Int {
        var result = foods.contentHashCode()
        result = 31 * result + cuisines.contentHashCode()
        result = 31 * result + ratings.contentHashCode()
        result = 31 * result + functionCall.hashCode()
        return result
    }
}
package c_march

import java.util.*


/**
 *  Problem 21. Find All Possible Recipes from Given Supplies.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n + m + s)
 *
 *       - Space complexity: O(n + m + s)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        DataRecipe(
            recipes = arrayOf("bread"),
            ingredients = listOf(
                listOf("yeast", "flour")
            ),
            supplies = arrayOf("yeast", "flour", "corn")
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${findAllRecipes(test.recipes, test.ingredients, test.supplies)}")
    }

}

fun findAllRecipes(
    recipes: Array<String>,
    ingredients: List<List<String>>,
    supplies: Array<String>
): List<String> {
    val availableSupplies: MutableSet<String> = HashSet()
    val recipeToIndex: MutableMap<String, Int> = HashMap()
    val dependencyGraph: MutableMap<String, MutableList<String>> = HashMap()

    for (supply in supplies) {
        availableSupplies.add(supply)
    }

    for (idx in recipes.indices) {
        recipeToIndex[recipes[idx]] = idx
    }

    val inDegree = IntArray(recipes.size)

    for (recipeIdx in recipes.indices) {
        for (ingredient in ingredients[recipeIdx]) {
            if (!availableSupplies.contains(ingredient)) {
                dependencyGraph.putIfAbsent(
                    ingredient,
                    ArrayList()
                )
                dependencyGraph[ingredient]!!.add(recipes[recipeIdx])
                inDegree[recipeIdx]++
            }
        }
    }

    val queue: Queue<Int> = LinkedList()
    for (recipeIdx in recipes.indices) {
        if (inDegree[recipeIdx] == 0) {
            queue.add(recipeIdx)
        }
    }

    val createdRecipes: MutableList<String> = ArrayList()
    while (!queue.isEmpty()) {
        val recipeIdx = queue.poll()
        val recipe = recipes[recipeIdx]
        createdRecipes.add(recipe)

        if (!dependencyGraph.containsKey(recipe)) continue
        for (dependentRecipe in dependencyGraph[recipe]!!) {
            if (--inDegree[recipeToIndex[dependentRecipe]!!] == 0) {
                queue.add(recipeToIndex[dependentRecipe])
            }
        }
    }

    return createdRecipes
}


private data class DataRecipe(
    val recipes: Array<String>,
    val ingredients: List<List<String>>,
    val supplies: Array<String>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DataRecipe

        if (!recipes.contentEquals(other.recipes)) return false
        if (ingredients != other.ingredients) return false
        if (!supplies.contentEquals(other.supplies)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = recipes.contentHashCode()
        result = 31 * result + ingredients.hashCode()
        result = 31 * result + supplies.contentHashCode()
        return result
    }
}
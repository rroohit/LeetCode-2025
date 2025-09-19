package i_september

/**
 *  Problem 19. Design Spreadsheet.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(1)
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {



}

class Spreadsheet(rows: Int) {
    private val cellMap = hashMapOf<String, Int>()

    fun setCell(cell: String, value: Int) {
        cellMap[cell] = value
    }

    fun resetCell(cell: String) {
        cellMap[cell] = 0
    }

    fun getValue(formula: String): Int {
        val indOfOperator = formula.indexOf('+')
        val op1 = formula.substring(1, indOfOperator)
        val op2 = formula.substring(indOfOperator + 1)

        val a = if (op1[0].isDigit()) {
            op1.toInt()
        } else {
            cellMap[op1] ?: 0
        }

        val b = if (op2[0].isDigit()) {
            op2.toInt()
        } else {
            cellMap[op2] ?: 0
        }
        return a + b
    }
}
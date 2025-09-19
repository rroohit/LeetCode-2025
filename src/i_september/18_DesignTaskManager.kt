package i_september

import java.util.PriorityQueue

/**
 *  Problem 18. Design Task Manager.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(m log m)
 *       - Space complexity: O(m)
 *          - Inserts m tasks into taskMap (O(m))
 *          - Inserts m tasks into PQ (O(m log m) if bulk added, but we add one by one so O(m log m)).
 *
 * ## Code -
 */
fun main() {


}

class TaskManager(tasks: List<List<Int>>) {

    private val taskMap = hashMapOf<Int, TaskData>()
    private val pqTasks = PriorityQueue<TaskData>(
        compareByDescending<TaskData> { it.priority }
            .thenByDescending { it.taskId }
    )

    init {
        for (task in tasks) {
            val taskData = TaskData(task[0], task[1], task[2])
            taskMap[taskData.taskId] = taskData
            pqTasks.add(taskData)
        }
    }

    fun add(userId: Int, taskId: Int, priority: Int) {
        val taskData = TaskData(userId, taskId, priority)
        taskMap[taskId] = taskData
        pqTasks.add(taskData)
    }

    fun edit(taskId: Int, newPriority: Int) {
        val old = taskMap[taskId] ?: return
        val updated = TaskData(old.userId, taskId, newPriority)
        taskMap[taskId] = updated
        pqTasks.add(updated)
    }

    fun rmv(taskId: Int) {
        taskMap.remove(taskId)
    }

    fun execTop(): Int {
        while (pqTasks.isNotEmpty()) {
            val topTask = pqTasks.peek()
            val current = taskMap[topTask.taskId]
            if (current == null || current != topTask) {
                pqTasks.poll()
                continue
            }
            pqTasks.poll()
            taskMap.remove(topTask.taskId)
            return topTask.userId
        }
        return -1
    }

    private data class TaskData(
        val userId: Int,
        val taskId: Int,
        val priority: Int
    )
}


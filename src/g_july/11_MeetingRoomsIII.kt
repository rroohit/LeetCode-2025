package g_july

import java.util.*


// Meeting Rooms III


fun mostBooked(n: Int, meetings: Array<IntArray>): Int {
    val meetingCount = IntArray(n)
    val usedRooms = PriorityQueue(Comparator { a: LongArray, b: LongArray ->
        if (a[0] != b[0]) a[0].compareTo(b[0]) else a[1].compareTo(b[1])
    })
    val unusedRooms = PriorityQueue<Int?>()

    for (i in 0..<n) {
        unusedRooms.offer(i)
    }

    Arrays.sort(
        meetings,
        Comparator { a: IntArray, b: IntArray ->
            if (a[0] != b[0]) a[0].compareTo(b[0]) else a[1].compareTo(b[1])
        })

    for (meeting in meetings) {
        val start = meeting[0]
        val end = meeting[1]

        while (!usedRooms.isEmpty() && usedRooms.peek()!![0] <= start) {
            val room = usedRooms.poll()!![1].toInt()
            unusedRooms.offer(room)
        }

        if (!unusedRooms.isEmpty()) {
            val room: Int = unusedRooms.poll()!!
            usedRooms.offer(longArrayOf(end.toLong(), room.toLong()))
            meetingCount[room]++
        } else {
            val roomAvailabilityTime = usedRooms.peek()!![0]
            val room = usedRooms.poll()!![1].toInt()
            usedRooms.offer(longArrayOf(roomAvailabilityTime + end - start, room.toLong()))
            meetingCount[room]++
        }
    }

    var maxMeetingCount = 0
    var maxMeetingCountRoom = 0
    for (i in 0..<n) {
        if (meetingCount[i] > maxMeetingCount) {
            maxMeetingCount = meetingCount[i]
            maxMeetingCountRoom = i
        }
    }

    return maxMeetingCountRoom
}

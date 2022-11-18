package programmers.kit

import java.util.PriorityQueue


private class Job(val request: Int, var time: Int)

private fun solution2(jobs: Array<IntArray>): Int {
    var jobList = jobs.map { it[0] to it[1] }.sortedBy { it.first }
    val sortedTime: PriorityQueue<Pair<Int,Int>> = PriorityQueue(compareBy { it.second })
    var curTime = 0
    var sum = 0

    while (jobList.isNotEmpty() || sortedTime.isNotEmpty()){
        val avails = jobList.takeWhile { it.first <= curTime }
        sortedTime.addAll(avails)
        jobList = jobList.drop(avails.size)
        if (sortedTime.isEmpty()){
            curTime = jobList.first().first
        }else{
            val target = sortedTime.poll()
            curTime += target.second
            sum += curTime - target.first
        }
    }

    return sum / jobs.size

}

private fun solution(jobs: Array<IntArray>): Int {
    val requestPQ = PriorityQueue { o1: Job, o2: Job ->
        (o1.request - o2.request)
    }.also { pq -> jobs.forEach { jobDesc -> pq.add(Job(jobDesc[0], jobDesc[1])) } }

    val timePQ = PriorityQueue { o1: Job, o2: Job ->
        (o1.time - o2.time)
    }
    var ended = 0
    var curtime = 0
    val passedTimeList = mutableListOf<Int>()

    while (ended != jobs.size) {
        while (requestPQ.isNotEmpty() && requestPQ.peek().request <= curtime) { // 햔재 수행할 수 있는 것들을 다 넣는다.
            timePQ.add(requestPQ.poll())
        }
        if (timePQ.isEmpty()) {
            curtime += 1
        }else{
            val cur = timePQ.poll()
            println(cur.request)
            ended += 1
            curtime += cur.time
            passedTimeList.add(curtime - cur.request)
        }
    }

    return passedTimeList.also { println(it) }.sum().div(jobs.size)
}


fun main() {
    solution(
        arrayOf(
            intArrayOf(0, 100),
            intArrayOf(5, 10)
        )
    ).also { println(it) }

    solution2(
        arrayOf(
            intArrayOf(0, 100),
            intArrayOf(5, 10)
        )
    ).also { println(it) }
}

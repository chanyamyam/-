import java.lang.Long.min
class Solution {
    fun solution(n: Int, times: IntArray): Long {
    var answer = Long.MAX_VALUE
    var high = n * times[times.lastIndex].toLong()
    var low = 0L
    var sum = 0L
    var mid = 0L
    while (low<=high) {
        mid = (low + high) / 2
        sum = 0

        for (i in times.indices) {
            sum += mid / times[i]

            if(sum >= n) break
        }
        if (sum >= n) {
            high = mid-1
            answer = min(answer,mid)
        } else {
            low = mid+1
        }
    }
    return answer
}
}

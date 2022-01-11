import java.util.*
import kotlin.collections.HashMap
class Solution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
    var answer = mutableListOf<Int>()

    var hashmap: HashMap<String, LinkedList<Pair<Int, Int>>> = hashMapOf()
    var play: HashMap<String, Int> = hashMapOf()
    
    // HashMap에 각 장르와 장르별 playList 삽입 
    genres.forEachIndexed { index, it ->
        // 장르별 재생수의 총합
        play.put(it, play.getOrDefault(it, 0) + plays[index])
        // hashmap에 장르가 이미 있다면 장르의 리스트에 고유번호(index), 고유번호가 index인 노래의 재생횟수 저장 
        if (hashmap.contains(it)) {
            hashmap.get(it)!!.add(Pair(index, plays[index]))
        } else { // 없다면 장르의 리스트를 새로 할당
            var temp = LinkedList<Pair<Int, Int>>()
            temp.add(Pair(index, plays[index]))
            hashmap.put(it, temp)

        }
    }

    
    while (play.isNotEmpty()) {
       var key = ""
        var temp = -1
        // 가장 많이 재생된 장르 찾기
        play.forEach {
            if(it.value > temp) {
                key = it.key
                temp = it.value
            }
        }

        // 첫번째와 두번째로 많이 재생된 노래와 고유번호 찾기
        var index = 0
        var index2 = 0
        var max = -1
        var max2 = -1
        val x = hashmap.get(key)
        if (x!!.size > 1) {
            x!!.forEach { i ->
                if (i.second > max) {
                    index2 = index
                    index = i.first
                    max2 = max
                    max = i.second
                    
                }
                else if(i.second > max2) {
                    index2 = i.first
                    max2 = i.second
                }
            }
            answer.add(index)
            answer.add(index2)
        } else {
            answer.add(x[0].first)
        }
        play.remove(key)
    }

    return answer.toIntArray()
}
}

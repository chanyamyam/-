class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
    var answer = 1
    var hash: HashMap<String,Int> = hashMapOf()

    for(it in clothes) {
        hash.put(it[1],hash.getOrDefault(it[1],0) + 1)
    }
    for(it in hash) {
        answer *= (it.value + 1)
    }
    return answer-1 
}
}

class Solution {
   fun solution(N: Int, number: Int): Int {
    var answer = 0
    val resultList = mutableListOf<MutableSet<Int>>()
    var num = 0
    var list = mutableSetOf<Int>()

    for(i in 0..8) {
        num = num * 10 + N

        val set = mutableSetOf(num)

        var newList = mutableSetOf<Int>()

        if (list.contains(number)) return i+1

        for(j in 0 until i) {
            resultList[j].forEach { n ->
                resultList[i-j-1].forEach { n2 ->
                    cal(n,n2,set)
                }
            }
        }
        if(set.contains(number)) return i+1

        resultList.add(i,set)
    }
    return  -1
}
fun cal (num1: Int, num2: Int, set:MutableSet<Int>) {
    set.add(num1+num2)
    set.add(num1-num2)
    set.add(num1*num2)

    if(num2 != 0) {
        set.add(num1/num2)
    }
    if(num1 != 0) {
        set.add(num2/num1)
    }
}
}

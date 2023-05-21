# 7일차
## 수열과 구간 쿼리 4 [181922](https://school.programmers.co.kr/learn/courses/30/lessons/181922)
```
class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        var answer: IntArray = intArrayOf()
        for(qArr in queries) {
            for(i in qArr[0]..qArr[1])
                if(i%qArr[2] == 0) arr[i]++
        }
        return arr
    }
}
```

## 배열 만들기 2 [181921](https://school.programmers.co.kr/learn/courses/30/lessons/181921)
```
class Solution {
    fun solution(l: Int, r: Int): IntArray {
        var answer: IntArray = intArrayOf()
        for(i in l..r) {
            var bo = true
            for(s in i.toString()){
                if(s != '0' && s != '5'){
                    bo = false
                    break;
                }
            }
            if(bo)
                answer += i
        }
        if(answer.size == 0)
            answer += -1
        return answer
    }
}
```

## 카운트 업 [181920](https://school.programmers.co.kr/learn/courses/30/lessons/181920)
```
class Solution {
    fun solution(start: Int, end: Int): IntArray {
        var answer: IntArray = intArrayOf()
        for(i in start..end)
            answer += i
        return answer
    }
}
```

## 콜라츠 수열 만들기 [181919](https://school.programmers.co.kr/learn/courses/30/lessons/181919)
```
class Solution {
    fun solution(n: Int): IntArray {
        var answer: IntArray = intArrayOf()
        var num = n
        while(num!=1){
            answer += num
            if(num %2 == 0)
                num /= 2
            else
                num = num * 3 + 1
        }
        answer += 1
        return answer
    }
}
```

## 배열 만들기 4 [181918](https://school.programmers.co.kr/learn/courses/30/lessons/181918)
```
class Solution {
    fun solution(arr: IntArray): IntArray {
        var stk: IntArray = intArrayOf()
        var i : Int = 0
        while(i < arr.size) {
            if(stk.size == 0 || stk[stk.lastIndex] < arr[i])
                stk += arr[i++]
            else
                stk = stk.copyOfRange(0, stk.lastIndex)
        }
        return stk
    }
}
```

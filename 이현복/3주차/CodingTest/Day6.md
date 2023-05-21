# 6일차
## 마지막 두 원소 [181927](https://school.programmers.co.kr/learn/courses/30/lessons/181927)
```
class Solution {
    fun solution(num_list: IntArray): IntArray {
        var num = num_list.lastIndex
        if(num_list[num] > num_list[num-1])
            return num_list + (num_list[num] - num_list[num-1])
        else
            return num_list + (num_list[num]*2)
    }
}
```

## 수 조작하기 1 [181926](https://school.programmers.co.kr/learn/courses/30/lessons/181926)
```
class Solution {
    fun solution(n: Int, control: String): Int {
        var answer:Int = n
        for(spell in control){
            when(spell){
              'w' -> answer +=1
              's' -> answer -=1
              'd' -> answer +=10
              'a' -> answer -=10
            }
        }
        return answer
    }
}
```

## 수 조작하기 2 [181925](https://school.programmers.co.kr/learn/courses/30/lessons/181925)
```
class Solution {
    fun solution(numLog: IntArray): String {
        var answer: String = ""
        for(num in 0..numLog.lastIndex-1) {
            when(numLog[num+1] - numLog[num]) {
                1 -> answer += "w"
                -1 -> answer += "s"
                10 -> answer += "d"
                -10 -> answer += "a"
            }
        }
        return answer
    }
}
```

## 수열과 구간 쿼리 3 [181924](https://school.programmers.co.kr/learn/courses/30/lessons/181924)
```
class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        for(qArr in queries) 
            arr[qArr[0]] = arr[qArr[1]].also { arr[qArr[1]] = arr[qArr[0]] }
        return arr
    }
}
```

## 수열과 구간 쿼리 2 [181923](https://school.programmers.co.kr/learn/courses/30/lessons/181923)
```
class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        var answer = IntArray(0)
        for(qArr in queries) {
            var min = -1
            for(i in qArr[0]..qArr[1])
                if((arr[i] < min || min == -1) && arr[i] > qArr[2])
                    min = arr[i]
            answer += min
        }
        return answer
    }
}
```

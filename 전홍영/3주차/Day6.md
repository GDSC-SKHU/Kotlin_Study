# Day 6
## 마지막 두 원소
```kotlin
class Solution {
    fun solution(num_list: IntArray) = num_list.run {
        val last = get(size - 1)
        val secondLast = get(size - 2)
        if (last > secondLast) copyOf() + (last - secondLast) 
        else copyOf() + (last * 2)
    }
}
```
## 수 조작하기 1
```kotlin
class Solution {
    fun solution(n: Int, control: String): Int {
        var answer:Int = n
        for(i in 0..control.length-1){
            when(control[i]){
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
## 수 조작하기 2
```kotlin
class Solution {
    fun solution(numLog: IntArray): String {
        var answer: String = ""
        for(i in 0..numLog.size-2){
            var temp = numLog[i+1] - numLog[i]
            when(temp){
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
## 수열과 구간 쿼리 3
```kotlin
class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        for (query in queries) {
            //XOR 교환 알고리즘은 임시 변수를 사용하지 않고 두 변수의 값을 교환하는 데 사용되는 기술입니다. 
            //여기에는 스왑을 달성하기 위해 변수 간에 비트별 XOR 연산을 수행하는 것이 포함됩니다.
            arr[query[0]] = arr[query[0]] xor arr[query[1]] //xor연산은 같으면 0 다르면 1
            arr[query[1]] = arr[query[0]] xor arr[query[1]]
            arr[query[0]] = arr[query[0]] xor arr[query[1]]
        }
        return arr
    }
}

//처음 작성한 코드
class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        for (query in queries) {
            var temp = arr.get(query[1])
            arr.set(query[1], arr.get(query[0]))
            arr.set(query[0], temp)
        }
        return arr
    }
}
```
## 수열과 구간 쿼리 2
```kotlin
class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        val answer = IntArray(queries.size) { -1 }
        for (i in queries.indices) {
            var smallest = -1
            for (j in queries[i][0]..queries[i][1]) {
                if (arr[j] > queries[i][2] && (smallest == -1 || arr[j] < smallest)){
                    smallest = arr[j]
                }
            }
            answer[i] = smallest
        }
        return answer
    }
}
```
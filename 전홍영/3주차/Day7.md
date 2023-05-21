# Day 7
## 수열과 구간 쿼리 4
```kotlin
class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        queries.forEach { query ->
            for (i in query[0]..query[1]) {
                if (i % query[2] == 0) arr[i] += 1
            }
        }
        return arr
    }
}
```
## 배열 만들기 2
```kotlin
class Solution {
    fun solution(l: Int, r: Int): IntArray {
        val result = mutableListOf<Int>()//수정 가능한 List인 MutableList를 사용
        for (i in l..r) if (isNumberValid(i)) result.add(i)
        return if (result.isNotEmpty()) result.toIntArray() else intArrayOf(-1)
    }

    private fun isNumberValid(n: Int): Boolean {
        var num = n
        while (num > 0) {
            if (num % 10 != 0 && num % 10 != 5) return false//0과 5가 아닌 수가 있으면 false
            num /= 10
        }
        return true
    }
}
```
## 카운트 업
```kotlin
class Solution {
    fun solution(start: Int, end: Int) = (start..end).toList()
}
```
## 콜라츠 수열 만들기
```kotlin
class Solution {
    fun solution(n: Int): IntArray {
        val list = mutableListOf<Int>()
        var num = n
        while (num != 1) {
            list.add(num)
            num = if (num % 2 == 0) num / 2 else num * 3 + 1
        }
        list.add(1)
        return list.toIntArray()
    }
}
```
## 배열 만들기 4
```kotlin
class Solution {
     fun solution(arr: IntArray): IntArray {
        var stk: IntArray = intArrayOf()
        var i = 0
        while (i < arr.size) {//i가 arr의 크기보다 작을 때까지 반복
            if (stk.isEmpty() || stk.last() < arr[i]) {//stk가 비어있거나 stk의 마지막 값이 arr[i]보다 작으면
                stk += arr[i]//stk에 arr[i]를 추가
                i++
            } else {
                stk = stk.dropLast(1).toIntArray()//stk의 마지막 값을 제외한 나머지를 stk에 저장
            }
        }
        return stk
    }
}
```
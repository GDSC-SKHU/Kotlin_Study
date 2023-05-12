# Day 7

수열과 구간 쿼리 4

```Kotlin
class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        // forEach를 이용하여 queries 반복
        queries.forEach { query ->
            // query[0]: s, query[1]: e, query[2]: k
            // 순서대로 s ≤ i ≤ e인 모든 i에 대해 i가 k의 배수이면 arr[i] 1 증가
            for (i in query[0]..query[1]) {
                if (i % query[2] == 0)
                    arr[i] += 1
            }
        }
        return arr
    }
}
```

배열 만들기 2

```Kotlin
class Solution {
    fun solution(l: Int, r: Int): IntArray {
        // 범위 (l ~ r) 내의 모든 숫자를 생성
        // 숫자들을 문자열로 변환하고 해당 문자열의 모든 표현이 0 또는 5로만 이루어졌는지 확인
        // 필터링 결과에 따라 IntArray 출력
        return (l .. r)
            .filter { num -> num.toString().all { it == '0' || it == '5' } }
            .let { if (it.isEmpty()) intArrayOf(-1) else it.toIntArray() }
    }
}

// 'all' 함수는 문자열의 각 문자에 대해 주어진 조건을 모두 만족하는지 확인
// 'let' 함수는 이전에 필터링된 결과에 대해 수행할 동작을 지정
// 'it'은 'let' 함수의 수신 객체인 필터링된 결과를 의미
```

카운트 업

```Kotlin
// 주어진 start와 end 사이의 숫자 범위를 생성하여 그 숫자들을 요소로 갖는 IntArray를 반환
class Solution {
    fun solution(start: Int, end: Int): IntArray {
        return (start..end).toList().toIntArray()
    }
}
```

콜라츠 수열 만들기

```Kotlin
class Solution {
    fun solution(n: Int): IntArray {
        var x = n
        var answer: IntArray = intArrayOf()
        while (x != 1) {
            answer += x

            if (x % 2 == 0) x /= 2
            else x = 3 * x + 1
        }
        answer += 1
        return answer
    }
}
```

배열 만들기 4

```Kotlin
class Solution {
    fun solution(arr: IntArray): IntArray {
        var stk: IntArray = intArrayOf()
        var i: Int = 0

        while (i < arr.size) {
            if (stk.isEmpty() || stk[stk.size - 1] < arr[i]) {
                stk += arr[i++]
            } else {
                stk = stk.copyOfRange(0, stk.size - 1)
            }
        }

        return stk
    }
}
```

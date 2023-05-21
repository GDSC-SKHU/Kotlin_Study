# Day 6

마지막 두 원소

```Kotlin
// takeLast() 사용
class Solution {
    fun solution(num_list: IntArray): IntArray {
        val (prev, last) = num_list.takeLast(2)
        val temp = if (prev < last) last - prev else last * 2
        return num_list + temp
    }
}
```

수 조작하기 1

```Kotlin
class Solution {
    fun solution(n: Int, control: String): Int {
        // fold()를 사용하여 control 각 문자를 반복하고 값을 누적
        return control.fold(n) { acc, c ->
            when (c) {
                'w' -> acc + 1
                's' -> acc - 1
                'd' -> acc + 10
                'a' -> acc - 10
                else -> acc
            }
        }
    }
}
```

수 조작하기 2

```Kotlin
class Solution {
    fun solution(numLog: IntArray): String {
        var s: String = ""

        for (i in 1..numLog.size-1) {
            var diff: Int = numLog[i] - numLog[i - 1]
            when (diff) {
                1 -> s += "w"
                -1 -> s += "s"
                10 -> s += "d"
                -10 -> s += "a"
            }
        }

        return s
    }
}
```

수열과 구간 쿼리 3

```Kotlin
class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        // forEach를 이용하여 queries 반복
        // also를 이용하여 간결하게 원소를 교환 가능
        queries.forEach { (start, end) ->
            arr[start] = arr[end].also { arr[end] = arr[start] }
        }
        return arr
    }
}
```

수열과 구간 쿼리 2

```Kotlin
class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        //
        return queries.map { (start, end, k) ->
            // arr에서 start ~ end 범위의 부분 배열 추출 후
            // k보다 큰 원소만 필터링
            // 필터링된 원소 중에서 최솟값 반환 (없는 경우 -1 반환)
            arr.copyOfRange(start, end + 1)
               .filter { it > k }
               .minOrNull() ?: -1
        }.toIntArray() // map의 결과를 IntArray로 변환
    }
}
```

</br>

```kotlin
// '?:' 엘비스 연산자
// str?.length ?: -1는 엘비스 연산자 왼쪽의 str?.length 객체가
// null이 아니면 그 값을 리턴하고, null이면 -1을 리턴합니다
fun main(args: Array<String>){
    val str: String? = "1234"
    val nullStr: String? = null

    // str.length: 4
    var len: Int = str?.length ?: -1
    println("str.length: $len")

    // nullStr.length: -1
    len = nullStr?.length ?: -1
    println("nullStr.length: $len")
}
```

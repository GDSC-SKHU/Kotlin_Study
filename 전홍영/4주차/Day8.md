# Day8
## 간단한 논리 연산
```kotlin
class Solution {
    fun solution(x1: Boolean, x2: Boolean, x3: Boolean, x4: Boolean): Boolean {
        return (x1 || x2) && (x3 || x4)
    }
}
```
## 주사위 게임3
```kotlin

class Solution {
    fun solution(a: Int, b: Int, c: Int, d: Int): Int {
        val list = listOf(a, b, c, d).sorted()
        return when (list.toSet().size) {
            1 -> 1111 * list[0]//4개 같은 경우
            2 -> {//3개 같은 경우
                when {
                    list[0] == list[1] && list[2] == list[3] -> (list[0] + list[2]) * abs(list[0] - list[2])
                    list[0] == list[1] -> (10 * list[2] + list[3]).toDouble().pow(2).toInt()
                    else -> (10 * list[1] + list[0]).toDouble().pow(2).toInt()
                }
            }
            3 -> {//2개가 같고 나머지는 다를 경우
                when {
                    list[0] == list[1] -> list[2] * list[3]
                    list[1] == list[2] -> list[0] * list[3]
                    else -> list[0] * list[1]
                }
            }
            else -> list.minOf { it }//모두 다른 경우
        }
    }
}
```
## 글자 이어 붙여 문자열 만들기
```kotlin
class Solution {
    fun solution(my_string: String, index_list: IntArray): String {
        var answer = ""
        index_list.forEach { answer += my_string[it] }
        return answer
    }
}
```
## 9로 나눈 나머지
```kotlin
class Solution {
    fun solution(number: String): Int {
        val answer = number.map { it - '0' }.sum() % 9
        return answer
    }
}
```
## 문자열 여려 번 뒤집기
```kotlin
class Solution {
    fun solution(my_string: String, queries: Array<IntArray>): String {
        val answer = my_string.toCharArray().toMutableList()
        for (query in queries) {
            val s = query[0]
            val e = query[1]
            answer.subList(s, e + 1).reverse()
        }
        return answer.joinToString("")
    }
}
```
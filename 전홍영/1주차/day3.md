# Day 3

## 1. 문자열 섞기
```kotlin
class Solution {
    fun solution(str1: String, str2: String): String {
        var answer: String = ""
        for(i in str1.indices){
            answer += str1[i]
            answer += str2[i]
        }
        return answer
    }
}
```
## 2. 문자 리스트를 문자열로 변환하기
```kotlin
class Solution {
    fun solution(arr: Array<String>): String {
        return StringBuilder()
            .apply { arr.forEach { append(it) } }
            .toString();
    }
}
```
## 3. 문자열 곱하기
```kotlin
class Solution {
    fun solution(my_string: String, k: Int): String {
        return StringBuilder()
            .apply { for (i in 1..k)append(my_string) }
            .toString()
    }
}    
```
## 4. 더 크게 합치기
```kotlin
class Solution {
    fun solution(a: Int, b: Int): Int {
        val ab = StringBuilder()
            .append(a)
            .append(b)
            .toString()
            .toInt()
        val ba = StringBuilder()
            .append(b)
            .append(a)
            .toString()
            .toInt()
        if(ab > ba) return ab
        return ba    
    }
}
```
## 5. 두 수의 연산값 비교하기
```kotlin
class Solution {
    fun solution(a: Int, b: Int): Int {
        val ab = a.toString() + b.toString()
        return ab.toInt().coerceAtLeast(a * b * 2)
    }
}
```
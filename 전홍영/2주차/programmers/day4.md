#Day4
## n의 배수 구하기
```kotlin
class Solution {
    fun solution(num: Int, n: Int): Int {
        if(num % n == 0) return 1 else return 0
    }
}
```
## 공배수
```kotlin
class Solution {
    fun solution(number: Int, n: Int, m: Int): Int {
        if(number % n == 0 && number % m == 0) return 1 else return 0
    }
}
```
## 홀짝에 따라 다른 값 반환하기
```kotlin
class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        if( n % 2 == 0){
            for(i in 2 until n+1 step 2) answer += (i* i)
        }else{
            for(i in 1 until n+1 step 2) answer += i
        }
        return answer
    }
}
```
## 조건 문자열
```kotlin
class Solution {
    fun solution(ineq: String, eq: String, n: Int, m: Int): Int {
        var answer :Int = 0
        val plus: String = ineq + eq
        when(plus){
            ">=" -> if(n >= m) answer = 1
            "<=" -> if(n <= m) answer = 1
            ">!" -> if(n > m) answer = 1
            "<!" -> if(n < m) answer = 1
        }
        return answer
    }
}
```
## flag에 따라 다른 값 반환하기
```kotlin
class Solution {
    fun solution(a: Int, b: Int, flag: Boolean): Int {
        when (flag) {
            true -> return a + b
            false -> return a - b
        }
    }
}
```

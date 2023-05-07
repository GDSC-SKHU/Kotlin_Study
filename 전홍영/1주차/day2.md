# Day 2
## 1. 덧셈식 출력하기
```kotlin
fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map(String::toInt)
    val sum = a + b
    println("$a + $b = $sum")
}
```
## 2. 문자열 붙여서 출력하기
```kotlin
fun main(args: Array<String>) {
    val input = readLine()!!.split(' ')
    val s1 = input[0]
    val s2 = input[1]
    print("${s1+s2}")
}
```
## 3. 문자열 돌리기
```kotlin
fun main(args: Array<String>) {
    val s1 = readLine()!!
    for(i in 1..s1.length){
        println(s1[i-1])
    }
}
```
## 4. 홀짝 구분하기
```kotlin
fun main(args: Array<String>) {
    val a = readLine()!!.toInt()
    
    when(a % 2){
        0 -> print("$a is even")
        else -> print("$a is odd")
    }
}
```
## 5. 문자열 겹쳐쓰기
```kotlin
class Solution {
    fun solution(my_string: String, overwrite_string: String, s: Int): String {
            var answer: String = ""
        answer += my_string.substring(0, s)
        answer += overwrite_string
        answer += my_string.substring(s + overwrite_string.length, my_string.length)
        return answer
    }
}
```
# 2일차

**덧셈식 출력하기**

```kotlin
fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map(String::toInt)
    println("${a} + ${b} = ${a+b}")
}
```

**문자열 붙여서 출력하기**

```kotlin
fun main(args: Array<String>) {
	val input = readLine()!!.split(' ')
    val s1 = input[0]
    val s2 = input[1]
    
    print("${s1}${s2}")
}
```

**문자열 돌리기**

```kotlin
fun main(args: Array<String>) {
    val s1 = readLine()!!
    for(c in s1) println(c)
}
```

**홀짝 구분하기**

```kotlin
fun main(args: Array<String>) {
    val a = readLine()!!.toInt()
    if(a % 2 == 0) print("${a} is even") else print("${a} is odd")
}
```

**문자열 겹쳐쓰기**
```kotlin
class Solution {
    fun solution(my_string: String, overwrite_string: String, s: Int): String {
        var answer: String = my_string.substring(0, s) + overwrite_string + my_string.substring(s + overwrite_string.length, my_string.length)

        return answer
    }
}
```
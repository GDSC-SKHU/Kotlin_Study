# Day 2

덧셈식 출력하기

```Kotlin
fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map(String::toInt)
    println("$a + $b = ${a + b}")
}
```

문자열 붙여서 출력하기

```Kotlin
fun main(args: Array<String>) {
		val input = readLine()!!.split(' ')
    val s1 = input[0]
    val s2 = input[1]
    print(s1 + s2)
}
```

문자열 돌리기

```Kotlin
fun main(args: Array<String>) {
    val s1 = readLine()!!
    for (c in s1) {
        println(c)
    }
}
```

홀짝 구분하기

```Kotlin
fun main(args: Array<String>) {
    val a = readLine()!!.toInt()
    print("$a is ")
    if (a % 2 == 0) print("even") else print("odd")
}
```

문자열 겹쳐쓰기

```Kotlin
class Solution {
    fun solution(my_string: String, overwrite_string: String, s: Int): String {
        var answer: String = ""
        for (i in 0..s-1) {
            answer += my_string[i]
        }
        for (i in 0..overwrite_string.length-1) {
            answer += overwrite_string[i]
        }
        if (my_string.length > s + overwrite_string.length) {
            for (i in s + overwrite_string.length..my_string.length - 1) {
                answer += my_string[i]
            }
        }
        return answer
    }
}
```

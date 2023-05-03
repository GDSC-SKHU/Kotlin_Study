# 1일차

**문자열 출력하기**

```kotlin
fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map(String::toInt)
    println(a + b)
}
```

**a와 b 출력하기**

```kotlin
fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map(String::toInt)
    println("a = ${a}")
    println("b = ${b}")
}
```

**문자열 반복해서 출력하기**

```kotlin
fun main(args: Array<String>) {
	val input = readLine()!!.split(' ')
    val s1 = input[0]
    val a = input[1]!!.toInt()

    print(s1.repeat(a))
}
```

**대소문자 바꿔서 출력하기**

```kotlin
fun main(args: Array<String>) {
    val s1 = readLine()!!
    
    for(i in 0 until s1.length) {
        if(s1[i].isUpperCase()) print(s1[i].toLowerCase())
        else print(s1[i].toUpperCase())
    }
}
```

**특수문자 출력하기**
```kotlin
fun main(args: Array<String>) {
    print("!@#$%^&*(\\'\"<>?:;") // 따옴표는 앞에 '\' 붙이기
}
```
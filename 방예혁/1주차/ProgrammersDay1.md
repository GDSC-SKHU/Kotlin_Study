# Day 1

문자열 출력하기

```Kotlin
fun main(args: Array<String>) {
    val s1 = readLine()!!
    print(s1)
}
```

a와 b 출력하기

```Kotlin
fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map(String::toInt)
    println("a = $a")
    println("b = $b")
}
```

문자열 반복해서 출력하기

```Kotlin
fun main(args: Array<String>) {
	val input = readLine()!!.split(' ')
    val s1 = input[0]
    val a = input[1]!!.toInt()
    for (i in 1..a) {
        print(s1)
    }
}
```

대소문자 바꿔서 출력하기

```Kotlin
fun main(args: Array<String>) {
    val s1 = readLine()!!
    for (c in s1) {
        if (c.isUpperCase()) {
            print(c.toLowerCase())
        } else {
            print(c.toUpperCase())
        }
    }
}
```

특수문자 출력하기

```Kotlin
fun main(args: Array<String>) {
    print("""!@#$%^&*(\'"<>?:;""")
}
```

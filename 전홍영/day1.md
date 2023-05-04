# Day 1
## 1. 문자열 출력하기
```kotlin
fun main(args: Array<String>) {
    val s1 = readLine()!!
    println(s1)
}
```
## 2. a와 b 출력하기
```kotlin
fun main(args: Array<String>) {
  val (a, b) = readLine()!!.split(' ').map(String::toInt)
  println("a = $a" )
  println("b = $b" )
}
```
## 3. 문자열 반복해서 출력하기
```kotlin
fun main(args: Array<String>) {
    val input = readLine()!!.split(' ')
    val s1 = input[0]
    val a = input[1]!!.toInt()
    for(i in 1..a) {
      print(s1)  
    } 
}
```
## 4. 대소문자 바꿔서 출력하기
```kotlin
fun main(args: Array<String>) {
    val s1 = readLine()!!
    val chars = s1.toCharArray()
    for (i in chars.indices) {
        val c = chars[i]
        if (c.isLowerCase()) {
            chars[i] = c.toUpperCase()
        } else if (c.isUpperCase()) {
            chars[i] = c.toLowerCase()
        }
    }
    print(String(chars)) 
}
```
## 5. 특수문자 출력하기
```kotlin
fun main(args: Array<String>) {
    print("!@#$%^&*(\\'\"<>?:;")
}
```
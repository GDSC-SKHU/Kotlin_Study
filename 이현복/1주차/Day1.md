# 1일차
## 문자열 출력하기 [181952](https://school.programmers.co.kr/learn/courses/30/lessons/181952)
```
fun main(args: Array<String>) {
    val s1 = readLine()!!
    print(s1);
}
```

## a와 b 출력하기 [181951](https://school.programmers.co.kr/learn/courses/30/lessons/181951)
```
fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map(String::toInt)
    println("a = ${a}\nb = ${b}")
}
```

## 문자열 반복해서 출력하기 [181950](https://school.programmers.co.kr/learn/courses/30/lessons/181950)
```
fun main(args: Array<String>) {
		val input = readLine()!!.split(' ')
    val s1 = input[0]
    val a = input[1]!!.toInt()
    
    for(index in 1..a)
        print(s1)
}
```
## 대소문자 바꿔서 출력하기 [181949](https://school.programmers.co.kr/learn/courses/30/lessons/181949)
```
fun main(args: Array<String>) {
    val s1 = readLine()!!
    for(t in s1){
        if(t.isUpperCase())
            print(t.toLowerCase())
        else if(t.isLowerCase())
            print(t.toUpperCase())
    }
    
}
```

## 특수문자 출력하기 [181948](https://school.programmers.co.kr/learn/courses/30/lessons/181948)
```
fun main(args: Array<String>) {
    print("!@#$%^&*(\\'\"<>?:;")
}
```
# 2일차
## 덧셈식 출력하기 [181947](https://school.programmers.co.kr/learn/courses/30/lessons/181947)
```
fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map(String::toInt)
    println("${a} + ${b} = ${a+b}")
}
```

## 문자열 붙여서 출력하기 [181946](https://school.programmers.co.kr/learn/courses/30/lessons/181946)
```
fun main(args: Array<String>) {
		val input = readLine()!!.split(' ')
    val s1 = input[0]
    val s2 = input[1]
    print(s1+s2);
}
```

## 문자열 돌리기 [181945](https://school.programmers.co.kr/learn/courses/30/lessons/181945)
```
fun main(args: Array<String>) {
    val s1 = readLine()!!
    for(t in s1)
        println(t);
}
```
## 홀짝 구분하기 [181944](https://school.programmers.co.kr/learn/courses/30/lessons/181944)
```
fun main(args: Array<String>) {
    val a = readLine()!!.toInt()
    if(a%2 == 0)
        print("${a} is even")
    else
        print("${a} is odd")
}
```

## 문자열 겹쳐쓰기 [181943](https://school.programmers.co.kr/learn/courses/30/lessons/181943)

```
class Solution {
    fun solution(my_string: String, overwrite_string: String, s: Int): String {
        var answer: String = my_string.substring(0, s)+overwrite_string+my_string.substring(s+overwrite_string.length, my_string.length)
        return answer
    }
}
```
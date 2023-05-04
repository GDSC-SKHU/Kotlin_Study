# 3일차
## 문자열 섞기 [181942](https://school.programmers.co.kr/learn/courses/30/lessons/181942)
```
class Solution {
    fun solution(str1: String, str2: String): String {
        var answer: String = ""
        for(t in str1.indices)
        {
            answer =answer+ str1[t] + str2[t]
        }
        return answer
    }
}
```

## 문자 리스트를 문자열로 변환하기 [181941](https://school.programmers.co.kr/learn/courses/30/lessons/181941)
```
class Solution {
    fun solution(arr: Array<String>): String {
        var answer: String = ""
        for(t in arr)
            answer += t
        return answer
    }
}
```

## 문자열 곱하기 [181940](https://school.programmers.co.kr/learn/courses/30/lessons/181940)
```
class Solution {
    fun solution(my_string: String, k: Int): String {
        var answer: String = ""
        for(t in 1..k)
            answer += my_string
        return answer
    }
}
```

## 더 크게 합치기 [181939](https://school.programmers.co.kr/learn/courses/30/lessons/181939)
```
class Solution {
    fun solution(a: Int, b: Int): Int {
        var answer: Int = 0
        if((a.toString() + b.toString()).toInt() > (b.toString() + a.toString()).toInt())
            answer = (a.toString() + b.toString()).toInt()
        else
            answer = (b.toString() + a.toString()).toInt()
        return answer
    }
}
```

## 두 수의 연산값 비교하기 [181938](https://school.programmers.co.kr/learn/courses/30/lessons/181938)
```
class Solution {
    fun solution(a: Int, b: Int): Int {
        var answer: Int = 0
        if((a.toString() + b.toString()).toInt() >= (2 * a * b))
            answer = (a.toString() + b.toString()).toInt()
        else
            answer = 2 * a * b
        return answer
    }
}
```
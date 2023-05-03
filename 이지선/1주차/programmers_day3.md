# 3일차

**문자열 섞기**

```kotlin
class Solution {
    fun solution(str1: String, str2: String): String {
        var answer: String = ""
        
        for(i in 0..str1.length-1) {
            answer += str1[i]
            answer += str2[i]
        }
        return answer
    }
}
```

**문자 리스트를 문자열로 변환하기**

```kotlin
class Solution {
    fun solution(arr: Array<String>): String {
        var answer: String = arr.joinToString("")
        return answer
    }
}
```

**문자열 곱하기**

```kotlin
class Solution {
    fun solution(my_string: String, k: Int): String {
        var answer: String = my_string.repeat(k)
        return answer
    }
}
```

**더 크게 합치기**

```kotlin
class Solution {
    fun solution(a: Int, b: Int): Int {
        var answer: Int = 0
        var s1: String = a.toString() + b.toString()
        var s2: String = b.toString() + a.toString()
        
        if(s1.compareTo(s2) > 0) return s1
        else return s2
    }
}
```

**두 수의 연산값 비교하기**
```kotlin
class Solution {
    fun solution(a: Int, b: Int): Int {
        // $를 이용해 문자열 변환을 쉽게 할 수 있다.
        if ("$a$b".toInt() > 2*a*b) return "$a$b".toInt()
        else return 2*a*b
    }
}
```
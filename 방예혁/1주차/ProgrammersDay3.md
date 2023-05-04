# Day 3

문자열 섞기

```Kotlin
class Solution {
    fun solution(str1: String, str2: String): String {
        var answer: String = ""
        for (i in 0..str1.length-1) {
            answer += str1[i]
            answer += str2[i]
        }
        return answer
    }
}
```

문자 리스트를 문자열로 변환하기

```Kotlin
class Solution {
    fun solution(arr: Array<String>): String {
        var answer: String = ""
        arr.forEach { answer += it }
        return answer
    }
}
```

문자열 곱하기

```Kotlin
class Solution {
    fun solution(my_string: String, k: Int): String {
        var answer: String = ""
        for (i in 1..k) {
            answer += my_string
        }
        return answer
    }
}
```

더 크게 합치기

```Kotlin
class Solution {
    fun solution(a: Int, b: Int): Int {
        var answer: Int = 0
        var ab = (a.toString() + b.toString()).toInt()
        var ba = (b.toString() + a.toString()).toInt()
        if (ab > ba) {
            answer = ab
        } else {
            answer = ba
        }
        return answer
    }
}
```

두 수의 연산값 비교하기

```Kotlin
class Solution {
    fun solution(a: Int, b: Int): Int {
        var answer: Int = 0
        var ab: Int = (a.toString() + b.toString()).toInt()
        var ab2: Int = 2 * a * b
        if (ab >= ab2) {
            answer = ab
        } else {
            answer = ab2
        }
        return answer
    }
}
```

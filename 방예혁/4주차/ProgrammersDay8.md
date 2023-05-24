# Day 8

간단한 논리 연산

```Kotlin
class Solution {
    fun solution(x1: Boolean, x2: Boolean, x3: Boolean, x4: Boolean) = (x1 || x2) && (x3 || x4)
}
```

주사위 게임 3

```Kotlin
import kotlin.math.*

class Solution {
    fun solution(a: Int, b: Int, c: Int, d: Int): Int {
        var point: Int = 0

        // a = b = c = d
        if (a == b && b == c && c == d) point = 1111 * a
        // a = b = c, d
        else if (a == b && b == c && c != d) point = (10 * c + d) * (10 * c + d)
        // a = b = d, c
        else if (a == b && b == d && b != c) point = (10 * b + c) * (10 * b + c)
        // a = c = d, b
        else if (a == c && c == d && a != b) point = (10 * a + b) * (10 * a + b)
        // b = c = d, a
        else if (b == c && c == d && d != a) point = (10 * d + a) * (10 * d + a)
        // a = b, c = d
        else if (a == b && c == d && a != c) point = (a + c) * abs(a - c)
        // a = c, b = d
        else if (a == c && b == d && a != b) point = (a + b) * abs(a - b)
        // a = d, b = c
        else if (a == d && b == c && a != b) point = (a + b) * abs(a - b)
        // a = b, c, d
        else if (a == b && a != c && c != d) point = c * d
        // a = c, b, d
        else if (a == c && a != b && b != d) point = b * d
        // a = d, b, c
        else if (a == d && a != b && b != c) point = b * c
        // b = c, a, d
        else if (b == c && b != a && a != d) point = a * d
        // b = d, a, c
        else if (b == d && b != a && a != c) point = a * c
        // c = d, a, b
        else if (c == d && c != a && a != b) point = a * b
        // a, b, c, d
        else point = min(min(a, b), min(c, d))

        return point
    }
}
```

글자 이어 붙여 문자열 만들기

```Kotlin
class Solution {
    fun solution(my_string: String, index_list: IntArray): String {
        var answer: String = ""
        index_list.forEach { answer += my_string[it] }
        return answer
    }
}
```

9로 나눈 나머지

```Kotlin
class Solution {
    fun solution(number: String): Int {
        var sum: Int = 0
        number.forEach { sum += it.toString().toInt() }
        return sum % 9
    }
}
```

문자열 여러 번 뒤집기

```Kotlin
class Solution {
    fun solution(my_string: String, queries: Array<IntArray>): String {
        var answer = my_string
        for (query in queries) {
            answer = answer.substring(0, query[0]) +
                     answer.substring(query[0], query[1]+1).reversed() +
                     answer.substring(query[1]+1)
        }
        return answer
    }
}
```

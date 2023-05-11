# Day 5

코드 처리하기

```Kotlin
class Solution {
    fun solution(code: String): String {
        var ret: String = ""      // 결과를 저장할 문자열
        var mode: Boolean = false // 모드

        // 문자열 코드를 문자 하나씩 읽음
        for (idx in 0..code.length-1) {
            if(code[idx] == '1') {
                // 문자가 '1'인 경우 모드 변경
                mode = !mode
            } else {
                // 문자가 '1'이 아닌 경우 모드에 따라 ret 추가
                if (mode == false && idx % 2 == 0) {
                    ret += code[idx]
                } else if (mode == true && idx % 2 == 1) {
                    ret += code[idx]
                }
            }
        }

        // 만약 ret이 빈 문자열인 경우 "EMPTY" 출력
        if (ret == "")
            return "EMPTY"

        // 결과 출력
        return ret
    }
}
```

등차수열의 특정한 항만 더하기

```Kotlin
class Solution {
    fun solution(a: Int, d: Int, included: BooleanArray): Int {
        var result: Int = 0
        // 첫 번째 항부터 확인하기
        for (i in 0..included.size-1) {
            // 해당 항의 included 값이 true인 경우 해당 항을 구해서 합함
            if (included[i])
                result += (a + d * i)
        }
        return result
    }
}
```

주사위 게임 2

```Kotlin
class Solution {
    fun solution(a: Int, b: Int, c: Int): Int {
        if (a == b && a == c && b == c) {
            return (a + b + c) * (a * a + b * b + c * c) * (a * a * a + b * b * b + c * c * c)
        } else if (a == b || a == c || b == c) {
            return (a + b + c) * (a * a + b * b + c * c)
        } else {
            return a + b + c
        }
    }
}
```

원소들의 곱과 합

```Kotlin
class Solution {
    fun solution(num_list: IntArray): Int {
        var mul: Int = 1     // 모든 원소들의 곱
        var sumPow: Int = 0  // 모든 원소들의 합의 제곱
        for (n in num_list) {
            mul *= n
            sumPow += n
        }
        sumPow *= sumPow

        // 비교 후 결과 출력
        if (mul < sumPow)
            return 1
        else
            return 0
    }
}
```

이어 붙인 수

```Kotlin
class Solution {
    fun solution(num_list: IntArray): Int {
        var odd: String = ""
        var even: String = ""

        for (n in num_list) {
            if (n % 2 == 1)
                odd += n
            else
                even += n
        }

        return odd.toInt() + even.toInt()
    }
}
```

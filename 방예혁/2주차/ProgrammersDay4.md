# Day 4

n의 배수

```Kotlin
class Solution {
    fun solution(num: Int, n: Int): Int {
        if (num % n == 0)
            return 1
        else
            return 0
    }
}
```

공배수

```Kotlin
class Solution {
    fun solution(number: Int, n: Int, m: Int): Int {
        if (number % n == 0 && number % m == 0)
            return 1
        else
            return 0
    }
}
```

홀짝에 따라 다른 값 반환하기

```Kotlin
class Solution {
    fun solution(n: Int): Int {
        if (n % 2 == 0)
            return even(n)
        else
            return odd(n)
    }

    // n 이하의 홀수인 모든 양의 정수의 합을 구함
    fun odd(n: Int): Int {
        var result: Int = 0

        for (i in 1..n step 2)
            result += i

        return result
    }

    // n 이하의 짝수인 모든 양의 정수의 제곱의 합을 구함
    fun even(n: Int): Int {
        var result: Int = 0

        for (i in 2..n step 2)
            result += (i * i)


        return result
    }
}
```

조건 문자열

```Kotlin
class Solution {
    fun solution(ineq: String, eq: String, n: Int, m: Int): Int {
        if (n > m) {
            // n > m 이면 ineq만 '>'만 확인
            if (ineq == ">")
                return 1
        } else if (n < m) {
            // n < m 인 경우도 '<'만 확인
            if (ineq == "<")
                return 1
        } else {
            // n == m 인 경우는 '='만 확인
            if (eq == "=")
                return 1
        }
        return 0
    }
}
```

flag에 따라 다른 값 반환하기

```Kotlin
class Solution {
    fun solution(a: Int, b: Int, flag: Boolean): Int {
        if (flag)
            return a + b
        else
            return a - b
    }
}
```

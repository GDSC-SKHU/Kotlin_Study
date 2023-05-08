# 2일차


**n의 배수**

```kotlin
    fun solution(num: Int, n: Int): Int {
        var answer = if(num % n == 0) 1 else 0
        return answer
    }
```

**공배수**

```kotlin
    fun solution(number: Int, n: Int, m: Int): Int {
        return if(number % n == 0 && number % m == 0) 1 else 0
    }
```

**홀짝에 따라 다른 값 반환하기**

```kotlin
    fun solution(n: Int): Int {
        var answer: Int = 0
        
        if(n%2 == 1) {
            for(i in 1..n step 2) answer+= i
        } else {
            for(i in 2..n step 2) answer+= i*i
        }
        return answer
    }
```

**조건 문자열**
```kotlin
    fun solution(ineq: String, eq: String, n: Int, m: Int): Int {
        var answer: Int = 0
        
        if(eq.equals("!")) {
            when(ineq) {
                ">" -> return if(n > m) 1 else 0
                "<" -> return if(n < m) 1 else 0
            }
        }
        
        if(eq.equals("=")) {
            when(ineq) {
                ">" -> return if(n >= m) 1 else 0
                "<" -> return if(n <= m) 1 else 0
            }
        }
        
        return answer
    }
```

**flag에 따라 다른 값 반환하기**

```kotlin
    fun solution(a: Int, b: Int, flag: Boolean): Int {
        return if(flag) a+b else a-b
    }
```
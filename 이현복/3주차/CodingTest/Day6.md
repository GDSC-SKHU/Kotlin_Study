# 4일차
## n의 배수 [181937](https://school.programmers.co.kr/learn/courses/30/lessons/181937)
```
class Solution {
    fun solution(num: Int, n: Int): Int {
        if(num%n==0)
            return 1
        else
            return 0
    }
}
```

## 공배수 [181936](https://school.programmers.co.kr/learn/courses/30/lessons/181936)
```
class Solution {
    fun solution(number: Int, n: Int, m: Int): Int {
        if(number%n == 0 && number%m == 0)
            return 1
        else
            return 0
    }
}
```

## 홀짝에 따라 다른 값 반환하기 [181935](https://school.programmers.co.kr/learn/courses/30/lessons/181935)
```
class Solution {
    fun solution(n: Int): Int {
        var result = 0
        if(n%2== 0) {
            for(i in 0..n step 2)
                result += i*i
        }
        else {
            for(i in 1..n step 2)
                result += i
        }
        return result
    }
}
```

## 조건 문자열 [181934](https://school.programmers.co.kr/learn/courses/30/lessons/181934)
```
class Solution {
    fun solution(ineq: String, eq: String, n: Int, m: Int): Int = 
    when(ineq+eq) {        
        "<=" -> if(n<=m) 1 else 0
        "<!" -> if(n<m) 1 else 0
        ">=" -> if(n>=m) 1 else 0
        ">!" -> if(n>m) 1 else 0
        else -> 0
    }   
}
```

## flag에 따라 다른 값 반환하기 [181933](https://school.programmers.co.kr/learn/courses/30/lessons/181933)
```
class Solution {
    fun solution(a: Int, b: Int, flag: Boolean): Int =
    if(flag) a+b
    else a-b
}
```

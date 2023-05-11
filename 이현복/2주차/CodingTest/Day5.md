# 5일차
## 코드 처리하기 [181932](https://school.programmers.co.kr/learn/courses/30/lessons/181932)
```
class Solution {
    fun solution(code: String): String {
        var mode:Boolean = false
        var ret:String = ""
        for(i in code.indices) {
            if(code[i] == '1')
                mode = !mode
            else if(i%2 == 0 && !mode)
                ret += code[i]
            else if(i%2 == 1 && mode)
                ret += code[i]
        }
        if(ret == "")
            return "EMPTY"
        return ret
    }
}
```

## 등차수열의 특정한 항만 더하기 [181931](https://school.programmers.co.kr/learn/courses/30/lessons/181931)
```
class Solution {
    fun solution(a: Int, d: Int, included: BooleanArray): Int {
        var answer: Int = 0
        var sum: Int = a
        for(i in included) {
            if(i)
                answer += sum
            sum += d
        }
        return answer
    }
}
```

## 주사위 게임 2 [181930](https://school.programmers.co.kr/learn/courses/30/lessons/181930)
```
class Solution {
    fun solution(a: Int, b: Int, c: Int): Int {
        if(a != b && b != c && a != c)
            return (a+b+c)
        else if(a == b && b == c && a == c)
            return (a*a*a*a*a*a*27)
        else
            return (a+b+c)*(a*a+b*b+c*c)
    }
}
```

## 원소들의 곱과 합 [181929](https://school.programmers.co.kr/learn/courses/30/lessons/181929)
```
class Solution {
    fun solution(num_list: IntArray): Int {
        var multi: Int = 1
        var sum: Int = 0
        for(i in num_list) {
            multi *= i
            sum += i
        }
        if(multi < sum*sum)
            return 1
        else
            return 0
    }
}
```

## 이어 붙인 수 [181928](https://school.programmers.co.kr/learn/courses/30/lessons/181928)
```
class Solution {
    fun solution(num_list: IntArray): Int {
        var odd : Int = 0;
        var even : Int = 0;
        for(i in num_list) {
            if(i%2 == 0)
                even = even*10+i
            else
                odd = odd*10+i
        }
        return even+odd
    }
}
```
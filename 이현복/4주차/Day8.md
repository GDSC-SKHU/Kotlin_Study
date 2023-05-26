# 8일차
## 간단한 논리 연산 [181917](https://school.programmers.co.kr/learn/courses/30/lessons/181917)
```
class Solution {
    fun solution(x1: Boolean, x2: Boolean, x3: Boolean, x4: Boolean): Boolean {
        return (x1 || x2) && (x3 || x4)
    }
}
```

## 주사위 게임 3 [181916](https://school.programmers.co.kr/learn/courses/30/lessons/181916)
```
import kotlin.math.*

class Solution {
    fun solution(a: Int, b: Int, c: Int, d: Int): Int {
        var answer: Int = 0
        var arr = arrayOf(a, b, c, d)
        arr.sort()
        
        for(i in 0..arr.size-2)
            if(arr[i] != arr[i+1])
                answer++
        if(answer == 0)
            return 1111*a
        else if(answer == 1) {
            if(arr[0] == arr[1] && arr[0]==arr[2])
                return (10*arr[0]+arr[3]) * (10*arr[0]+arr[3])
            else if(arr[3] == arr[2] && arr[2] == arr[1])
                return (10*arr[3]+arr[0]) * (10*arr[3]+arr[0])
            else
                return (arr[0] + arr[2]) * abs(arr[0] - arr[2])
        }
            
        else if(answer == 2) {
            if(arr[0] == arr[1])
                return arr[2] * arr[3]
            else if(arr[1] == arr[2])
                return arr[0] * arr[3]
            else
                return arr[0] * arr[1]
        }
        
        else
            return arr[0]
    }
}
```

## 글자 이어 붙여 문자열 만들기 [181915](https://school.programmers.co.kr/learn/courses/30/lessons/181915)
```
class Solution {
    fun solution(my_string: String, index_list: IntArray): String {
        var answer: String = ""
        for(i in index_list)
            answer += my_string[i]
        return answer
    }
}
```

## 9로 나눈 나머지 [181914](https://school.programmers.co.kr/learn/courses/30/lessons/181914)
```
class Solution {
    fun solution(number: String): Int {
        var answer = 0
        for(i in number)
            answer += i.toString().toInt()
        return answer % 9
    }
}
```

## 문자열 여러 번 뒤집기 [181913](https://school.programmers.co.kr/learn/courses/30/lessons/181913)
```
class Solution {
    fun solution(my_string: String, queries: Array<IntArray>): String {
        var answer: String = my_string
        for(i in queries)
            answer = answer.substring(0, i[0]) + answer.substring(i[0], i[1]+1).reversed() + answer.substring(i[1]+1, answer.length)
        return answer
    }
}
```
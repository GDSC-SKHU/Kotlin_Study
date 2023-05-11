# 1일차

**코드 처리하기**

```kotlin
    fun solution(code: String): String {
        var ret = ""
        var mode = false
        
        for(i in 0..code.length-1) {
            if(code[i].equals('1')) mode = !mode
            else {
                if(!mode && i%2 == 0) ret += code[i]
                else if(mode && i%2 == 1) ret += code[i]
            }
        }
        
        return if(ret.isEmpty()) "EMPTY" else ret
    }
```

**등차수열의 특정한 항만 더하기**

```kotlin
    fun solution(a: Int, d: Int, included: BooleanArray): Int {
        var answer = 0
        var an = a
        
        for(i in included.indices) {
            if(included[i]) {
                answer += an
                print(an)
            }
            an += d
        }
        return answer
    }
```

**주사위 게임 2**

```kotlin
    fun solution(a: Int, b: Int, c: Int): Int {
        var answer: Int = 0
        
        if(a != b && b != c && c != a) answer = a+b+c
        else if(a == b && b == c && c == a) answer = (a+b+c) * (a*a + b*b + c*c) * (a*a*a + b*b*b + c*c*c)
        else answer = (a+b+c) * (a*a + b*b + c*c)
        return answer
    }
```

**원소들의 곱과 합**

```kotlin
    fun solution(num_list: IntArray): Int {
        var mul = 1
        var sum = 0
        
        for(i in 0..num_list.size-1) {
            mul *= num_list[i]
            sum += num_list[i]
        }
        
        sum *= sum
        
        return if(mul < sum) 1 else 0
    }
```

**이어 붙인 수**
```kotlin
    fun solution(num_list: IntArray): Int {
        var odd = ""
        var even = ""
        
        for(i in 0..num_list.size-1) {
            if(num_list[i]%2 == 0) even += num_list[i]
            else odd += num_list[i]
        }
        
        return odd.toInt() + even.toInt()
    }
```
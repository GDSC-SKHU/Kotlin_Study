# Day5
## 코드 처리하기
```kotlin
class Solution {
    fun solution(code: String): String {
        var answer: String = ""
        var mode: Int = 0
        for(i in 0..code.length-1){
            when(mode){
                0 -> {
                    if(code[i] == '1') mode = 1
                    else if(i % 2 == 0) answer += code[i]
                }
                1 -> {
                    if(code[i] == '1') mode = 0
                    else if(i % 2 == 1) answer += code[i]
                }
            }
        }
        if(answer.length == 0) return "EMPTY" else return answer
    }
}
```
## 등차수열의 특정한 항만 더하기
```kotlin
class Solution {
    fun solution(a: Int, d: Int, included: BooleanArray): Int {
        var answer: Int = 0
        var present: Int = a
        for(i in included){
            when(i){
                true -> {
                    answer += present
                    present += d
                }
                false -> {
                    present += d
                }
            }
        }
        return answer
    }
}
```
## 주사위 게임 2
```kotlin
class Solution {
    fun solution(a: Int, b: Int, c: Int): Int {
        if (a === b && b === c && a === c) return (a + b + c) * (a * a + b * b + c * c) * (a * a * a + b * b * b + c * c * c)
        if (a === b || b === c || a === c) return (a + b + c) * (a * a + b * b + c * c)
        return a + b + c
    }
}
```
## 원소들의 곱과 합
```kotlin
class Solution {
    fun solution(num_list: IntArray): Int {
        var sum: Int = 0;
        var mul: Int = 1;
        for(num in num_list){
            sum += num
            mul *= num
        }
        if(sum * sum > mul) return 1 else return 0
    }
}
```
## 이어 붙인 수
```kotlin
class Solution {
    fun solution(num_list: IntArray): Int {
        var odd: String = ""
        var even: String = ""
        for(num in num_list){
            when(num %2){
                0 -> even += num.toString()
                1 -> odd += num.toString()
            }
        }
        return odd.toInt() + even.toInt()
    }
}
```
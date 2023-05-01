# Kotlin 간단 문법
## 타입
### 기본 타입
- 코틀린의 기본 타입은 모두 객체이다.
- 코틀린의 모든 것은 객체이다.
- 코틀린의 기본 타입은 자바의 기본 타입으로 컴파일된다.
- 코틀린의 기본 타입은 자바의 기본 타입과 다르게 null을 허용하지 않는다.
- 코틀린의 기본 타입은 자바의 기본 타입과 다르게 메소드를 가지고 있다.
### 다양한 기본 타입
- Int
- Long
- Float
- Double
- Short
- Byte
- Char
- Boolean
- String
- Array
- List
- Set
- Map
- ...
## ? 연산자
- 코틀린에서는 null을 허용하지 않는다.
- null을 허용하려면 타입 뒤에 ?를 붙여주면 된다.
- ?를 붙여주면 null을 허용하는 타입이 된다.
- ?를 붙여주면 메소드를 호출할 때 null 체크를 하지 않아도 된다.
- ?를 붙여주면 메소드를 호출할 때 null이면 null을 반환한다.
### null 체크
~~~kotlin
val a: String? = null
val b: String? = "Kotlin"
~~~
## !! 연산자
- !! 연산자는 null이 아님을 보장한다.
- !! 연산자는 null이 아님을 보장하기 때문에 null이면 에러가 발생한다.
- !! 연산자는 null이 아님을 보장하기 때문에 null이 아니라는 것을 컴파일러에게 알려준다.
### ! 연산자 사용
~~~kotlin
//! 연산자 사용 예시
val a: String? = null
val b: String = a!! // a가 null이면 에러 발생
~~~
## var vs val
### val
- val은 value의 약자로, 한번 선언하면 값을 변경할 수 없다.
- val은 상수와 같다고 생각하면 된다.
- val은 선언과 동시에 초기화해야 한다.
- val은 선언과 동시에 초기화하지 않으면 에러가 발생한다.
### var
- var은 variable의 약자로, 선언하고 나서 값을 변경할 수 있다.
- var은 변수와 같다고 생각하면 된다.
- var은 선언과 동시에 초기화하지 않아도 된다. 단, 타입을 명시해주어야 한다.
~~~kotlin
val a = 10
a = 20 // 에러 발생

var b = 10
b = 20 // 정상 실행

val c // 에러 발생
var d : Int // 정상 실행
~~~

## for문
### for문의 기본 구조
~~~kotlin
for(변수 in 범위) {
    반복할 내용
}
~~~
### 다양한 for문
~~~kotlin
val a = arrayOf(1, 2, 3, 4, 5)
for(i in a) { // 배열의 처음부터 끝까지 반복
    println(i)
}

val b = arrayOf(1, 2, 3, 4, 5)
for( i in b.indices) { // 배열의 인덱스만큼 반복
    println(b[i])
}

val myMap = mapOf("a" to 1, "b" to 2, "c" to 3)
for ((key, value) in myMap) { // 맵의 키와 값만큼 반복
    println("$key -> $value")
}

class MyIterator(val items: List<String>): Iterator<String> {
    var index = 0
    override fun hasNext() = index < items.size
    override fun next() = items[index++]
}

val myList = listOf("apple", "banana", "cherry")
val myIterator = MyIterator(myList)
for (fruit in myIterator) { // 커스텀 이터레이터를 사용한 반복
    println(fruit)
}
~~~

## while문
### while문의 기본 구조
~~~kotlin
while(조건식) {
    반복할 내용
}
~~~
### do-while문의 기본 구조
~~~kotlin
do {
    반복할 내용
} while(조건식)
~~~
### 라벨 while문
- 라벨을 이용하여 반복문을 빠져나가거나 다음 반복으로 넘어갈 수 있다.
- 라벨을 이용하면 중첩된 반복문에서도 원하는 반복문을 빠져나갈 수 있다.
- 라벨을 붙인 반복문을 빠져나가기 위해서는 break@라벨을 사용하면 된다.
- 라벨을 붙인 반복문을 빠져나가지 않고 다음 반복으로 넘어가기 위해서는 continue@라벨을 사용하면 된다.
- 라벨을 붙인 반복문을 빠져나가지 않고 다음 반복으로 넘어가지 않기 위해서는 return@라벨을 사용하면 된다.
~~~kotlin
outer@ for (i in 1..3) {
    for (j in 1..3) {
        println("i = $i, j = $j")
        if (i == 2 && j == 2) { 
            // i가 2이고 j가 2일 때 라벨을 사용한 반복문을 빠져나감 
            // 따라서 안의 for문이 아닌 밖의 for문을 빠져나감
            break@outer
        }
    }
}
~~~
## when문
### when문의 기본 구조
~~~kotlin
when(조건식) {
    조건식에 일치할 때 -> 수행할 내용
    조건식에 일치할 때 -> 수행할 내용
    else -> 수행할 내용
}
~~~
- when문은 java의 switch문과 비슷하다.
- when문은 조건식에 일치하는 경우에 수행할 내용을 실행한다.
### 다양한 when문
~~~kotlin
val a = 10
when(a) {
    0, 1 -> println("0 or 1")
    2 -> println("2")
    else -> println("else")
}

val b = 10
when(b) {
    in 0..9 -> println("0~9") // 범위를 지정할 수도 있다.
    in 10..20 -> println("10~20")
    else -> println("else")
}

val c = "Hello"
when(c) {
    is String -> println("c is String") // 타입을 지정할 수도 있다.
    else -> println("else")
}

val d = 10
when {
    d == 10 -> println("d is 10") // 조건식을 지정할 수도 있다.
    else -> println("else")
}
~~~
## if문
### if문의 기본 구조
~~~kotlin
if(조건식) {
    조건식이 true일 때 수행할 내용
} else {
    조건식이 false일 때 수행할 내용
}
~~~
### 다양한 if문
~~~kotlin
val a = 10
val b = 5
val max = if(a > b) a else b // if문의 결과를 변수에 할당할 수 있다.
~~~

## 함수
### 함수의 기본 구조
~~~kotlin
fun 함수명(변수명: 타입, 변수명: 타입, ...): 반환형 {
    함수 내용
    return 반환값
}
~~~
- 함수는 fun 키워드를 사용하여 선언한다.
- 함수의 반환형이 없을 경우 반환형을 생략할 수 있다.
- 함수의 반환형이 Unit일 경우 return 키워드를 생략할 수 있다.
#### Unit이란??
    - Unit은 반환형이 없음을 의미한다.
    - Unit은 생략할 수 있다.
    - Unit은 Object이다.

### 다양한 함수
~~~kotlin
fun sum(a: Int, b: Int): Int { // 반환형이 Int인 함수
    return a + b
}

fun sum(a: Int, b: Int) = a + b // 반환형이 Int인 함수

fun printKotlin(): Unit { // 반환형이 Unit인 함수
    println("Kotlin")
}

fun printKotlin() { // 반환형이 Unit인 함수
    println("Kotlin")
}
~~~
### 가변인자를 갖는 함수
~~~kotlin
fun sum(vararg numbers: Int): Int { // 가변인자를 갖는 함수
    var result = 0
    for (number in numbers) {
        result += number
    }
    return result
}

fun main() {
    println(sum(1, 2, 3))
    println(sum(1, 2, 3, 4, 5))// 가변인자를 갖는 함수는 인자의 개수가 달라도 된다.
}
~~~
- vararg 키워드를 사용하여 가변인자를 갖는 함수를 선언할 수 있다.
- 가변인자를 갖는 함수는 인자의 개수가 달라도 된다.
- 가변인자를 갖는 함수는 인자의 개수가 달라도 되기 때문에 인자의 개수가 정해지지 않은 함수를 만들 수 있다.
### 중위 표현법을 갖는 함수
~~~kotlin
infix fun Int.multiply(x: Int): Int { // 중위 표현법을 갖는 함수
    return this * x
}

fun main() {
    println(6.multiply(4)) // 일반적인 방식
    println(6 multiply 4) // 중위 표현법을 갖는 함수를 사용한 방식
}
~~~
- infix 키워드를 사용하여 중위 표현법을 갖는 함수를 선언할 수 있다.
- 중위 표현법을 갖는 함수는 클래스의 멤버 메서드 또는 확장 함수로 선언해야 한다.
- 중위 표현법을 갖는 함수는 인자가 하나뿐이어야 한다.
## 클래스
### 클래스의 기본 구조
~~~kotlin
class 클래스명 {
    프로퍼티
    메서드
}
~~~
- 클래스는 class 키워드를 사용하여 선언한다.
- 클래스는 프로퍼티와 메서드를 가질 수 있다.
- 클래스는 생성자를 가질 수 있다.
### 다양한 클래스
~~~kotlin
class Person constructor(name: String, age: Int) { // 생성자를 갖는 클래스
    val name: String = name
    val age: Int = age
}

class Person(name: String, age: Int) { // 생성자를 갖는 클래스
    val name: String = name
    val age: Int = age
}

class Person(val name: String, val age: Int) { // 프로퍼티를 갖는 클래스
    init { // 초기화 블록
        println("name: $name, age: $age")
    }
}

class Person(val name: String, val age: Int) { // 프로퍼티를 갖는 클래스
    constructor(name: String) : this(name, 10) { // 보조 생성자
        println("보조 생성자")
    }
}
~~~
- 생성자 생략 가능
- init 키워드를 사용하여 초기화 블록을 만들 수 있다.
- 보조 생성자를 만들 수 있다.
- 보조 생성자는 this 키워드를 사용하여 클래스의 다른 생성자를 호출해야 한다.
- 보조 생성자는 클래스의 다른 생성자를 호출할 때 괄호 안에 인자를 넣어야 한다.
### object?? class??  data class??
~~~kotlin
object Car { // object 키워드를 사용하여 객체를 선언할 수 있다.
    var speed = 0
    fun upSpeed() {
        speed += 10
    }
    fun downSpeed() {
        speed -= 10
    }
}

data class Person(val name: String, val age: Int) // data class 키워드를 사용하여 데이터 클래스를 선언할 수 있다.
~~~
- object 키워드를 사용하여 객체를 선언할 수 있다.
- object 키워드를 사용하여 선언한 객체는 싱글톤 패턴으로 구현된다.
- data class 키워드를 사용하여 데이터 클래스를 선언할 수 있다.
- data class 키워드를 사용하여 선언한 데이터 클래스는 toString(), equals(), hashCode(), copy() 메서드를 자동으로 생성한다.
- class와 object의 차이점은 클래스는 여러 개의 인스턴스를 생성할 수 있지만, 객체는 단 하나의 인스턴스만 생성할 수 있다는 것이다.
- data class와 object의 차이점은 data class는 데이터를 다루기 위한 클래스이고, object는 싱글톤 패턴으로 구현된 객체이다.
- data class는 데이터를 다루기 위한 클래스이기 때문에 데이터베이스와 통신할 때 주로 사용된다.
### 클래스의 상속
~~~kotlin
open class Person(val name: String, val age: Int) { // open 키워드를 사용하여 상속이 가능한 클래스를 만들 수 있다.
    fun print() {
        println("name: $name, age: $age")
    }
}

class Student(name: String, age: Int, val id: Int) : Person(name, age) { // 상속을 받는 클래스
    fun printId() {
        println("id: $id")
    }
}

fun main() {
    val student = Student("홍길동", 20, 20210101)
    student.print()
    student.printId()
}
~~~
- open 키워드를 사용하여 상속이 가능한 클래스를 만들 수 있다.
- 상속을 받는 클래스는 클래스 이름 뒤에 콜론(:)을 붙이고, 상속할 클래스의 이름을 적는다.
- 상속을 받는 클래스는 상속할 클래스의 생성자를 호출해야 한다.
### interface
~~~kotlin
interface Person { // interface 키워드를 사용하여 인터페이스를 선언할 수 있다.
    fun print()
}

class Student(val name: String, val age: Int) : Person { // 인터페이스를 구현하는 클래스
    override fun print() { // 인터페이스의 메서드를 구현한다.
        println("name: $name, age: $age")
    }
}

fun main() {
    val student = Student("홍길동", 20)
    student.print()
}
~~~
- interface 키워드를 사용하여 인터페이스를 선언할 수 있다.
- 인터페이스를 구현하는 클래스는 클래스 이름 뒤에 콜론(:)을 붙이고, 인터페이스의 이름을 적는다.
- 인터페이스를 구현하는 클래스는 인터페이스의 메서드를 구현해야 한다.
### abstract class
~~~kotlin
abstract class Person { // abstract 키워드를 사용하여 추상 클래스를 선언할 수 있다.
    abstract fun print() // 추상 메서드
}

class Student(val name: String, val age: Int) : Person() { // 추상 클래스를 상속받는 클래스
    override fun print() { // 추상 메서드를 구현한다.
        println("name: $name, age: $age")
    }
}

fun main() {
    val student = Student("홍길동", 20)
    student.print()
}
~~~
- abstract 키워드를 사용하여 추상 클래스를 선언할 수 있다.
- 추상 클래스를 상속받는 클래스는 추상 클래스의 추상 메서드를 구현해야 한다.
### 익명 클래스
~~~kotlin
fun main() {
    val person = object : Person { // object 키워드를 사용하여 익명 클래스를 만들 수 있다.
        override fun print() {
            println("익명 클래스")
        }
    }
    person.print()
}
~~~
- object 키워드를 사용하여 익명 클래스를 만들 수 있다.
## 배열
### 배열의 선언
~~~kotlin
fun main() {
    val arr1 = arrayOf(1, 2, 3) // arrayOf() 함수를 사용하여 배열을 만들 수 있다.
    
    val arr2 = arrayOfNulls<Int>(3) // arrayOfNulls() 함수를 사용하여 null로 초기화된 배열을 만들 수 있다.
    arr2[0] = 1
    arr2[1] = 2
    arr2[2] = 3

    val arr3 = Array(3, { i -> i + 1 }) // Array() 함수를 사용하여 배열을 만들 수 있다.
}
~~~
- arrayOf() 함수를 사용하여 배열을 만들 수 있다.
- arrayOfNulls() 함수를 사용하여 null로 초기화된 배열을 만들 수 있다.
- Array() 함수를 사용하여 배열을 만들 수 있다.
- Array() 함수는 배열의 크기와 람다식을 인자로 받는다.
- 람다식의 인자는 배열의 인덱스이다.
### 배열의 접근
~~~kotlin
fun main() {
    val arr = arrayOf(1, 2, 3)
    println(arr[0]) // 배열의 인덱스를 사용하여 배열의 요소에 접근할 수 있다.
    println(arr.get(0)) // get() 메서드를 사용하여 배열의 요소에 접근할 수 있다.
}
~~~
### 배열의 변경
~~~kotlin
fun main() {
    val arr = arrayOf(1, 2, 3)
    arr[0] = 4 // 배열의 인덱스를 사용하여 배열의 요소를 변경할 수 있다.
    arr.set(0, 4) // set() 메서드를 사용하여 배열의 요소를 변경할 수 있다.
}
~~~
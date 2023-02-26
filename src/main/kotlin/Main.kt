fun main(){
    var dog = Dog("guroom",12)
    dog.introduce1()
    dog.introduce()
    var a = Cake()
    a.eat()
    a.fresh()
    b(::ab)
    //함수를 넘겨줄 때 ::를 붙인다
    //(입력 타입)->반환 타입 = {변수이름: 입력타임 -> 구문}
    var c: (String)->Unit = {s ->println(s)}
    var d={s:String ->println(s)}
    var e={s:String ->s}
    var f={
        println("wewewe")
    }
    //인자가 하나일 경우 it으로 표현
    var g : (String)-> Unit = {println(it)}
    c("zxs")
    d("sss")
    println(e("dd"))
    f()
    g("ewewe")
    var book1 = Book("책",20000)
    book1.apply {
        name="apply $name"
        dc()
    }
    book1.printName()
    var book2 = Book("bok2",30000)
    var runBook = book2.run{
        name="run $name"
        dc()
        "return run"
    }
    print(runBook)
    var withBook = with(book2){
        name="with book $name"
        dc()
        "return with"
    }
    println(withBook)

    Counter.countUp()
    println(Counter.count)
    Counter.clear()
    println(Counter.count)
}
//상속
//open 키워드 있어야 상속 가능
open class Animal(val name: String,var age: Int, var type:String){
    open fun introduce(){
        println("${this.name} ${this.age} ${this.type}")
    }
}
class Dog(var name1:String, var age1: Int) : Animal(name1,age1,"강아지"){
    fun introduce1(){
        super.introduce()
    }
    override fun introduce() {
        println("hello")
    }
}
//추상클래스
abstract class Food{
    abstract fun fresh()
    fun eat(){
        println("냠냠")
    }
}
class Cake : Food(){
    override fun fresh() {
        println("쩝쩝")
    }
}
//고차함수
fun ab(str: String): String{
    return str
}
fun b(funs: (String)->String){
    println(funs("awds"))
}
//apply,run
class Book(var name:String,var price: Int){
    fun dc(){
        price -= 2000
    }
    fun printName(){
        println("$name $price")
    }
}
//object : 객체가 하나만 필요해서 사용하는 경우 : 싱글톤
object Counter{
    var count=0
    fun countUp(){
        count++
    }
    fun clear(){
        count=0
    }
}
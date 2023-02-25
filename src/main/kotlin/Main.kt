fun main(){


}
open class Animal(val name: String,var age: Int, var type:String){
    open fun introduce(){
        println("${this.name} ${this.age} ${this.type}")
    }
}
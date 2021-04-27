import java.util.Collections.list

fun main(){
    println("${string1} " + ", " + "${string2}")

    loop()
    loop2()
    range()

    println(defaultArgumentsFunction())
    println(defaultArgumentsFunction(2,5))
    println(defaultArgumentsFunction(y=10))

    printEven(1)
    printEven(*intArrayOf(1,50,150,250))

    moreArgs("Bob",toUpperCase = true)

    whenUsing (1)
    whenUsing ("Linar")

    collection()

    val h1 = Human("Tom","Hanks", 60)
    val h2 = Human("Tom","Hanks", 60)
    println(h1==h2)

    println(repeatIntercection(intArrayOf(1,3,2,4,1), intArrayOf(2,1,1,5,4)))

    println(countSymbols("AAAAAAABBBBBBBBCDEFFFFFFFFF"))

    println(grouping(arrayOf("eat","tea","tan","ate")))

    elvisAndNullPointer()
}

//---------------------------------------

val string1:String = "Hello"
val string2:String = "Linar"

//---------------------------------------

fun loop(){
    val items = listOf("apple", "banana", "orange")
    for (item in items)
        println(item)
}

//---------------------------------------

fun loop2(){
    val items = mutableListOf<Int>(10, 20, 30)
    var index = 0
    while (index < items.size) {
        println("Item at ${index} is ${items[index]}")
        index++
    }
}

//---------------------------------------

fun range(){
    for (i in 0..100 step 20)
        println(i)
}

//---------------------------------------

fun defaultArgumentsFunction(x:Int=1, y:Int=2):Int{
    return  x+y
}

//---------------------------------------

fun printEven(vararg operands:Int){
    operands.forEach { operand -> println(operand * 10) }
}

//---------------------------------------

fun moreArgs(name:String, surname:String = "Bobkins", toUpperCase:Boolean=false){
    if (toUpperCase)
        println(name.toUpperCase() +" "+ surname.toUpperCase())
}

//---------------------------------------

fun elvisAndNullPointer(){
    val a:String?
    a = if ((0..10).random() > 5) "String" else null
    val l = a?.length ?:-1
    val t =a!!.length
    println(l)
    println(t)
}

//---------------------------------------

fun whenUsing(argument:Any){
    when(argument){
        is Int -> println("Введено число " + argument)
        is String -> println("Введена строка " + argument + " длиной ${argument.length} символов")
        else -> print("Введен другой аргумент" + argument)
    }
}
//---------------------------------------


fun collection(){
    val a = listOf(1,2,3,4,5,6,7,8,9,10)
    a.forEach {elem -> println(elem)}
    println(a.map{ elem -> elem*2})
    println(a.filter { elem -> elem%2 ==0})
    println(a.reduce{sum, elem -> sum + elem})
    println(a.sortedByDescending { it })
    println(a.any{it>10})
    println(a.all{it<10})
    println(a.sum())

    val numbers = listOf(1,3,-6,8,-10,22)
    val(positive, negative) = numbers.partition { it > 0 }
    println(positive)
    println(negative)

    val items = listOf("a","b","ba", "ccc", "ad").groupBy { it.length }
    println(items)
}

//---------------------------------------

data class Human(val name: String, val surname: String, var age:Int ) {
    init {
        println("Human is Created: ${name}")
    }
}

//---------------------------------------

fun repeatIntercection(a1:IntArray, a2:IntArray):List<Int> {
    val s1 = a1.toHashSet()
    val s2 = a2.toHashSet()

    val result = mutableListOf<Int>()
    for (item in s1) {
        if (s2.contains(item)) {
            val numOfRepeats = minOf(a1.count { it == item }, a2.count { it == item })
            repeat(numOfRepeats) {
                result.add(item)
            }
        }
    }
    return result
}

//---------------------------------------

fun countSymbols(myString: String):String{
    var currentSymbol = myString[0]
    var count = 1
    var result = ""
    for (symbol in myString.substring(1)){
        if (currentSymbol == symbol){
            count++
        }
        else {
            if(count == 1){
                result+=currentSymbol
            }
            else{
                result+="$currentSymbol$count"
            }
            count = 1;
            currentSymbol = symbol
        }
    }
    if (count==1)
        result+=currentSymbol
    else
        result += "$currentSymbol$count"
    return result
}

//---------------------------------------

fun grouping(words:Array<String>):List<List<String>>{
    val result: MutableList<List<String>> = mutableListOf()

    val map = mutableMapOf<String,MutableList<String>>()
    for (word in words){
        val sortedWord = word.toCharArray().sorted().joinToString("")
        if (map.containsKey(sortedWord))
            map[sortedWord]?.add(word)
        else
            map[sortedWord] = mutableListOf(word)
    }
    for ((key,value) in map){
        result.add(value)
    }
    return result
}







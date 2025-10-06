import org.w3c.dom.ls.LSOutput

fun main() {

    val numPlanetasSisemaSolar:Int = 8
    var planeta = "tierra"

    println("El numero de planeras del siste solar es " +numPlanetasSisemaSolar)
    println("El planeta donde habitamos los humanos es "+planeta)
    planeta = "marte"
    println("El planeta de los marcianos es " +planeta)

    //Byte
    //Short
    //Int
    //Long
    //Float
    //Double
    //Boolean => true o false
    //Char => entre comillas siempre
    //...

    var numerito : Int = 4

    while(numerito <= 25){
        println(numerito)
        numerito++
    }

    for (i in 0..10){ //sin poner < o <= solo 0..10
        println(i)
    }

    for (i in 10 downTo  20){
        println(i)
    }

    for (i in 1..20 step 2){ //De 2 en 2
        println(i)
    }

    println("Introduce tu peso")
    val peso = readln().toInt()

    println("Introduce tu altura")
    val altura = readln().toInt()

    println("Introduce tu altura")
    val dia = readln().toInt()

    when{
        //Switch equivalente al de java, aqui no exise el switch
        peso > 90 && altura < 190 -> println("Apuntate al gym")
        peso < 60 && altura < 165 -> println("Come un poco")
        peso < 90 && altura < 195 -> println("Estas en forma")
        else -> println("Eres promedio")

    }

    when(dia) {

        1 -> println("lunes")
        2 -> println("martes")
        3 -> println("miercoles")
        else -> println("Ni lunes, ni martes, ni miercoles")
    }
}

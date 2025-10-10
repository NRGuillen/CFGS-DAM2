import org.w3c.dom.ls.LSOutput

fun main() {
    /*
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


    //AMBAS FUNCIONES SON EQUIVALENTES, AREACUADRADO SE EJECUTARIA COMO AREARECTANGULO
    fun areaRectangulo(alto: Int, ancho: Int): Int{
        return alto * ancho
    }
    fun areaCuadrado(lado : Int) = lado*lado

    println("Longitud del lado del cuadrado")
    var lado = readln().toInt()
    println("El area del cuadrado es " +areaCuadrado(lado))

    println()
    fun datosCurso(centro:String, titulacion: String = "DAM"){ //Como por defecto le meto una titulacion si no pongo nada se pone por defecto
        println("Cento:" +centro+ "  - Titulacion:" +titulacion)
    }

    println(datosCurso("Sando Domingo Savio"))
    println(datosCurso("Sando Domingo Savio", "TELECO"))


    fun costeKilometros(matriculaCoche:String, costeKilometro: Double, numeroDeKilometros : Double){
        var costeTotal = costeKilometro * numeroDeKilometros
        println("EL coste para la matricula $matriculaCoche es $costeTotal ")
    }

    println(costeKilometros("123456A", 3.4 , 956.6))

    var notaAlumnos : IntArray
    notaAlumnos = IntArray(4)
    for (i in 0..3){
        print("Mete la nota del $i alumno:")
        notaAlumnos[i] = readln().toInt()
    }

    println()
    println("Tamaño array "+notaAlumnos.size)
    for (i in 0..3){
        println(notaAlumnos[i])
    }
    */
    val pefe1 = Profesor("Ruben" , 32)
    println(pefe1.toString())
}

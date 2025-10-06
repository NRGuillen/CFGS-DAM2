import android.app.Person

class Persona(nombre:String, primerApellido:String, edad: Int) {

    var nombre = nombre
    var primerApellido = primerApellido
    var edad = edad
}



fun main(args: Array<String>) {
        val persona1 = Persona("Ruben", "Guillen", 20)
        println(persona1.nombre + " " +persona1.primerApellido+ " " +persona1.edad)
    }


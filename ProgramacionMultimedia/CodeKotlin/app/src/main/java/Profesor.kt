
class  Profesor constructor(nombre:String , edad: Int) {
    var nombre: String = nombre
    var edad: Int = edad


    override fun toString(): String {
        return "Nombre: " + nombre + " -Edad: " + edad
    }
}
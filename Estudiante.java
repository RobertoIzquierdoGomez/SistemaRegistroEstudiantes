import Excepts.EdadInvalidaException;
import Excepts.NombreInvalidoException;
import Excepts.CursoInvalidoException;

/**
 * Clase para los estudiantes
 */

public class Estudiante {
    private String name;
    private int age;
    private String course;

    /**
     * Constructor de la clase estudiante. Almacena su nombre(name), edad(age) y curso(course).
     * @param name
     * @param age
     * @param course
     */
    public Estudiante ( String name, int age, String course) throws NombreInvalidoException,EdadInvalidaException, CursoInvalidoException{

        if(name != ""){
            this.name = name;
        } else{
            throw new NombreInvalidoException("ERROR: El nombre no puede estar vacío.");
        }

        if(age >= 18 && age <= 65){
            this.age = age;
        } else {
            throw new EdadInvalidaException("ERROR: edad inválida.");
        }
        
        if(course.equals("Java") || course.equals("Python") || course.equals("Bases de Datos")){
            this.course = course;
        } else {
            throw new CursoInvalidoException("ERROR: El curso no existe.");
        }

    }

    //Setter y getter de name
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    //Setter y getter de age
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }

    //Setter y getter de course
    public void setCourse(String course){
        this.course = course;
    }
    public String getCourse(){
        return this.course;
    }
}

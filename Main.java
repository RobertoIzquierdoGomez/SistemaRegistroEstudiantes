import java.util.Scanner;

import Excepts.CursoInvalidoException;
import Excepts.EdadInvalidaException;
import Excepts.NombreInvalidoException;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = "";
        int age = 0;
        String course = "";
        RegistroEstudiantes register = new RegistroEstudiantes();
        int opcion = 0;

        do{
            System.out.println("\n***********************************************");
            System.out.println("\tREGISTRO DE ESTUDIANTES");
            System.out.println("***********************************************\n");
            System.out.println("\t1. Registrar nuevo estudiante");
            System.out.println("\t2. Mostrar lista de estudiantes");
            System.out.println("\t3. Guardar en archivo");
            System.out.println("\t4. Cargar desde archivo");
            System.out.println("\t5. Salir");
            System.out.print("\nElige una de las opciones: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    //Limpiamos buffer
                    sc.nextLine();
                    //Pedimos nombre
                    System.out.print("Ingresa un nombre: ");
                    name = sc.nextLine();

                    //Pedimos edad
                    System.out.print("Ingresa la edad: ");
                    age = sc.nextInt();

                    //Limpiamos buffer
                    sc.nextLine();
                    System.out.print("Ingresa uno de los cursos Java/Python/Bases de Datos: ");
                    course = sc.nextLine();

                    try{
                        register.registrarEstudiante(new Estudiante(name, age, course));
                        System.out.println("Has registrado correctamente a " + register.getStudenList().getLast().getName());
                    } catch(NombreInvalidoException nie) {
                        System.out.println(nie.getMessage());
                        nie.getStackTrace();
                    } catch(EdadInvalidaException eie) {
                        System.out.println(eie.getMessage());
                        eie.getStackTrace();
                    } catch(CursoInvalidoException cie) {
                        System.out.println(cie.getMessage());
                        cie.getStackTrace();
                    }
                    break;

                //Opcion para mostrar lista de estudiantes    
                case 2:
                    //imprime cuantops estudiantes hay
                    System.out.println("\nHay " + register.getStudenList().size() + " alumnos registrados");

                    //Bucle para recorrer la lista de estudiantes e ir mostrando sus nombres
                    for(int i = 0; i < register.getStudenList().size(); i++){
                        System.out.println("\t" + i + ". " + register.getStudent(i).getName());
                    }

                    break;
                
                case 3:
                    register.guardarEnArchivo(register);
                    break;
                case 4:
                    
                    register.cargarDesdeArchivo(register);

                    break;
                default:
                    System.out.println("Elige una de las opciones validas");
                    break;
            }
        } while(opcion != 5);

        sc.close();
    }
}

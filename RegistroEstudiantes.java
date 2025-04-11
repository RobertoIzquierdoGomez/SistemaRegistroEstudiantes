import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Excepts.CursoInvalidoException;
import Excepts.EdadInvalidaException;
import Excepts.NombreInvalidoException;

/**
 * Clase que almacena un registro de los estudiantes
 * Se almacenan en un ArrayList
 */

public class RegistroEstudiantes {
    private ArrayList<Estudiante> studentsList = new ArrayList<>();

    public RegistroEstudiantes(){

    }

    public ArrayList<Estudiante> getStudenList(){
        return studentsList;
    }

    public Estudiante getStudent(int a) {
        return studentsList.get(a);
    }

    public void registrarEstudiante(Estudiante e){
        studentsList.add(e);
    }

    public void guardarEnArchivo(RegistroEstudiantes r){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("estudiantes.txt"))) {
            for(int i = 0; i < r.getStudenList().size(); i++){
                bw.write(r.getStudent(i).getName() + ",");
                bw.write(String.valueOf(r.getStudent(i).getAge()) + ",");
                bw.write(r.getStudent(i).getCourse());
                bw.newLine();
            }
            System.out.println("******\n\tSe ha guardado correctamente el archivo ******");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
            ioe.getStackTrace();
        }
    }

    public void cargarDesdeArchivo(RegistroEstudiantes r){
        try (BufferedReader br = new BufferedReader(new FileReader("estudiantes.txt"))) {
            String text;
            while ((text = br.readLine()) != null) {
                String[] parts = text.split(",");
                try{
                    r.registrarEstudiante(new Estudiante(parts[0], Integer.parseInt(parts[1]), parts[2]));
                    System.out.println("Has registrado correctamente a " + r.getStudenList().getLast().getName());
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
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
            ioe.getStackTrace();
        }
    }

}

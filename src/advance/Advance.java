package advance;
import java.util.Scanner;

public class Advance {

    public static void main(String[] args) {
        PersonManagement personManagement = new PersonManagement("./Personas.txt");
        String lastname,firstname, address,city, dep;
        Scanner input = new Scanner(System.in);
        
        System.out.println("Registro de Personas\n\n");
        System.out.println("Ingrese el primer nombre: ");
        firstname = input.next();
        System.out.println("Ingrese el apellido: ");
        lastname = input.next();
        System.out.println("Ingrese la dirección: ");
        address = input.next();
        System.out.println("Ingrese la ciudad: ");
        city = input.next();
        System.out.println("Ingrese el departamento: ");
        dep = input.next();
        Person person = new Person(lastname, firstname, address, city, dep, 504);

        if (personManagement.getFile().exists()) { // Si el archivo existe, primero lo cargo.
            personManagement.loadFile(); // Pasa lo del ROM al ArrayList.
            
            personManagement.setPerson(person);


            personManagement.writeFile();
        } else { // Sino, lo creo y escribo en él.
            personManagement.setPerson(person);


            personManagement.writeFile();
        }
    }
}

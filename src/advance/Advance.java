package advance;

import java.util.Scanner;

public class Advance {

    public static void main(String[] args) {
        PersonManagement personManagement = new PersonManagement("./Personas.txt");
        String lastname, firstname, address, city, state;
        Scanner input = new Scanner(System.in);

        System.out.println("Registro de Personas\n\n");
        System.out.print("Ingrese el primer nombre: ");
        firstname = input.nextLine();
        System.out.print("Ingrese el apellido: ");
        lastname = input.nextLine();
        System.out.print("Ingrese la dirección: ");
        address = input.nextLine();
        System.out.print("Ingrese la ciudad: ");
        city = input.nextLine();
        System.out.print("Ingrese el departamento: ");
        state = input.nextLine();
        
        Person person = new Person(lastname, firstname, address, city, state, 504);

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

package advance;

public class Advance {

    public static void main(String[] args) {
        PersonManagement personManagement = new PersonManagement("./Personas.txt");

        Person person = new Person("García", "Ilich", "Col. Loma Linda Norte", "Tegucigalpa", "Francisco Morazán", 504);
        Person person1 = new Person("Mendoza", "Jerson", "Col. Venezuela", "Tegucigalpa", "Francisco Morazán", 504);

        if (personManagement.getFile().exists()) { // Si el archivo existe, primero lo cargo.
            personManagement.loadFile(); // Pasa lo del ROM al ArrayList.
            
            personManagement.setPerson(person);
            personManagement.setPerson(person1);

            personManagement.writeFile();
        } else { // Sino, lo creo y escribo en él.
            personManagement.setPerson(person);
            personManagement.setPerson(person1);

            personManagement.writeFile();
        }
    }
}

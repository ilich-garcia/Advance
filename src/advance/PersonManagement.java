package advance;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonManagement {

    private ArrayList<Person> peopleList = new ArrayList();
    private File file = null;

    public PersonManagement(String path) { // Manda de parámetro un String con la ruta del archivo.
        file = new File(path);
    }

    public ArrayList<Person> getPeopleList() {
        return peopleList;
    }

    public void setPeopleList(ArrayList<Person> peopleList) {
        this.peopleList = peopleList;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "PersonManagement{" + "peopleList=" + peopleList + '}';
    }

    public void setPerson(Person person) {
        this.peopleList.add(person);
    }

    public void writeFile() { // Pasa de RAM a ROM.
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter(file, false); // El false indica si se va a hacer append o no (mandarlo al final del archivo).
            bw = new BufferedWriter(fw);

            for (Person person : peopleList) {
                bw.write(person.getLastName() + ";");
                bw.write(person.getFirstName() + ";");
                bw.write(person.getAddress() + ";");
                bw.write(person.getCity() + ";");
                bw.write(person.getState() + ";");
                bw.write(person.getZipCode() + ";");
            }

            bw.flush();
        } catch (Exception ex) {
        } finally {
            try {
                bw.close();
            } catch (Exception ex) {
            }
        }
    }

    public void loadFile() {
        Scanner sc = null;
        peopleList = new ArrayList();

        try {
            sc = new Scanner(file);
            sc.useDelimiter(";");

            while (sc.hasNext()) {
                peopleList.add(new Person(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.nextInt()));
            }

        } catch (Exception ex) {
        } finally {
            sc.close();
        }
    }
}

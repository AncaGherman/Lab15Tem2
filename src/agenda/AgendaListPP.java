package agenda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaListPP {
    public static void main(String[] args) {
        List<Person> agenda = new ArrayList<>();
        Person p1 = new Person("ion", "072224654");
        Person p2 = new Person("maria", "0734543645");
        agenda.add(p1);
        agenda.add(p2);

        int n = 0;
        while (n != -1) {
            n = meniu();
            switch (n) {
                case 1:
                    adaugaNume(agenda);
                    break;
                case 2:
                    afiseazaAgenda(agenda);
                    break;
                case 3:
                    cautaNume(agenda);
                    break;
                case 4:
                    stergeNume(agenda);
                    break;
                case 5:
                    modifica(agenda);
                    break;
                case -1:
                    break;
                default:
                    System.out.println("Ati introdus gresit!");

            }
        }
    }

    public static int meniu() {
        System.out.println("Alegeti operatia in agenda:");
        System.out.println(" 1 - adaugare");
        System.out.println(" 2 - afisare");
        System.out.println(" 3 - cautare");
        System.out.println(" 4 - stergere");
        System.out.println(" 5 - modificare");
        System.out.println("-1 - pentru iesire");
        int nr = new Scanner(System.in).nextInt();
        return nr;
    }

    public static void adaugaNume(List agenda) {
        boolean gasit = false;
        System.out.print("Introduceti numele: ");
        String st1 = new Scanner(System.in).nextLine();

        for (int i = 0; i < agenda.size(); i++) {
            //System.out.println(((Person)agenda.get(i)).getNume());
            if (((Person) agenda.get(i)).getNume().equals(st1)) {
                gasit = true;
                System.out.println("Persoana mai exista deja, nu poate fi adaugata din nou!");
                break;
            }
        }
        if (gasit == false) {
            System.out.print("Introduceti nr de telefon: ");
            String st2 = new Scanner(System.in).nextLine();
            Person p = new Person(st1, st2);
            agenda.add(p);
            System.out.println("Persoana a fost adaugata in agenda!");
        }
    }

    public static void afiseazaAgenda(List agenda) {
        for (Object p : agenda) {
            System.out.println(p);
        }
    }

    public static int cautaNume(List agenda) {
        int index = -1;
        System.out.print("Introduceti numele: ");
        String st1 = new Scanner(System.in).nextLine();

        for (int i = 0; i < agenda.size(); i++) {
            if (((Person) agenda.get(i)).getNume().equals(st1)) {
                index = i;
                System.out.print("Persoana a fost gasita: ");
                System.out.println(agenda.get(i));
                break;
            }
        }
        if (index == -1) {
            System.out.println("Persoana nu a fost gasita!");
        }
        return index;
    }

    public static void stergeNume(List agenda) {
        int index = cautaNume(agenda);
        if (index != -1) {
            //System.out.println(agenda.get(index));
            agenda.remove(index);
            System.out.println("Persoana a fost stearsa!");
        }
    }

    public static void modifica(List agenda) {
        int index = cautaNume(agenda);
        if (index != -1) {
            //System.out.println(agenda.get(index));
            System.out.print("Introduceti numele nou: ");
            String stNume = new Scanner(System.in).nextLine();
            System.out.print("Introduceti telefonul nou: ");
            String stTel = new Scanner(System.in).nextLine();
            Person p = new Person(stNume,stTel);
            agenda.set(index,p);
            System.out.println("Datele persoanei au fost modificate!");
        }
    }
}

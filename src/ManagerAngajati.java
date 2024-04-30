import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerAngajati {
    private List<Angajat> angajati;
    private static final String FISIER = "angajati.txt";

    public ManagerAngajati() {
        angajati = new ArrayList<>();
        importaDateAngajati();
    }

    public void adaugaAngajat() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti informatiile pentru noul angajat:");

        System.out.print("Nume: ");
        String nume = scanner.nextLine();

        System.out.print("Prenume: ");
        String prenume = scanner.nextLine();

        System.out.print("Departament: ");
        String departament = scanner.nextLine();

        System.out.print("Salariu: ");
        double salariu = scanner.nextDouble();
        scanner.nextLine();

        int id = angajati.size() + 1;

        //adaugarea in lista
        Angajat angajatNou = new Angajat(id, nume, prenume, departament, salariu);
        angajati.add(angajatNou);

        System.out.println("Angajat adaugat cu succes!");
    }

    public void afiseazaAngajati() {
        System.out.println("Lista de angajati:");
        for (Angajat angajat : angajati) {
            System.out.println(angajat);
        }
    }

    public void afiseazaAngajatDupaID() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceti ID-ul angajatului: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Angajat angajat : angajati) {
            if (angajat.getId() == id) {
                System.out.println("Angajatul cu ID-ul " + id + " este:");
                System.out.println(angajat);
                return;
            }
        }
        System.out.println("Nu s-a gasit angajat cu ID-ul " + id);
    }

    public void actualizeazaAngajat() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceti ID-ul angajatului pentru actualizare: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Angajat angajat : angajati) {
            if (angajat.getId() == id) {
                System.out.println("Introduceti ce doriti sa actualizati pentru angajatul cu ID-ul " + id + ":");

                System.out.println("1. Nume");
                System.out.println("2. Prenume");
                System.out.println("3. Departament");
                System.out.println("4. Salariu");
                System.out.println("0. Inapoi");

                System.out.print("Alegeti optiunile dorite (separate prin virgula): ");
                String optiuni = scanner.nextLine();

                String[] optiuniSelectate = optiuni.split(",");
                for (String optiune : optiuniSelectate) {
                    switch (optiune.trim()) {
                        case "1":
                            System.out.print("Introduceti noul nume: ");
                            String nume = scanner.nextLine();
                            angajat.setNume(nume);
                            break;
                        case "2":
                            System.out.print("Introduceti noul prenume: ");
                            String prenume = scanner.nextLine();
                            angajat.setPrenume(prenume);
                            break;
                        case "3":
                            System.out.print("Introduceti noul departament: ");
                            String departament = scanner.nextLine();
                            angajat.setDepartament(departament);
                            break;
                        case "4":
                            System.out.print("Introduceti noul salariu: ");
                            double salariu = scanner.nextDouble();
                            angajat.setSalariu(salariu);
                            scanner.nextLine();
                            break;
                        case "0":
                            return;
                        default:
                            System.out.println("Optiune invalida: " + optiune);
                    }
                }
                System.out.println("Angajat actualizat cu succes!");
                return;
            }
        }
        System.out.println("Nu s-a gasit angajat cu ID-ul " + id);
    }

    public void stergeAngajat() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceti ID-ul angajatului pentru stergere: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Angajat angajat : angajati) {
            if (angajat.getId() == id) {
                angajati.remove(angajat);
                System.out.println("Angajatul cu ID-ul " + id + " a fost sters cu succes!");
                return;
            }
        }
        System.out.println("Nu s-a gasit angajat cu ID-ul " + id);
    }

    public void cautaAngajati() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceti criteriile de cautare (nume, prenume, departament, salariu): ");
        String criteriu = scanner.nextLine();

        boolean gasit = false;
        for (Angajat angajat : angajati) {
            if (angajat.contineCriteriu(criteriu)) {
                System.out.println(angajat);
                gasit = true;
            }
        }

        if (!gasit) {
            System.out.println("Nu s-au gasit angajati care sa corespunda criteriului introdus.");
        }
    }


    public void exportaDateAngajati() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FISIER))) {
            for (Angajat angajat : angajati) {
                writer.println(angajat.getId() + ";" + angajat.getNume() + ";" + angajat.getPrenume() + ";" +
                        angajat.getDepartament() + ";" + angajat.getSalariu());
            }
            System.out.println("Datele angajatilor au fost exportate cu succes!");
        } catch (IOException e) {
            System.out.println("A aparut o eroare la exportarea datelor angajatilor: " + e.getMessage());
        }
    }


    public void importaDateAngajati() {
        if (angajati.isEmpty()) {
            try (Scanner scanner = new Scanner(new File(FISIER))) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] parts = line.split(";");
                    int id = Integer.parseInt(parts[0]);
                    String nume = parts[1];
                    String prenume = parts[2];
                    String departament = parts[3];
                    double salariu = Double.parseDouble(parts[4]);

                    Angajat angajat = new Angajat(id, nume, prenume, departament, salariu);
                    angajati.add(angajat);
                }
                System.out.println("Datele angajatilor au fost importate cu succes!");
            } catch (FileNotFoundException e) {
                System.out.println("Fisierul nu a fost gasit: " + e.getMessage());
            }
        } else {
            System.out.println("Datele angajatilor au fost deja importate.");
        }
    }

}

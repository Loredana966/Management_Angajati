import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ManagerAngajati manager = new ManagerAngajati();
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("Meniu:");
                System.out.println("1. Adauga angajat");
                System.out.println("2. Afiseaza toti angajatii");
                System.out.println("3. Afiseaza un angajat dupa ID");
                System.out.println("4. Actualizeaza informatiile unui angajat");
                System.out.println("5. Sterge un angajat dupa ID");
                System.out.println("6. Cauta angajati dupa criterii");
                System.out.println("7. Exporta datele angajatilor in fisier");
                System.out.println("8. Importa datele angajatilor din fisier");
                System.out.println("0. Iesire");

                System.out.print("Alege optiunea: ");
                int optiune = scanner.nextInt();
                scanner.nextLine();

                switch (optiune) {
                    case 1:
                        manager.adaugaAngajat();
                        break;
                    case 2:
                        manager.afiseazaAngajati();
                        break;
                    case 3:
                        manager.afiseazaAngajatDupaID();
                        break;
                    case 4:
                        manager.actualizeazaAngajat();
                        break;
                    case 5:
                        manager.stergeAngajat();
                        break;
                    case 6:
                        manager.cautaAngajati();
                        break;
                    case 7:
                        manager.exportaDateAngajati();
                        break;
                    case 8:
                        manager.importaDateAngajati();
                        break;
                    case 0:
                        System.out.println("La revedere!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Optiune invalida! Va rugam sa incercati din nou.");
                }
            }
        } catch (Exception e) {
            System.out.println("A aparut o eroare: " + e.getMessage());
        }
    }
}
public class Angajat {
    private int id;
    private String nume;
    private String prenume;
    private String departament;
    private double salariu;

    public Angajat(int id, String nume, String prenume, String departament, double salariu) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.departament = departament;
        this.salariu = salariu;
    }

    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public double getSalariu() {
        return salariu;
    }

    public void setSalariu(double salariu) {
        this.salariu = salariu;
    }

    public boolean contineCriteriu(String criteriu) {
        return nume.contains(criteriu) ||
                prenume.contains(criteriu) ||
                departament.contains(criteriu) ||
                Double.toString(salariu).contains(criteriu);
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nume: " + nume + ", Prenume: " + prenume + ", Departament: " + departament + ", Salariu: " + salariu;
    }
}

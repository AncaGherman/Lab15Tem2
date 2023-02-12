package agenda;

public class Person {
    private String nume;
    private String tel;

    public Person(String nume, String tel) {
        this.nume = nume;
        this.tel = tel;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "nume='" + nume + '\'' +
                ", tel='" + tel + '\'';
    }
}

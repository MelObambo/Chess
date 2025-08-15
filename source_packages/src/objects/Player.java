package objects;

public class Player {
    private final int id;
    private String surname;
    private String firstname;

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Player(int id, String surname, String firstname) {
        this.id = id;
        this.surname = surname;
        this.firstname = firstname;
    }
}

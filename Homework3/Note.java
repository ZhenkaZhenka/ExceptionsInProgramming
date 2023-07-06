public class Note {
    public String lastname;
    public String name;
    public String patronymic;
    public long phone;

    public String getLastname() {
        return lastname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public long getPhone() {
        return phone;
    }

    public Note(String ln, String name, String patronymic, long phone) {
        this.lastname = ln;
        this.name = name;
        this.patronymic = patronymic;
        this.phone = phone;
    }
}

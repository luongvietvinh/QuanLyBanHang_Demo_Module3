package model;

public class User {
    private int id;
    private String userName;
    private String email;
    private String passsWord;

    public User(int id, String userName, String email, String passsWord) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.passsWord = passsWord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasssWord() {
        return passsWord;
    }

    public void setPasssWord(String passsWord) {
        this.passsWord = passsWord;
    }
}

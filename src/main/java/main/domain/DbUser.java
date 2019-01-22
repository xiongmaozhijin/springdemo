package main.domain;

public class DbUser {
    private Integer iduser;
    private String username;
    private String password;
    private int age;

    public DbUser() {
    }

    public DbUser(Integer iduser, String username, String password, int age) {
        this.iduser = iduser;
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "DbUser{" +
                "iduser=" + iduser +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}

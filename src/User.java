import java.util.ArrayList;

public class User {
    public int id;
    public String name;
    public String specialty;
    public int userType;
    public String username;
    public String password;

    public User() {
    }

    public User(int id, String name, String specialty, int userType, String username, String password) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.userType = userType;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specialty='" + specialty + '\'' +
                ", userType=" + userType +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

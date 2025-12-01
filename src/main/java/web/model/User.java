package web.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Pattern(regexp = "^[a-zA-Zа-яА-Я]+$", message = "[translate:Допустимы только буквы]")
    @NotEmpty(message = "[translate:Name should not be empty]")
    @Size(min = 2, max = 50, message = "[translate:Name should be between 2 and 50 characters]")
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Email(message = "[translate:Email should be valid]")
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    @Min(value = 1, message = "[translate:Возраст должен быть больше 0]")
    @Column(name = "age", nullable = false)
    private int age;

    public User() {
    }

    public User(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", Email='" + email + '\'' +
                ", Age='" + age + '\'' +
                '}';
    }

}

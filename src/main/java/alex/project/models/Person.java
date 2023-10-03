package alex.project.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Person {
    private int id;
    private String photo;

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return yearOfBirth == person.yearOfBirth && Objects.equals(fullName, person.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, yearOfBirth);
    }

    @NotEmpty(message = "name should not be empty")
    @Size(min = 2, max = 100, message = "name should between 2 and 100 symbols")
    private String fullName;
    @Min(value = 1900, message = "year of birth should be higher than 1900")
    private int yearOfBirth;

    public Person() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public Person(String fullName, int yearOfBirth, String image) {
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
        this.photo = image;

    }

    @Override
    public String toString() {
        return "id: " + id + "full name: " + fullName + "year of birth: " + yearOfBirth;
    }
}

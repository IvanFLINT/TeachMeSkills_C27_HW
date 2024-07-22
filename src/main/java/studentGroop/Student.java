package studentGroop;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Student {

    private Long id;

    @NotNull(message = "Требуется имя")
    @Size(min = 1, max = 10, message = "Имя должно содержать от 1 до 10 символов.")
    private String firstName;

    @NotNull(message = "Требуется фамилия")
    @Size(min = 1, max = 20, message = "Имя должно содержать от 1 до 20 символов.")
    private String lastName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

package sample.domain;

import javax.persistence.Entity;

/**
 * @author Andrii Duplyk
 *
 */
@Entity
public class Customer extends BaseEntity {

    private static final long serialVersionUID = -2982414019938242566L;

    private String firstName, lastName;

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

package ch.sascha.tbz.data.entity;

import ch.sascha.tbz.abstracts.AbstractEntity;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employment")
public class Employment extends AbstractEntity{

    @OneToMany(mappedBy = "person")
    private List<Person> people;

    private String employment;  //(nurse, doctor, cleaning crew, etc)

    public String getEmployment() {
        return employment;
    }

    public void setEmployment(String employment) {
        this.employment = employment;
    }
}

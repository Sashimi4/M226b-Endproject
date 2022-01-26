package ch.sascha.tbz.data.entity;

import ch.sascha.tbz.abstracts.AbstractEntity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

public class Employment extends AbstractEntity{

    @Id
    @GeneratedValue
    //@OneToMany(mappedBy = "")
    private Set<Integer> id;

    private String employment;  //(nurse, doctor, cleaning crew, etc)

    public String getEmployment() {
        return employment;
    }

    public void setEmployment(String employment) {
        this.employment = employment;
    }
}

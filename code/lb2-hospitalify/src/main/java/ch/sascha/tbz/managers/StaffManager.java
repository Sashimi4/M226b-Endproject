package ch.sascha.tbz.managers;

import ch.sascha.tbz.data.entity.Person;
import ch.sascha.tbz.pojo.StaffMember;

import java.util.ArrayList;

public class StaffManager {

    private ArrayList<Person> allStaffMembers;

    public StaffManager() {
        this.allStaffMembers = new ArrayList<>();
    }

    public ArrayList<Person> getAllStaffMembers() {
        return allStaffMembers;
    }
    public void setAllStaffMembers(ArrayList<Person> allStaffMembers) {
        this.allStaffMembers = allStaffMembers;
    }
}

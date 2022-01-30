package ch.sascha.tbz.managers;

import ch.sascha.tbz.data.entity.Person;
import java.util.ArrayList;

/**
 *  Class represents a manager object which contains a list of Staff Members
 */
public class StaffManager {

    /**
     * ArrayList containing all Staff members as Person objects
     */
    private ArrayList<Person> allStaffMembers;

    /**
     * Constructor of Staff manager
     *
     * Initialises ArrayList for all staff members
     */
    public StaffManager() {
        this.allStaffMembers = new ArrayList<>();
    }

    /**
     * Get ArrayList of all staff members
     * @return
     */
    public ArrayList<Person> getAllStaffMembers() {
        return allStaffMembers;
    }

    /**
     * Sets a new ArrayList objects
     * @param allStaffMembers       ArrayList using generics Person
     */
    public void setAllStaffMembers(ArrayList<Person> allStaffMembers) {
        this.allStaffMembers = allStaffMembers;
    }
}

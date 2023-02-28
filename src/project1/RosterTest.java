package project1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RosterTest {

    @Test
    void add() {
        International student = new International("John", "Doe", new Date("13/12/2003"), Major.CS, 25, true);
        Assertions.assertFalse(new Roster().add(student));

        student = new International("John", "Doe", new Date("07/12/2003"), Major.CS, 25, true);
        Assertions.assertTrue(new Roster().add(student));

        TriState newstudent = new TriState("John", "Doe", new Date("07/12/2003"), Major.CS, -25, "PA");
        Assertions.assertFalse(new Roster().add(newstudent));

        newstudent = new TriState("John", "Doe", new Date("07/12/2003"), Major.CS, 25, "NY");
        Assertions.assertTrue(new Roster().add(newstudent));
    }
}
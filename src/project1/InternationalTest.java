package project1;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class InternationalTest {

    @org.junit.jupiter.api.Test
    public void test_tuitionDue_internationalStudyAbroad() {
        International student = new International("John", "Doe", new Date("07/12/2003"), Major.CS, 25, true);
        Assertions.assertEquals(student.tuitionDue(12), 5918.00);
    }

    @org.junit.jupiter.api.Test
    public void test_tuitionDue_internationalNotStudyAbroad() {
        International student = new International("John", "Doe", new Date("07/12/2003"), Major.CS, 25, false);
        Assertions.assertEquals(student.tuitionDue(12), 35655.00);
    }
}
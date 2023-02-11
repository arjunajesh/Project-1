public enum Major {
    BAIT("BAIT", "33:136", "RBS"),
    CS("CS", "01:198", "SAS"),
    MATH("MATH", "01:640", "SAS"),
    ITI("ITI", "04:547", "SC&I"),
    EE("EE", "14:332", "SOE");

    private String majorName;
    private String majorCode;
    private String school;

    Major(String name, String code, String school) {
        this.majorName = name;
        this.majorCode = code;
        this.school = school;

    }

    public String getMajorName() {
        return this.majorName;
    }
}
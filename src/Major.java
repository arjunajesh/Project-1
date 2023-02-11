public enum Major {
    BAIT("BAIT"),
    CS("CS"),
    MATH("MATH"),
    ITI("ITI"),
    EE("EE");

    private String majorName;

    Major(String name) {
        majorName = name;
    }

    public String getMajorName() {
        return this.majorName;
    }
}
class Employee {

    // write fields
    private String name;
    private String email;
    private int experience;

    // write constructor
    protected Employee(String name, String email, int experience) {
        this.name = name;
        this.email = email;
        this.experience = experience;
    }

    // write getters
    protected String getName() {
        return name;
    }

    protected String getEmail() {
        return email;
    }

    protected int getExperience() {
        return experience;
    }

}

class Developer extends Employee {

    // write fields
    protected String mainLanguage;
    protected String[] skills;

    // write constructor
    protected Developer(String name, String email, int experience,
                        String mainLanguage, String[] skills) {
        super(name, email, experience);

        this.mainLanguage = mainLanguage;
        this.skills = skills;

    }

    // write getters
    protected String getMainLanguage() {
        return mainLanguage;
    }

    protected String[] getSkills() {
        return skills;
    }
}

class DataAnalyst extends Employee {

    // write fields
    protected boolean phd;
    protected String[] methods;

    // write constructor
    protected DataAnalyst(String name, String email, int experience,
                          boolean phd, String[] methods) {
        super(name, email, experience);

        this.phd = phd;
        this.methods = methods;
    }

    // write getters
    protected boolean isPhd() {
        return phd;
    }

    protected String[] getMethods() {
        return methods;
    }
}
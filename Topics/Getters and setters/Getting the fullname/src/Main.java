
class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        if (firstName != null && !firstName.isBlank()) {
            this.firstName = firstName;
        }
        // write your code here
    }

    public void setLastName(String lastName) {
        // write your code here
        if (lastName != null && !lastName.isBlank()) {
            this.lastName = lastName;
        }
    }

    public String getFullName() {
         return (firstName.isEmpty() && lastName.isEmpty()) ? "Unknown" : (firstName + " " + lastName).trim();
        // write your code here
    }
}
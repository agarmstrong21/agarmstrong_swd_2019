public class Employee {
    private static int numberOfEmployees = 0;
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;

    public Employee (String firstName, String lastName, String socialSecurityNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;

        numberOfEmployees++;
    }

    // return first name
    public String getFirstName() {
        return firstName;
    }

    // return last name
    public String getLastName() {
        return lastName;
    }

    // return social security number
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    // return String representation of CommissionEmployee object
    @Override
    public String toString() {
        return String.format("%s%d%s%n%s: %s %s%n%s: %s%n",
                "*********** Employee (Count = ", numberOfEmployees,") ***********",
                "Employee Name", getFirstName(), getLastName(),
                "Social Security Number", getSocialSecurityNumber());
    }
}

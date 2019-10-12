/*
Name: Addison Armstrong
Name of Project: S31_RequestInheritance_Medium
Name of Class: Form
Class Description: A class where Form data is stored. Form takes in a HashMap of Strings that contains labels and Values
 */

// Adding this file into the package of RequestInheritance and accessing any files inside of this package
package RequestInheritance;

// Imported classes used for the toString method
import java.util.HashMap;
import java.util.Map;

// Creating the Form Class
/** A class where Form data is stored. Form takes in a HashMap of Strings that contains labels and Values*/
public class Form {

    // Private Static Varaible fields that contains a HashMap constructed of Strings
    private static HashMap<String, String> fields;

    // Form Constructor
    public Form(HashMap<String, String> fields) {
        Form.fields = fields;
    }

    // Overrided toString method
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("\nForm Data");
        for (Map.Entry<String,String> entry : fields.entrySet()) {
            out.append("\nLabel: ").append(entry.getKey()).append("\nValue: ").append(entry.getValue());
        }
        return out.toString();
    }
}

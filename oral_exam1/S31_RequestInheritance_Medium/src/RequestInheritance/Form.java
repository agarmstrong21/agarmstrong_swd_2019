package RequestInheritance;



import java.util.HashMap;
import java.util.Map;

public class Form {
    private static HashMap<String, String> fields;

    public Form(HashMap<String, String> fields) {
        Form.fields = fields;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("\nForm Data");
        for (Map.Entry<String,String> entry : fields.entrySet()) {
            out.append("\nLabel: ").append(entry.getKey()).append("\nValue: ").append(entry.getValue());
        }
        return out.toString();
    }
}

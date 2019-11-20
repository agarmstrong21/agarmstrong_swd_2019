import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.awt.event.ActionListener;


public class myController {
    myModel model = new myModel();

    @FXML
    private Label result;

    @FXML
    public void numberButtonPressed (ActionEvent event){
        String value = ((Button) event.getSource()).getText();

        if("0".equals(result.getText())){
            result.setText(value);
        } else{
            result.setText(result.getText() + value);
        }
    }

    @FXML
    private void operationButtonPressed (ActionEvent event){
        String value = ((Button) event.getSource()).getText();
        if(!(value.equals("="))){
            model.setNumber1(Double.parseDouble(result.getText()));
            result.setText("0");
            model.setOperator(value);
        }else{
            String resultFromModel = model.compute();
            result.setText(resultFromModel);
        }
    }
}

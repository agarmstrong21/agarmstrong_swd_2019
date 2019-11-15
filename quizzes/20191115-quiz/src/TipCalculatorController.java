import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class TipCalculatorController {

    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
    private static final NumberFormat percent = NumberFormat.getPercentInstance();
    private BigDecimal tipPercentage = new BigDecimal(.15);



    @FXML
    private Label TipLabel;

    @FXML
    private Button Calculate;

    @FXML
    private Slider Tip;


    @FXML
    private TextField Amount;

    @FXML
    private TextField TipText;

    @FXML
    private TextField Total;

    @FXML
    private void calculateButtonPressed (ActionEvent event){
        try{
            BigDecimal amount = new BigDecimal(Amount.getText());
            BigDecimal tip = amount.multiply(tipPercentage);
            BigDecimal total = amount.add(tip);
            TipText.setText(currency.format(tip));
            Total.setText(currency.format(total));
        }catch(NumberFormatException e){
            Amount.setText("Enter Amount:");
            Amount.selectAll();
        }
    }

    @FXML
    public void initialize(){
        currency.setRoundingMode(RoundingMode.HALF_UP);
    }


}

public class myModel {

    private double number1;
    private double number2;
    private String operator;

    public void setNumber1(double n1){
        number1 = n1;
    }
    public void setNumber2(double number2) {
        this.number2 = number2;
    }
    public void setOperator(String op){
        operator = op;
    }

    public String compute(){
        String ret = "";
        double result;
        if(operator.equals("+")){
            ret = Double.toString( number1+number2);
        } else if(operator.equals("*")){
            ret = Double.toString( number1*number2);
        }else if(operator.equals("-")){
            ret = Double.toString( number1-number2);
        }else if(operator.equals("/")){
            if(number2==0){
                  System.err.print("Division Error");
                  return "Div by 0";
            }
            ret = Double.toString( 0);
        }else if (operator.equals("x^2")){
            ret = Double.toString( Math.pow(number1, 2));
        }else if (operator.equals("sin")){
            ret = Double.toString( Math.sin(number1));
        }else if (operator.equals("cos")){
            ret = Double.toString( Math.cos(number1));
        }else if (operator.equals("tan")){
            ret = Double.toString( Math.tan(number1));
        }else{
            System.err.print("Unknown Operator");
            ret = Double.toString( 0);
        }
        return ret;
    }
}

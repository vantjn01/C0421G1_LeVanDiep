package bean;

public class Calculator {
//    public Calculator{
//
//    }
    public static float calculate(float num1, float num2, String op) {
        switch (op){
            case "Addition":
                return num1+ num2;
            case "Subtraction":
                return num1 - num2;
            case "Multiplication":
                return num1 * num2;
            case "Division":
                if (num2==0){ throw new RuntimeException(" Are you kidding me");
                } else {
                    return num1/num2;

                }
            default:throw new RuntimeException("Lỗi rồi");
        }

    }
}

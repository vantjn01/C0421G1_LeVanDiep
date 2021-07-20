package _19_String_Regex.bai_tap;



public class PhoneTest {
    private static final String[] validNumber = {"(84)-(0978489648)", "(64)-(0238488888)"};

    public static void main(String[] args) {
        Phone phoneNumber = new Phone();
        for (String number : validNumber) {
            boolean isValid = phoneNumber.validate(number);
            System.out.println("Phone Number " + number + " is valid: " + isValid);
        }


    }

}
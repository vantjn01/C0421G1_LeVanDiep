package _19_String_Regex.bai_tap;

public class Main {
    private static ClassExample classExample;
    public static final String[] validName = new String[] {"C0421G"};
    public static final String[] invalidName = new String[] {"C0421G1", "P0323A"};

    public static void main(String[] args) {
        classExample = new ClassExample();
        for (String name: validName) {
            boolean isvalid = classExample.validate(name);
            System.out.println("Name is "+name+" is valid: "+isvalid);
        }
        for (String name: invalidName) {
            boolean isvalid = classExample.validate(name);
            System.out.println("Name is "+name+" is valid: "+isvalid);
        }
    }

}

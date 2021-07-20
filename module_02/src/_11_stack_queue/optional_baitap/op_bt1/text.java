package _11_stack_queue.optional_baitap.op_bt1;

import static _11_stack_queue.optional_baitap.op_bt1.CheckBracket.checkBracket;

public class text {
    public static void main(String[] args) {
        System.out.println( checkBracket("s * (s – a) * (s – b) * (s – c)"));
        System.out.println( checkBracket("(– b + (b2 – 4*a*c)^0.5) / 2*a"));
        System.out.println( checkBracket("s * (s – a) * (s – b * (s – c)"));
        System.out.println( checkBracket("s * (s – a) * s – b) * (s – c)"));
        System.out.println(checkBracket("(– b + (b^2 – 4*a*c)^(0.5/ 2*a)) "));
    }
}

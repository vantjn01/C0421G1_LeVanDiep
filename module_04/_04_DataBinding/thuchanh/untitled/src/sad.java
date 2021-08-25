public class sad {
    public static void main(String[] args) {
        int[] ints = {0,2,4,4,5,8,7,6};
        int[] result = new int[ints.length];
        int a =0;
        for (byte i=0; i< ints.length -1; i++){
            if ((ints[i]+ints[i+1])%2 == 0){
                result[a] = ints[i];
                result[a+1] = ints[i+1];
                a++;
            }
        }
//
        for (byte i=0; i<a ;){
//            if (result[i]== 0 && result[i+1]==0){
//                continue;
//            }
            System.out.println(result[i] +"va" + result[i+1]);
            i+=1;
        }
    }
}

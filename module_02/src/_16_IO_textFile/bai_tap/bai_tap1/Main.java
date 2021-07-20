package _16_IO_textFile.bai_tap.bai_tap1;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        String pathOriginal = "H:\\C0421G1_LeVanDiep\\module_02\\src\\_16_IO_textFile\\original.txt";
        String pathClone = "H:\\C0421G1_LeVanDiep\\module_02\\src\\_16_IO_textFile\\clone.txt";
        File original;
        File cloneOriginal;

        try {
            original = new File(pathOriginal);
            if (!original.exists()){
                original.createNewFile();
            }
            cloneOriginal = new File(pathClone);
            if (!cloneOriginal.exists()){
                cloneOriginal.createNewFile();
            }
            CopyFileText.copyFile(original, cloneOriginal);
            System.out.println("Successful!");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

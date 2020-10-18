import java.io.File;
import java.util.Scanner;

public class DirectorySize {

    public static void main(String[] args){
        System.out.print("Masukkan direktori atau file = " );
        Scanner scanner = new Scanner(System.in);
        String direktori = scanner.nextLine();

        System.out.println(getSize(new File(direktori)) + " byte");

    }

    private static long getSize(File file) {
        long kapasitas = 0;

        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(int a = 0; a < files.length; a++){
                kapasitas += getSize(files[a]);
            }
        }else {
            kapasitas += file.length();
        }
        return kapasitas;
    }
}

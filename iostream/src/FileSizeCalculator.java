import java.io.File;
import java.util.Scanner;

public class FileSizeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập đường dẫn của file:");
        String filePath = scanner.nextLine();
        File file = new File(filePath);


        if (file.exists()) {
            if (file.isFile()) {
                long fileSize = file.length();
                System.out.println("Độ lớn của file là: " + fileSize + " bytes");
            } else {
                System.out.println("Đường dẫn không trỏ đến file.");
            }
        } else {
            System.out.println("File không tồn tại.");
        }

        scanner.close();
    }
}

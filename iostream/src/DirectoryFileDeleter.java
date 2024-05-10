import java.io.File;
import java.util.Scanner;

public class DirectoryFileDeleter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập đường dẫn của thư mục hoặc file để xoá:");
        String pathToDelete = scanner.nextLine();
        File fileToDelete = new File(pathToDelete);

        if (fileToDelete.exists()) {
            if (fileToDelete.isDirectory()) {
                deleteDirectory(fileToDelete);
            } else {
                boolean deleted = fileToDelete.delete();
                if (deleted) {
                    System.out.println("Xoá file thành công.");
                } else {
                    System.out.println("Không thể xoá file.");
                }
            }
        } else {
            System.out.println("Thư mục hoặc file không tồn tại.");
        }

        scanner.close();
    }

    public static void deleteDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteDirectory(file);
                } else {
                    boolean deleted = file.delete();
                    if (!deleted) {
                        System.out.println("Không thể xoá file: " + file.getAbsolutePath());
                    }
                }
            }
        }
        boolean deleted = directory.delete();
        if (deleted) {
            System.out.println("Xoá thư mục thành công.");
        } else {
            System.out.println("Không thể xoá thư mục: " + directory.getAbsolutePath());
        }
    }
}

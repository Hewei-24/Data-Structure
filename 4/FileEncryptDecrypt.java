import java.io.*;

public class FileEncryptDecrypt {
    public static void encryptFile(String srcPath, String destPath, char key) throws IOException {
        processFile(srcPath, destPath, key);
    }

    public static void decryptFile(String srcPath, String destPath, char key) throws IOException {
        processFile(srcPath, destPath, key);
    }

    private static void processFile(String srcPath, String destPath, char key) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(srcPath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(destPath))) {
            int ch;
            while ((ch = br.read()) != -1) {
                bw.write(ch ^ key);
            }
        }
    }

    public static void main(String[] args) {
        try {
            encryptFile("test.txt", "testencrypt.txt", 'k');
            decryptFile("testencrypt.txt", "testdecrypt.txt", 'k');
            System.out.println("加密解密完成");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package fileDecryption;

public class Main {
    private static String pathWithFiles = "D:\\jet";

    public static void main(String[] args) {
        FileTypeChanger fileTypeChanger = new FileTypeChanger();
        fileTypeChanger.change(pathWithFiles);
    }
}

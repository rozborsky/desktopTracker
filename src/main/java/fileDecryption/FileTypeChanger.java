package fileDecryption;

import java.io.File;

public class FileTypeChanger {
    public void change(String pathWithFiles) {
        File folder = new File(pathWithFiles);
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                change(fileEntry.getAbsolutePath());
            } else {
                String oldName = fileEntry.getName();
                File newFile = new File(pathWithFiles + "\\" + oldName.substring(0, oldName.indexOf(".")) + ".jpeg");
                fileEntry.renameTo(newFile);
            }
        }
    }
}

package ua.rozborsky.desktopTracker;

import java.io.File;
import java.util.Arrays;

public class FolderManager {
    /**
     * folder for collecting folders with screenshots
     */
    private String rootFolderPath = "C:\\testfolder";

    /**
     * folder for collecting screenshots
     */
    private String sessionFolderPath = "";
    private TimeManager timeManager = new TimeManager();

    /**
     * delete old and create new folders
     */
    public void arrangeFolders() {
        sessionFolderPath = rootFolderPath + "\\" + timeManager.getDate();
        deleteOldFolders();
        createRootFolder();
        createSessionFolder();
    }

    /**
     * check is folder exist
     * @param   folderName name of the folder
     * @return  boolean value is current folder exist
     */
    private boolean isFolderExist(String folderName) {
        File folder = new File(folderName);
        return folder.exists() && folder.isDirectory()
                ? true
                : false;
    }

    /**
     * create main folder of program
     */
    private void createRootFolder() {
        createFolder(rootFolderPath);
    }

    /**
     * create folder for collects creenshots in current day
     */
    private void createSessionFolder() {
        createFolder(sessionFolderPath);
    }

    /**
     * create folder
     * @param path  path of new folder
     */
    private void createFolder(String path) {
        if(!isFolderExist(path)) {
            new File(path).mkdir();
        }
    }

    /**
     * delete folders older 10 day
     */
    private void deleteOldFolders() {
        File folder = new File(rootFolderPath);
        File[] folders = folder.listFiles();

        if (folders.length > 10) {
            File[] foldersToDelete = Arrays.copyOfRange(folders, 0, folders.length - 10);
            for(File folderToDelete: foldersToDelete){
                folderToDelete.delete();
            }
        }
    }

    public String getSessionFolderPath() {
        return sessionFolderPath;
    }
}

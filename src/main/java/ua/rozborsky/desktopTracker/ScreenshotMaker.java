package ua.rozborsky.desktopTracker;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ScreenshotMaker {
    /**
     * pause between screenshots
     */
    private int minutes = 1;

    /**
     * size Reduction of image
     */
    private int sizeReduction = 2;

    /**
     * makes screenshots
     */
    public void makeScreenshots() {
        while(true) {
            pause();
            FolderManager folderManager = new FolderManager();
            folderManager.arrangeFolders();
            makeScreenShot(folderManager.getSessionFolderPath());
        }
    }

    /**
     * makes screenshot and save it in the folder
     * @param sessionFolderPath     folder for collect screenshots current day
     */
    private void makeScreenShot(String sessionFolderPath) {
        TimeManager timeManager = new TimeManager();
        try {
            BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            image = resize(image, sizeReduction);
            ImageIO.write(image, "jpeg", new File(sessionFolderPath + "\\" + timeManager.getTimeHhMm() + ".rre"));
        } catch (AWTException | IOException e) {
            //do nothing
        }
    }

    /**
     * reduces the image
     * @param img               the image to be reduced
     * @param sizeReduction     size reduction
     * @return diminished image
     */
    private static BufferedImage resize(BufferedImage img, int sizeReduction) {
        int newWidth = img.getWidth() / sizeReduction;
        int newHeight = img.getHeight() / sizeReduction;
        Image tmpImage = img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.SCALE_SMOOTH);

        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(tmpImage, 0, 0, null);
        g2d.dispose();

        return resizedImage;
    }

    /**
     * pause program in few minutes
     */
    private void pause() {
        try {
            Thread.sleep(minutes * 60 * 1000);
        } catch (InterruptedException e) {
           //do nothing
        }
    }
}

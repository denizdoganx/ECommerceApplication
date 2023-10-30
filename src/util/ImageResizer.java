package util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageResizer {

	
    public static void resizeImage(String inputFile, String outputFile, int targetWidth, int targetHeight) {
        try {
        
        	File input = new File(inputFile);
        	File output = new File(outputFile);
        	
        	if(!input.exists() || !output.exists()) {
                BufferedImage originalImage = ImageIO.read(input);
                BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = resizedImage.createGraphics();
                g2d.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
                g2d.dispose();
                ImageIO.write(resizedImage, "jpg", output);
                //System.out.println("Resim başarıyla sıkıştırıldı ve kaydedildi.");
        	}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

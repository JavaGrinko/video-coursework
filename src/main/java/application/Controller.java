package application;

import org.jcodec.api.FrameGrab;
import org.jcodec.api.JCodecException;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.SeekableByteChannel;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Author Grinch
 * Date: 07.10.14
 * Time: 22:36
 */
public class Controller {
    private static Controller ourInstance = new Controller();

    public static Controller getInstance() {
        return ourInstance;
    }

    private Controller() {
    }

    public static void main(String[] args){
        //MainWindow main = new MainWindow();
        //main.setVisible(true);
        int i = 0;
        long startTime = System.currentTimeMillis();
        try {
            SeekableByteChannel sbc = NIOUtils.readableFileChannel(new File("src/main/resources/cars.mp4"));
            FrameGrab grab = new FrameGrab(sbc);
           // grab.seek(startSec);
            BufferedImage frame;
            for (; true; i++) {
                try{
                    frame = grab.getFrame();
                }catch (Exception e){
                    System.out.println("Frames are out");
                    break;
                }

                //ImageIO.write(frame, "png",
                //        new File(String.format("src/main/resources/frames/frame_%08d.png", i)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JCodecException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime/1000. +"s "+i+ " frames");
    }
}

package Task_3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * Created by Mihail on 09.04.2017.
 */
public class App {
    public static void main(String[] args) {

    }


    public static String photoType(String path) throws IOException {
        if(isBMP(path)) {
            return "BMP";
        }
        if(isGIF(path)) {
            return "GIF";
        }
        if(isJPEG(path)) {
            return "JPEG";
        }
        if(isPNG(path)) {
            return "PNG";
        }
        return "unknown format";
    }

    public static boolean isGIF (String str) throws IOException {
        final byte[] GIFFIRSTBYTES = {71,73,70,56,57,97};
        File file = new File(str);

        if(file.isFile()) {
            byte[] ar = new byte[6];

            try (InputStream iS = new FileInputStream(file)) {
                iS.read(ar,0, 6);
                iS.close();
                if(Arrays.equals(ar,GIFFIRSTBYTES)) {
                    return true;
                }
            } catch (IOException ex) {
                throw new IOException("Ошибка работы с файлом");
            }

        } else {
            throw new IllegalArgumentException();
        }

        return false;
    }

    public static boolean isJPEG(String str) throws IOException {
        final byte[] JPEGFIRSTBYTES = {-1,-40,-1,-32,0,16,74,70};
        File file = new File(str);

        if(file.isFile()) {
            byte[] ar = new byte[8];

            try (InputStream iS = new FileInputStream(file)) {
                iS.read(ar,0, 8);
                iS.close();
                if(Arrays.equals(ar,JPEGFIRSTBYTES)) {
                    return true;
                }
            } catch (IOException ex) {
                throw new IOException("Ошибка работы с файлом");
            }

        } else {
            throw new IllegalArgumentException();
        }

        return false;
    }

    public static boolean isPNG(String str) throws IOException {
        final byte[] PNGFIRSTBYTES = {-119,80,78,71,13,10,26,10};
        File file = new File(str);

        if(file.isFile()) {
            byte[] ar = new byte[8];

            try (InputStream iS = new FileInputStream(file)) {
                iS.read(ar,0, 8);
                iS.close();
                if(Arrays.equals(ar,PNGFIRSTBYTES)) {
                    return true;
                }
            } catch (IOException ex) {
                throw new IOException("Ошибка работы с файлом");
            }

        } else {
            throw new IllegalArgumentException();
        }

        return false;
    }

    public static boolean isBMP (String str) throws IOException {
        final byte[] BMPFIRSTBYTES = {66,77};
        File file = new File(str);

        if(file.isFile()) {
            byte[] ar = new byte[2];

            try (InputStream iS = new FileInputStream(file)) {
                iS.read(ar,0, 2);
                iS.close();
                if(Arrays.equals(ar,BMPFIRSTBYTES)) {
                    return true;
                }
            } catch (IOException ex) {
                throw new IOException("Ошибка работы с файлом");
            }

        } else {
            throw new IllegalArgumentException();
        }

        return false;
    }
}

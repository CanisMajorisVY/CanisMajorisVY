package fileManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

/**
 * Created by Mihail on 09.04.2017.
 */
public class FileManager {

    private File dir;

    public FileManager() {
        dir = new File(System.getProperty("user.home"));
    }

    public File currentDirecrory(){
        return dir;
    }

    public String toStringFilesInCurrentDirectory(boolean q1, boolean q2) throws FIleManagerExeption {
        try {
            if (!(q1)) {
                if (dir.isDirectory()) {
                    String str = "";
                    File[] fileList = dir.listFiles();
                    for (int i = 0; i < fileList.length; i++) {
                        if (fileList[i].isFile()) {
                            if (!fileList[i].isHidden() || q2) {
                                str += fileList[i].getName() + "\n";
                            }
                        }
                    }
                    return str;
                }
            } else {
                if (dir.isDirectory()) {
                    File[] fileList = dir.listFiles();
                    String str = "";
                    for (int i = 0; i < fileList.length; i++) {
                        if (fileList[i].isFile()) {
                            if (!fileList[i].isHidden() || q2) {
                                if (fileList[i].canRead()) {
                                    str += "r";
                                }
                                if (fileList[i].canWrite()) {
                                    str += "w";
                                }
                                if (fileList[i].canExecute()) {
                                    str += "x";
                                }

                                str += " ";

                                long x = Files.size(fileList[i].toPath());
                                int j = 0;

                                while (x > 1024) {
                                    x = x / 1024;
                                    j++;
                                }

                                str += x + " ";

                                switch (j) {
                                    case 0:
                                        str += "байт ";
                                        break;
                                    case 1:
                                        str += "кб ";
                                        break;
                                    case 2:
                                        str += "мб ";
                                        break;
                                    case 3:
                                        str += "гб ";
                                        break;
                                    default:
                                        str += "";
                                        break;
                                }

                                str += Files.getOwner(fileList[i].toPath()).toString() + " ";

                                str += fileList[i].getName() + "\n";
                            }
                        }
                    }
                    return str;
                }
            }
        } catch (IOException ex) {
            throw new FIleManagerExeption("Ошибка с файлом");
        }
        return "";
    }

    public void cd(File file) throws  FIleManagerExeption{
        try {
            if (file.isAbsolute()) {
                if (file.isDirectory()) {
                    dir = file;
                } else {
                    throw new IllegalArgumentException();
                }
            } else {
                file = new File(file.getAbsolutePath());
                if (file.isDirectory()) {
                    dir = file;
                } else {
                    throw new IllegalArgumentException();
                }
            }
        } catch (Exception ex) {
            throw new FIleManagerExeption(ex.getMessage());
        }
    }

    public void cd() {
        dir = new File(System.getProperty("user.home"));
    }

    public void rm (boolean q1) {
        if(!(q1)){
            File[] fileList = dir.listFiles();
            for(File file: fileList) {
                if(file.isFile()){
                    file.delete();
                } else {
                    if(file.isDirectory() && !isFilesInside(file)){
                        file.delete();
                    }
                }
            }
        } else {
            rmRec(dir);
        }
    }

    private void rmRec(File file) {
        File[] fileList = file.listFiles();
        for(File f: fileList){
            if(f.isFile()){
                f.delete();
            } else {

                if(f.isDirectory() && isFilesInside(f)){
                    System.out.print("Delete files inside: " + f.getName() + " ? (y/n)");
                    String str = new Scanner(System.in).next();
                    if(str.equals("y")){
                        rmRec(f);
                    }

                    if(!isFilesInside(f)){
                        f.delete();
                    }

                }
            }
        }

    }

    private void rmAll(File file){
        File[] fileList = file.listFiles();
        for(File f: fileList) {
            f.delete();
        }
    }

    public void rmAll(){
        File[] fileList = dir.listFiles();
        for(File f: fileList) {
            f.delete();
        }
    }

    public void move(File file1, File file2) throws FIleManagerExeption {
        try {
            if (file1.isFile() && file2.getParentFile().isDirectory()) {
                Files.move(file1.toPath(), file2.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException ex){
            throw  new FIleManagerExeption("Ошибка в названии файлов");
        } catch (IOException ex) {
            throw new FIleManagerExeption("Ошиюка перемещения");
        }
    }

    public void copy(File file1, File file2) throws FIleManagerExeption {
        try {
            if (file1.isFile() && file2.getParentFile().isDirectory()) {
                Files.copy(file1.toPath(), file2.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException ex){
            throw  new FIleManagerExeption("Ошибка в названии файлов");
        } catch (IOException ex) {
            throw new FIleManagerExeption("Ошиюка перемещения");
        }
    }


    private boolean isFilesInside(File file){
        File[] fileList = file.listFiles();
        for(File f: fileList){
            if(f.isFile()) {
                return true;
            } else {
                if(f.isDirectory()){
                    return isFilesInside(f);
                }
            }
        }
        return false;
    }

}

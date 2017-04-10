import UI.*;
import fileManager.FIleManagerExeption;
import fileManager.FileManager;

import java.io.File;
import java.util.Arrays;

/**
 * Created by Mihail on 14.02.2017.
 */

public class App extends Application {

    protected UserInteractor terminal;
    FileManager fileManager;

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        App app = new App(args);
    }

    public App(String[] args) {
        super(args);
    }

    @Override
    public void init() {
        try {
            this.terminal = new ConsoleUserInteractor();
            fileManager = new FileManager();
        } catch (UserInteractorException ex) {
            System.out.println("Couldn't start application due error:");
            System.err.println(ex.getMessage());
            System.exit(1);
        }
    }

    @Override
    public void start() {
        try {
            String command;
            while ((command = this.terminal.readCommand()) != null) {
                switch (command) {
                    case "exit":
                        this.terminal.print("Bye");
                        System.exit(0);
                        break;

                    case "ls":
                        this.terminal.print(fileManager.toStringFilesInCurrentDirectory(false, false));
                        break;

                    case "ls -l":
                        this.terminal.print(fileManager.toStringFilesInCurrentDirectory(true, false));
                        break;

                    case "ls -a":
                        this.terminal.print(fileManager.toStringFilesInCurrentDirectory(false, true));
                        break;

                    case "ls -la":
                        this.terminal.print(fileManager.toStringFilesInCurrentDirectory(true, true));
                        break;

                    case "cd":
                        this.terminal.print("Write path: ");
                        command = terminal.readCommand();
                        File f = new File(command);
                        this.fileManager.cd(f);
                        break;

                    case "cd ~":
                        this.fileManager.cd();
                        break;

                    case "rm":
                        this.fileManager.rm(false);
                        break;

                    case "rm -r":
                        this.fileManager.rm(true);
                        break;

                    case "rm -r -F":
                        this.fileManager.rmAll();
                        break;

                    case "mv": {
                            this.terminal.print("Write path to first file: ");
                            command = terminal.readCommand();
                            File file1 = new File(command);
                            this.terminal.print("Write path to second file: ");
                          command = terminal.readCommand();
                            File file2 = new File(command);
                            this.fileManager.move(file1, file2);
                        }
                        break;

                    case "cp": {
                            this.terminal.print("Write path to first file: ");
                            command = terminal.readCommand();
                            File file1 = new File(command);
                            this.terminal.print("Write path to second file: ");
                            command = terminal.readCommand();
                            File file2 = new File(command);
                            this.fileManager.move(file1, file2);
                        }
                        break;

                }
            }

        } catch (UserInteractorReadException ex) {
            System.out.println("Can't read user input due error:");
            System.err.println(ex.getMessage());
            System.exit(1);
        } catch (UserInteractorWriteException ex) {
            System.out.println("Can't print data to user due error:");
            System.err.println(ex.getMessage());
            System.exit(1);
        } catch (FIleManagerExeption ex) {
            System.out.println("Exception in IOOperations:");
            System.err.println(ex.getMessage());
            System.exit(1);
        }

    }
}


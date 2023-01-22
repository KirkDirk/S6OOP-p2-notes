package interfaces;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SAImpl implements StorageActions {

    /** Путь к файлу, с котороым проводятся действия */
    private String fileName;
    /** Количество записей в проекте */
    private int numberOfNotes;

    /**
     * Конструктор для реализации действий с файлами
     * @param fileName - Путь к файлу, с котороым проводятся действия
     */
    public SAImpl(String fileName) {
        this.fileName = fileName;
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void saveCommonData() {
        // TODO Auto-generated method stub

    }

    @Override
    public void saveNote() {
        // TODO Auto-generated method stub

    }

    @Override
    public int getNumberOfNotes() {
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            String[] numbers = line.split(",");
            numberOfNotes = Integer.parseInt(numbers[0]);
            fr.close();
            return numberOfNotes;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

}

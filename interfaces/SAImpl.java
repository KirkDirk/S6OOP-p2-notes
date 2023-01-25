package interfaces;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import models.Note;
import models.NoteWork;

public class SAImpl implements StorageActions {

    /** Путь к файлу, с котороым проводятся действия */
    private String fileName;
    /** Путь к файлу, который содержит общие данные по записям */
    private String commonFile = "storage\\notes.txt";    
    /** Количество записей в проекте */
    //private int numberOfNotes;

    /**
     * Конструктор для реализации действий с файлами
     * 
     * @param fileName - Путь к файлу, с котороым проводятся действия
     */
    public SAImpl(String fileName) {
        this.fileName = fileName;
        // Похоже, следующие строки не нужны
        // try (FileWriter writer = new FileWriter(fileName, true)) {
        //     writer.flush();
        // } catch (IOException ex) {
        //     System.out.println(ex.getMessage());
        // }
    }
    
    /** Обновляем значение количества Записей в общем файле хранилища */
    @Override
    public void saveCommonData(int id) {
        try (FileWriter fileOpenToSave = new FileWriter(commonFile, false)){
            fileOpenToSave.write(id+"::0"); // Здесь 0 - это костыль для замены в будущем
            fileOpenToSave.flush();
            fileOpenToSave.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** Записываем Запись в файл сохранения текущей Записи. Собственно это и есть CREATE note */
    @Override
    public void saveNote(String line) {
        try (FileWriter wrtr = new FileWriter(fileName, true)) {
            wrtr.write(line);
            wrtr.flush();
            wrtr.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public int getNumberOfNotes() {
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            String[] numbers = line.split("::");
            int numberOfNotes = Integer.parseInt(numbers[0]);
            fr.close();
            return numberOfNotes;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }


    
    @Override
    public List<NoteWork> readAllFilesFromStorage() {
        //List<NoteWork> listAllFiles = new List<NoteWork>() {
            
     
        return null;
    }

    @Override
    public String readAnyFileFromStorage(String fileName) {
        // TODO Auto-generated method stub
        return null;
    }

}

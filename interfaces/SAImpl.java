package interfaces;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import models.NoteWork;

public class SAImpl implements StorageActions {

    /** Путь к файлу, с котороым проводятся действия */
    private String fileName;
    /** Путь к файлу, который содержит общие данные по записям */
    private String commonFile = "storage\\notes.txt";    
   
    /**
     * Конструктор для реализации действий с файлами
     * 
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
        try (FileWriter wrtr = new FileWriter(fileName, false)) {
            wrtr.write(line);
            wrtr.flush();
            wrtr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveNote(String line, String flNm){
        this.fileName = flNm;
        this.saveNote(line);
    }

    @Override
    public int getNumberOfNotes() {
        try {
            File file = new File(commonFile);
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

    /** Считываем Запись из файла с передаваемым именем. Возвращаем Запись в формате NoteWork */
    @Override
    public NoteWork readAnyFileFromStorage(String fileName) {
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            fr.close();
            return lineToNote(line);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;      
    }

    /**
     * Преобразование строки в Запись по формату(ID, Title, Text)
     * @param line - преобразуемая строка (запись, полученная из файла в виде String)
     * @return NoteWork
     */
    private NoteWork lineToNote(String line){
        String[] lines = line.split("::");
        return new NoteWork(Integer.parseInt(lines[0]), lines[1], lines[2]);    
    }

    @Override
    public String noteToString(NoteWork note) {
        String noteToLine = note.getIdNote() + "::" + note.getTitleNote() + "::" + note.getTextNote();
        return noteToLine;
    }

    @Override
    public String createFileName(String id) {
        String pathToFile = "storage\\note" + id + ".txt";
        return pathToFile;
    }

    @Override
    public void deleteNote(String id) {
        String line = "Запись № "+ id + " удалена "+ java.time.ZonedDateTime.now();
        try (FileWriter wrtr = new FileWriter(this.createFileName(id), false)) {
            wrtr.write(line);
            wrtr.flush();
            wrtr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

}

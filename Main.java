import interfaces.SAImpl;

public class Main {
    public static void main(String[] args) {
        /** Приветственное слово */
        System.out.println("Привет! Это проект Записки, содержащий работу с записками из консоли");
        /** Считываем и показываем количество записей в проекте. Файл notes.txt хранит общие данные по количеству записей*/
        SAImpl non = new SAImpl("storage\\notes.txt");
        System.out.println(String.format("На сегодня в базе хранится %d записей", non.getNumberOfNotes()));
        
    }
}
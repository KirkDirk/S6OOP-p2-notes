package views;

import java.util.Scanner;

public class ViewNotes {
    
    public void run() {
        
        /** Текущий выбор меню пользователем */
        Command com = Command.NONE;

        while (true) {
            String command = prompt("Введите команду: ");
            com = Command.valueOf(command.toUpperCase());
            if (com == Command.EXIT)
                return;
            try {
                switch (com) {
                    case CREATE:
                        
                        break;
                    case READ:
                        
                        break;
                    case LIST:
                        
                        break;
                    case UPDATE:
                        
                        break;
                    case DELETE:
                        
                        break;
                }
            } catch (Exception e) {
                System.out.println("Что-то пошло не так: " + e.getMessage()); 
            }
        }
    }
    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GameInstaller {
    public static void main(String[] args) {
        String basePath = "/Users/debugfixer/Desktop/Tasks/Task1/Games"; // Укажите нужный путь, например, "/Users/admin/Games" для macOS

        StringBuilder log = new StringBuilder();

        // Создание директорий
        String[] directories = {
                basePath + "/src",
                basePath + "/src/main",
                basePath + "/src/test",
                basePath + "/res",
                basePath + "/res/drawables",
                basePath + "/res/vectors",
                basePath + "/res/icons",
                basePath + "/savegames",
                basePath + "/temp"
        };

        for (String dirPath : directories) {
            File dir = new File(dirPath);
            if (dir.mkdir()) {
                log.append("Создана директория: ").append(dirPath).append("\n");
            } else {
                log.append("Не удалось создать директорию: ").append(dirPath).append("\n");
            }
        }

        // Создание файлов
        String[] files = {
                basePath + "/src/main/Main.java",
                basePath + "/src/main/Utils.java",
                basePath + "/temp/temp.txt"
        };

        for (String filePath : files) {
            File file = new File(filePath);
            try {
                if (file.createNewFile()) {
                    log.append("Создан файл: ").append(filePath).append("\n");
                } else {
                    log.append("Не удалось создать файл: ").append(filePath).append("\n");
                }
            } catch (IOException e) {
                log.append("Ошибка при создании файла: ").append(filePath).append(" - ").append(e.getMessage()).append("\n");
            }
        }

        // Запись лога в temp.txt
        try (FileWriter writer = new FileWriter(basePath + "/temp/temp.txt")) {
            writer.write(log.toString());
            System.out.println("Лог записан в temp.txt");
        } catch (IOException e) {
            System.out.println("Ошибка при записи лога: " + e.getMessage());
        }
    }
}

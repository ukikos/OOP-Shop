package program;

import com.google.gson.Gson;
import program.events.EventService;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Supermarket supermarket;
        EventService service = new EventService();
        try (FileReader reader = new FileReader("./src/main/resources/save.txt")) {
            Scanner scn = new Scanner(reader);
            StringBuilder text = new StringBuilder();
            while (scn.hasNextLine()
            ) {
                text.append(scn.nextLine());
            }
            if (!"".contentEquals(text))
                supermarket = new Gson().fromJson(String.valueOf(text), Supermarket.class);
            else supermarket = new Supermarket();
            service.runSupermarket(supermarket);
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
package yajco.example.mealy;

import yajco.example.mealy.model.Mealy;
import yajco.example.mealy.parser.MealyParser;

import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        Reader reader = new BufferedReader(new InputStreamReader(
                Main.class.getResourceAsStream("/mealy")));
        Mealy mealy = new MealyParser().parse(reader);

        System.out.println(System.getProperty("user.dir"));
        File file = new File("target/mealy.dot");
        BufferedWriter writer = null;
        try {
            file.createNewFile();
            writer = new BufferedWriter(new FileWriter(file, false));
            writer.write(mealy.generate());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null)
                    writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

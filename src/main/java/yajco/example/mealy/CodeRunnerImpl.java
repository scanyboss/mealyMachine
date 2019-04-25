package yajco.example.mealy;

import yajco.example.mealy.model.Mealy;
import yajco.example.mealy.parser.MealyParser;
import yajco.example.mealy.parser.ParseException;
import yajco.xtext.semantics.CodeRunner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;

public class CodeRunnerImpl implements CodeRunner {
    @Override
    public void run(PrintStream printStream, String source, boolean isFile) {
        System.setErr(printStream);
        System.setOut(printStream);

        Mealy mealy = null;
        try {
            if (isFile){
                mealy = new MealyParser().parse(new FileReader(source));
            }else {
                mealy = new MealyParser().parse(source);
            }
            System.out.println(mealy.generate());
        } catch (ParseException | FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}

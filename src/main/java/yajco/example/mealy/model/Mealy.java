package yajco.example.mealy.model;

import yajco.annotation.After;
import yajco.annotation.Before;
import yajco.annotation.Token;
import yajco.annotation.reference.Identifier;

public class Mealy {

    @Identifier
    private final String name;
    private final Automaton automaton;

    @Before("begin")
    @After(";")
    public Mealy(
            @Token("name") String name,
            Automaton automaton,
            @Before("end")
            @Token("name")
            String endName) {
        this.name = name;
        this.automaton = automaton;
        if (!name.equals(endName)) {
            throw new RuntimeException("Unmatching module name at the end.");
        }
    }

    public String generate() {

        String output = "digraph " + name + "{\n";
        output += "\trankdir=LR;\n";
        output += "\tsize=\"8,5\";\n";
        output += "\tnode [shape = circle];\n";

        output += automaton.generate();
        output += "}";
        return output;
    }

    public String getName() {
        return name;
    }

    public String getEndName() {
        return name;
    }

    public Automaton getAutomaton() {
        return automaton;
    }
}

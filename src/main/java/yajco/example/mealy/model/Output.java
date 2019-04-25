package yajco.example.mealy.model;

import yajco.annotation.Token;
import yajco.annotation.reference.Identifier;

public class Output {
    @Identifier(unique = "../Output")
    private final String name;

    public Output( @Token("name") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String generate() {
        return this.name;
    }
}

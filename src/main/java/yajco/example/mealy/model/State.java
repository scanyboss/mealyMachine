package yajco.example.mealy.model;

import yajco.annotation.Token;
import yajco.annotation.reference.Identifier;

public class State {
    @Identifier(unique = "../State")
    private final String name;

    public State(@Token("name") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String generate() {
        return this.name;
    }
}

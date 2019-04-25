package yajco.example.mealy.model;

import yajco.annotation.Token;
import yajco.annotation.reference.References;

public class InputUsage {
    public Input getInput() {
        return input;
    }

    private Input input;

    public InputUsage(
            @References(value = Input.class, field = "input")
                    @Token("name")
                    String input) {

    }

    public String generate(){
        return input.generate();
    }
}

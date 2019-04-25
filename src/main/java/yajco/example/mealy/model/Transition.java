package yajco.example.mealy.model;

import yajco.annotation.*;
import yajco.annotation.reference.References;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Transition {
    private State initState;
    private State finalState;
    private InputUsage[] usages;
    private Output output;

    @Before("trans")
    @After(";")
    public Transition(
            @Token("name")
            @References(value = State.class, field = "initState")
                    String initState,
            @Before("to")
            @Token("name")
            @References(value = State.class, field = "finalState")
                    String finalState,
            @Before("when")
            @Separator(",")
                    @Range(minOccurs = 1)
                    InputUsage[] usages,
            @Before("produces")
            @Token("name")
            @References(value = Output.class, field = "output")
                    String output) {
        this.usages = usages;
    }

    @Exclude
    public Transition(State initState, State finalState, InputUsage[] inputs, Output output) {
        this.initState = initState;
        this.finalState = finalState;
        this.usages = inputs;
        this.output = output;
    }

    public State getInitState() {
        return initState;
    }

    public State getFinalState() {
        return finalState;
    }

    public InputUsage[] getUsages() {
        return usages;
    }

    public Output getOutput() {
        return output;
    }

    public String generate() {
        String output = "";
        output +=  "\t" + getInitState().generate() + " -> " + getFinalState().generate();
        output += "[ label = \"" + Arrays.stream(this.usages).map(u -> u.generate() + "/" + this.output.generate()).collect(Collectors.joining("\\n")) + "\"];\n";
        return output;
    }
}

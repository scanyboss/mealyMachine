package yajco.example.mealy.model;

import yajco.annotation.Range;

public class Automaton {

    private final InputSet inputSet;
    private final OutputSet outputSet;
    private final StateSet stateSet;
    private final Transition[] transitions;

    public Automaton(
            InputSet inputSet,
            OutputSet outputSet,
            StateSet stateSet,
            @Range(minOccurs = 1)
                    Transition[] transitions) {
        this.inputSet = inputSet;
        this.outputSet = outputSet;
        this.stateSet = stateSet;
        this.transitions = transitions;
    }

    public InputSet getInputSet() {
        return inputSet;
    }

    public OutputSet getOutputSet() {
        return outputSet;
    }

    public StateSet getStateSet() {
        return stateSet;
    }

    public Transition[] getTransitions() {
        return transitions;
    }

    public String generate() {
        String output = "";
        for (Transition transition : transitions) {
            output += transition.generate();
        }
        return output;
    }
}

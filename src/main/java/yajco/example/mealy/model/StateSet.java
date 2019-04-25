package yajco.example.mealy.model;

import yajco.annotation.After;
import yajco.annotation.Before;
import yajco.annotation.Range;
import yajco.annotation.Separator;

public class StateSet {
    private State[] states;

    @Before("define state set:")
    @After(";")
    public StateSet(
            @Separator(",")
            @Range(minOccurs = 1)
                    State[] states) {

        this.states = states;
    }
}

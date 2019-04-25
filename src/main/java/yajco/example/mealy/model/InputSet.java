package yajco.example.mealy.model;

import yajco.annotation.After;
import yajco.annotation.Before;
import yajco.annotation.Range;
import yajco.annotation.Separator;

public class InputSet {

    private Input[] inputs;

    @Before("define input set:")
    @After(";")
    public InputSet(
            @Separator(",")
            @Range(minOccurs = 1)
                    Input[] inputs) {

        this.inputs = inputs;
    }

}

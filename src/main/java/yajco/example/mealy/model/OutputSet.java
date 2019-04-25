package yajco.example.mealy.model;

import yajco.annotation.After;
import yajco.annotation.Before;
import yajco.annotation.Range;
import yajco.annotation.Separator;

public class OutputSet {

    private Output[] outputs;

    @Before("define output set:")
    @After(";")
    public OutputSet(
            @Separator(",")
            @Range(minOccurs = 1)
                    Output[] outputs) {

        this.outputs = outputs;
    }
}

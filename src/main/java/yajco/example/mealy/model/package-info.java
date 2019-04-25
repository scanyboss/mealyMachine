@Parser(className = "yajco.example.mealy.parser.MealyParser",
        mainNode = "Mealy",
        tokens = {
                @TokenDef(name = "name", regexp = "[a-zA-Z][a-zA-Z0-9]*")
        },
        skips = {
                @Skip(" "),
                @Skip("\\t"),
                @Skip("\\n"),
                @Skip("\\r")
        },
        options = {
                @Option(name="yajco.generateTools",value="textide"),
                @Option(name="yajco.xtext.baseName",value="org.mealy"),
                @Option(name="yajco.xtext.fileExtension",value="ml"),
                @Option(name="yajco.xtext.codeRunner", value = "yajco.example.mealy.CodeRunnerImpl")
        })
package yajco.example.mealy.model;

import yajco.annotation.config.Option;
import yajco.annotation.config.Parser;
import yajco.annotation.config.Skip;
import yajco.annotation.config.TokenDef;

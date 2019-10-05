package mastermind.views.console;

import mastermind.controllers.Controller;
import mastermind.models.Result;
import mastermind.utils.WithConsoleModel;

public class ResultCombinationView extends WithConsoleModel {
    
    private final Controller controller;

    public ResultCombinationView(Controller controller) {
        this.controller = controller;
    }

    public void writeln(int attempt) {
        Result result = this.controller.getResults().get(attempt);
        this.console.writeln(Message.RESULT.getMessage().replaceFirst("#blacks", "" + result.getBlacks()).replaceFirst("#whites", "" + result.getWhites()));
    }
}
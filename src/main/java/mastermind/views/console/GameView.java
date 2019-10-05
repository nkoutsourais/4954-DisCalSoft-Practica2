package mastermind.views.console;

import mastermind.controllers.Controller;
import mastermind.utils.WithConsoleModel;

public class GameView extends WithConsoleModel {

    private final Controller controller;

    public GameView(Controller controller) {
        this.controller = controller;
    }

    public void writeAttempts() {
		this.console.writeln(Message.ATTEMPTS.getMessage().replaceAll("#attempts", "" + this.controller.getAttemps()));
        new SecretCombinationView().writeSecretCombination();
		for (int i = 0; i < this.controller.getAttemps(); i++) {
			new ProposedCombinationView(this.controller).write(i);
			new ResultCombinationView(this.controller).writeln(i);
		}
	}

    public void writeTitle() {
        this.console.writeln(Message.TITLE.getMessage());
    }

    public void writeResultPlay() {
		if (this.controller.isWinner())
			this.console.writeln(Message.WINNER.getMessage());
		else
            this.console.writeln(Message.LOOSER.getMessage());
	}
}
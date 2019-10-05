package mastermind.controllers;

import java.util.List;

import mastermind.models.*;

public abstract class Controller {
    protected Game game;

    protected State state;

    Controller(Game game, State state) {
        this.game = game;
        this.state = state;
    }

    public SecretCombination getSecretCombination() {
		return this.game.getSecretCombination();
	}

    public List<ProposedCombination> getProposedCombinations() {
        return this.game.getProposedCombinations();
    }

    public List<Result> getResults() {
        return this.game.getResults();
    }

    public int getAttemps() {
		return this.game.getProposedCombinations().size();
    }

	public boolean isWinner() {
		return this.game.getResults().get(getAttemps() - 1).isWinner();
    }
    
    public abstract void accept(ControllerVisitor controllerVisitor);
}
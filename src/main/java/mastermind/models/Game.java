package mastermind.models;

import java.util.*;

public class Game {

    private static final int MAX_LONG = 10;

    private SecretCombination secretCombination;
    private List<ProposedCombination> proposedCombinations;
    private List<Result> results;

    public Game() {
        this.clear();
    }

    public SecretCombination getSecretCombination() {
        return secretCombination;
    }

    public void clear() {
        this.secretCombination = new SecretCombination();
		this.proposedCombinations = new ArrayList<ProposedCombination>();
		this.results = new ArrayList<Result>();
	}

	public boolean isFinished() {
		if (this.results.get(this.getAttemps() - 1).isWinner()) {
			return true;
		}
		if (this.getAttemps() == Game.MAX_LONG) {
			return true;
		}
		return false;
	}

	public int getAttemps() {
		return this.proposedCombinations.size();
	}

    public List<ProposedCombination> getProposedCombinations() {
        return proposedCombinations;
    }

    public List<Result> getResults() {
        return results;
    }
}
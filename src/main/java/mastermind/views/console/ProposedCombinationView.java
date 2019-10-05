package mastermind.views.console;

import java.util.ArrayList;
import java.util.List;
import mastermind.controllers.Controller;
import mastermind.models.*;
import mastermind.models.Error;
import mastermind.utils.WithConsoleModel;

public class ProposedCombinationView extends WithConsoleModel {

    private final Controller controller;

    public ProposedCombinationView(Controller controller) {
        this.controller = controller;
    }

    public void write(int attempt) {
        ProposedCombination proposedCombination = this.controller.getProposedCombinations().get(attempt);
        for (Color color : proposedCombination.getColors()) {
            this.console.write(color.getInitial());
        }
    }

    public ProposedCombination read() {
        Error error;
        List<Color> colors = new ArrayList<Color>();
		do {
			error = null;
			this.console.write(Message.PROPOSED_COMBINATION.getMessage());
			String characters = this.console.readString();
			if (characters.length() != ProposedCombination.getWidth()) {
				error = Error.WRONG_LENGTH;
			} else {
				for (int i = 0; i < characters.length(); i++) {
					Color color = Color.getInstance(characters.charAt(i));
					if (color == null) {
						error = Error.WRONG_CHARACTERS;
					} else {
						for(int j=0; j< colors.size(); j++){
							if (color == colors.get(j)){
								error = Error.DUPLICATED;
							}
						}
						colors.add(color);
					}
				}
			}
			if (error != null) {
				this.console.writeln(error.getMessage());
				while (!colors.isEmpty()){
					colors.remove(0);
				}
			}
		} while (error != null);
        return new ProposedCombination(colors);
	}
}
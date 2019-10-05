package mastermind.views.console;

import mastermind.controllers.Controller;
import mastermind.controllers.ProposeCombinationController;
import mastermind.controllers.ResumeController;
import mastermind.controllers.StartController;
import mastermind.models.ProposedCombination;
import mastermind.utils.YesNoDialog;
import mastermind.views.View;

public class ConsoleView implements View {

    @Override
    public void interact(Controller controller) {
        controller.accept(this);
    }

    @Override
    public void visit(StartController startController) {
        startController.start();
        new GameView(startController).writeTitle();
        new SecretCombinationView().writeSecretCombination();
    }

    @Override
    public void visit(ProposeCombinationController proposeCombinationController) {
        ProposedCombination proposedCombination = new ProposedCombinationView(proposeCombinationController).read();
        proposeCombinationController.addProposedCombination(proposedCombination);
        new GameView(proposeCombinationController).writeAttempts();
    }

    @Override
    public void visit(ResumeController resumeController) {
        new GameView(resumeController).writeResultPlay();
        resumeController.resume(new YesNoDialog().read(Message.RESUME.getMessage()));
    }
}
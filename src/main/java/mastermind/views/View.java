package mastermind.views;

import mastermind.controllers.*;

public interface View extends ControllerVisitor {
    void interact(Controller controller);
}
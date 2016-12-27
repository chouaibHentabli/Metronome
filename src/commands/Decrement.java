package commands;

import controller.Controller;

/**
 * Created by chouaib on 22/12/16.
 */
public class Decrement implements Command {

    private Controller controller;

    public Decrement(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.decrementMeasure();
    }
}

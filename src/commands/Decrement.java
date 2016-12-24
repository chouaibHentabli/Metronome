package commands;

import controller.Controller;

/**
 * Created by chouaib on 22/12/16.
 */
public class Decrement implements Command {

    Controller controller;

    public Decrement(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {

    }
}

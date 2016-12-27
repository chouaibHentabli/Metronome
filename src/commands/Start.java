package commands;

import controller.Controller;

/**
 * Created by chouaib on 22/12/16.
 */
public class Start implements Command {

    private Controller controller;

    public Start(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.start();
    }
}

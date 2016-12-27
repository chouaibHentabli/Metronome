package commands;

import controller.Controller;

/**
 * Created by chouaib on 22/12/16.
 */
public class Stop implements Command {

    private Controller controller;

    public Stop(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.stop();
    }
}

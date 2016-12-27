package commands;

import controller.Controller;
import engine.Engine;

/**
 * Created by chouaib on 22/12/16.
 */
public class Tic implements Command {

    private Controller controller;

    public Tic(Controller c) {
        this.controller = c;
    }

    @Override
    public void execute() {
        controller.tic();
    }
}

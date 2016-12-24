package commands;

import controller.Controller;

/**
 * Created by chouaib on 22/12/16.
 */
public class Increment implements Command {

    Controller controller;

    public Increment(Controller controller) {
        this.controller = controller;
    }


    @Override
    public void executer() {

    }
}

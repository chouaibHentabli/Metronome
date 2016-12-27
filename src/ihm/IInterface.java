package ihm;

import commands.Command;
import controller.Controller;
import engine.Engine;

/**
 * Created by chouaib on 22/12/16.
 */
public interface IInterface {

    /**
     * @param c Controller
     */
    public void setControleur(Controller c);

    /**
     * Engine
     *
     * @param e
     */
    public void setEngine(Engine e);

    /**
     * init vue configuration
     */
    public void init();

    /**
     * enable the engine
     */
    public void start();

    /**
     * stop the engine
     */
    public void stop();

    /**
     * Increment the measure
     */
    public void increment();

    /**
     * Decrement the measure
     */
    public void decrement();

    /**
     * @param v flapping by measure
     */
    public void setTempoText(int v);

    /**
     * switch on led tempo
     */
    public void switchOnTic();

    /**
     * switch on led measure
     */
    public void switchOnToc();

    /**
     * Update the tempo on the view
     */
    public void updateTempo();

    /**
     * @param command start command
     */
    public void setStartCommand(Command command);

    /**
     * @param command stop command
     */
    public void setStopCommand(Command command);

    /**
     * @param command increment command
     */
    public void setIncCommand(Command command);

    /**
     * @param command decrement command
     */
    public void setDecCommand(Command command);

}

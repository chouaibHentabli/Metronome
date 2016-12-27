package controller;

import java.util.Observer;

/**
 * Created by chouaib on 22/12/16.
 */
public interface IController extends Observer {


    /**
     * Mark the measure sur la vue
     */
    void MarkMeasure();

    /**
     * Update time on the view
     */
    void MarkTemps();

    /**
     * Increment measure
     */
    void incrementMeasure();

    /**
     * Decrement measure
     */
    void decrementMeasure();

    /**
     * Update the tempo on the view
     */
    void updateTempo();

    /**
     * Enable metronome
     */
    void start();

    /**
     * Disable metronome
     */
    void stop();

    /**
     * @param t Flapping by  minute
     */
    void setTempo(String t);


    void tic();
}

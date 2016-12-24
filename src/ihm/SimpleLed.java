package ihm;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

/**
 * Created by controlberkani on 26/12/2015.
 */
public class SimpleLed implements Led {
    private Timeline flashAnimation;

    public SimpleLed(Shape shape, Color color){
        flashAnimation = new Timeline();
        flashAnimation.setCycleCount(1);
        flashAnimation.setAutoReverse(true);
        flashAnimation.getKeyFrames().add(new KeyFrame(Duration.millis(100),
                new KeyValue(shape.fillProperty(), Paint.valueOf("#c2c5d0"))));
        flashAnimation.getKeyFrames().add(new KeyFrame(Duration.millis(0),
                new KeyValue(shape.fillProperty(), color)));

    }
    @Override
    public void flash() {
        flashAnimation.play();
    }
}


package controlTemporizador;

import java.io.IOException;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;


public class ControlTemporizador extends AnchorPane
{
    @FXML
    private Label lblValor;
    
    public ControlTemporizador()
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ControlTemporizador.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try 
        {
            fxmlLoader.load();
        } catch (IOException exception) 
        {
            throw new RuntimeException(exception);
        }
    }
   
    public void iniciarTemporizador(IntegerProperty tiempo)
    {
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(tiempo, 0);
        KeyFrame kf = new KeyFrame(Duration.seconds(tiempo.getValue()), onFinished , kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
       
        lblValor.textProperty().bind(tiempo.asString());
    }
    
    private EventHandler onFinished = new EventHandler<ActionEvent>()
    {
        @Override
        public void handle(ActionEvent event) 
        {
            System.out.println("¡¡¡ TIEMPO !!!");
        }   
    };
    
}

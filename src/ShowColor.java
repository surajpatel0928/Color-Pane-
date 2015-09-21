import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;




/**
 * Created by surajpatel on 3/4/15.
 */

public class ShowColor extends Application {

    public static void main(String[] args) {
        Application.launch();
    }

    ColorPane C;

    public void start(Stage primaryStage) throws Exception {

        C = new ColorPane();
        BorderPane D = new BorderPane();

        Button button1 = new Button("Hue Up");
        button1.setOnAction(new IncressHue());
        Button button2 = new Button("Hue down");
        button2.setOnAction(new DownHue());

        Button button3 = new Button("Brighter");
        button3.setOnAction(new Brighter());

        Button button4 = new Button("Darker");
        button4.setOnAction(new Darker());

        Button button5 = new Button("More Saturated");
        button5.setOnAction(new MoreSaturation());

        Button button6 = new Button("Less Saturated");
        button6.setOnAction(new lessSaturation());
        D.setCenter(C);

        HBox hbox = new HBox();
        hbox.getChildren().add(button1);
        hbox.getChildren().add(button2);
        D.setTop(hbox);
        HBox hbox1 = new HBox();
        hbox1.getChildren().add(button3);
        hbox1.getChildren().add(button4);
        D.setBottom(hbox1);

        VBox vbox = new VBox();
        vbox.getChildren().add(button6);
        vbox.getChildren().add(button5);
        D.setRight(vbox);

        Scene sc = new Scene(D, 600, 600);
        primaryStage.setScene(sc);
        primaryStage.show();
    }

    private class IncressHue implements EventHandler<ActionEvent> {
        @Override // Override the handle method
        public void handle(ActionEvent e) {
            C.HueUP();


        }
    }


    class DownHue implements EventHandler<ActionEvent> {
        @Override // Override the handle method
        public void handle(ActionEvent e) {
            C.HueDown();


        }
    }

    class Brighter implements EventHandler<ActionEvent> {
        @Override // Override the handle method
        public void handle(ActionEvent e) {
            C.brighter();


        }
    }

    class Darker implements EventHandler<ActionEvent> {
        @Override // Override the handle method
        public void handle(ActionEvent e) {
            C.Darker();


        }
    }


    class lessSaturation implements EventHandler<ActionEvent> {
        @Override // Override the handle method
        public void handle(ActionEvent e) {
            C.LessSaturated();


        }
    }

    class MoreSaturation implements EventHandler<ActionEvent> {
        @Override // Override the handle method
        public void handle(ActionEvent e) {
            C.MoreSaturated();


        }
    }


    class ColorPane extends Pane {

        private Rectangle rectangle;

        public ColorPane() {
            rectangle = new Rectangle();
            rectangle.setX(0);
            rectangle.setY(0);
            rectangle.heightProperty().bind(this.heightProperty());
            rectangle.widthProperty().bind(this.widthProperty());
            rectangle.setArcWidth(20);
            rectangle.setArcHeight(20);

            this.getChildren().add(rectangle);
            rectangle.setFill(Color.BROWN);
            rectangle.setStroke(Color.BLUE);
        }


        public void brighter() {

            Color c = (Color) rectangle.getFill();

            double Hue = c.getHue();

            double Saturation = c.getSaturation();

            double Brightness = c.getBrightness();

            Color c2 = Color.hsb(Hue, Saturation, (Math.sqrt(Brightness)));

            rectangle.setFill(c2);

        }

        public void Darker() {

            Color c = (Color) rectangle.getFill();

            double Hue = c.getHue();

            double Saturation = c.getSaturation();

            double Darker = c.getBrightness();

            Color c3 = Color.hsb(Hue, Saturation, Math.pow(Darker, 2));

            rectangle.setFill(c3);
        }

        public void LessSaturated() {


            Color c = (Color) rectangle.getFill();

            double Hue = c.getHue();

            double Saturation = c.getSaturation();

            double Darker = c.getBrightness();

            Color c4 = Color.hsb(Hue, Math.pow(Saturation, 2), Darker);


            rectangle.setFill(c4);


        }

        public void MoreSaturated() {


            Color c = (Color) rectangle.getFill();

            double Hue = c.getHue();

            double Saturation = c.getSaturation();

            double Darker = c.getBrightness();

            Color c5 = Color.hsb(Hue, Math.sqrt(Saturation), Darker);

            rectangle.setFill(c5);


        }

        public void HueUP() {


            Color c = (Color) rectangle.getFill();

            double Hue = c.getHue();

            double Saturation = c.getSaturation();

            double Darker = c.getBrightness();

            Color c6 = Color.hsb(Hue + 30, Saturation, Darker);

            rectangle.setFill(c6);


        }

        public void HueDown() {


            Color c = (Color) rectangle.getFill();

            double Hue = c.getHue();

            double Saturation = c.getSaturation();

            double Darker = c.getBrightness();

            Color c7 = Color.hsb(Hue - 30, Saturation, Darker);

            rectangle.setFill(c7);

        }


    }
}











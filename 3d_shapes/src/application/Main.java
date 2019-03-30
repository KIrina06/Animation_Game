package application;
	


import javafx.scene.input.MouseEvent;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Shape3D;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;


public class Main extends Application {
	@Override
	public void start(Stage PrimaryStage) {
		Box box = new Box();
		//размеры
		box.setWidth(150);
		box.setHeight(150);
		box.setDepth(150);
		
		box.setTranslateX(350);
		box.setTranslateY(150);
		box.setTranslateZ(50);
		
		Cylinder cylinder = new Cylinder();
		cylinder.setRadius(80);
		cylinder.setHeight(150);
		
		cylinder.setTranslateX(500);
		cylinder.setTranslateY(150);
		cylinder.setTranslateZ(50);
		
		Sphere circle = new Sphere();
		circle.setRadius(75);
		
		circle.setTranslateX(650);
		circle.setTranslateY(150);
		circle.setTranslateZ(50);
		
		PhongMaterial mt = new PhongMaterial();
		
		mt.setDiffuseColor(Color.CADETBLUE);
		
		PhongMaterial mt2 = new PhongMaterial();
		
		mt2.setDiffuseColor(Color.DARKSEAGREEN);
		
		PhongMaterial mt3 = new PhongMaterial();
		
		mt3.setDiffuseColor(Color.GOLDENROD);
		
		box.setMaterial(mt);
		cylinder.setMaterial(mt2);
		circle.setMaterial(mt3);
		//вращение
		
		RotateTransition rt2 = new RotateTransition();
		rt2.setDuration(Duration.millis(1000));
		rt2.setNode(box);
		rt2.setAxis(Rotate.X_AXIS);
		rt2.setByAngle(-360);
		rt2.setCycleCount(50);
		
		
		RotateTransition rt = new RotateTransition();
		rt.setDuration(Duration.millis(1000));
		rt.setNode(cylinder);
		rt.setAxis(Rotate.X_AXIS);
		rt.setByAngle(360);
		rt.setCycleCount(50);
		
		RotateTransition rt3 = new RotateTransition();
		rt3.setDuration(Duration.millis(1000));
		rt3.setNode(circle);
		rt3.setAxis(Rotate.X_AXIS);
		rt3.setByAngle(-360);
		rt3.setCycleCount(50);
		
		
		Button btn = new Button();
		btn.setText("Start");
		btn.setLayoutX(30);
		btn.setLayoutY(100);
		
		Button btn2 = new Button();
		btn2.setText("Stop");
		btn2.setLayoutX(30);
		btn2.setLayoutY(130);
		
		EventHandler<javafx.scene.input.MouseEvent> ehb = new EventHandler<javafx.scene.input.MouseEvent>() {

			@Override
			public void handle(javafx.scene.input.MouseEvent event) {
				rt.play();
				rt2.play();
				rt3.play();
			}
		};
		
		btn.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, ehb);
		
		
		EventHandler<javafx.scene.input.MouseEvent> ehb2 = new EventHandler<javafx.scene.input.MouseEvent>() {

			@Override
			public void handle(javafx.scene.input.MouseEvent event) {
				rt.stop();
				rt2.stop();
				rt3.stop();
			}
		};
		
		btn2.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, ehb2);
		
		Group root = new Group (box, cylinder, circle, btn, btn2);
		Scene scene = new Scene(root, 600, 300);
		PerspectiveCamera camera = new PerspectiveCamera();
		camera.setTranslateX(0);
		camera.setTranslateY(0);
		camera.setTranslateZ(0);
		scene.setCamera(camera);
		
		PrimaryStage.setScene(scene);
		PrimaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

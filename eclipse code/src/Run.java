import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.Main;

public class Run extends Application{
	public static Scene SCENE_DE_APP = Main.getScene();
	@Override
	public void start(Stage stage) throws Exception {
		SCENE_DE_APP = Main.getScene();
		
		stage.setScene(SCENE_DE_APP);
		stage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
	public static void ChangeScene(GUI view){
		Run.SCENE_DE_APP = view.getScene();
	}
}

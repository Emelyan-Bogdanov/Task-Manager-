import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.Main;

public class Run extends Application{
	public static Scene STAGE_MAIN = Main.getScene();
	@Override
	public void start(Stage stage) throws Exception {
		Scene main = Main.getScene();
		
		stage.setScene(main);
		stage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}

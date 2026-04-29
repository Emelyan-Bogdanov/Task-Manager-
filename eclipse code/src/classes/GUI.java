import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;


// this class will be inherited by all app endpoints
public class GUI {
	public int 
		WIDTH = 800 ,
		HEIGHT = 900;
	public String 
		NAME = "My GUI from Class 'GUI'" ,
		FXML = "default.fxml"; // the fxml template
	public Scene SCENE; 
	public Parent ROOT; // the parent root of the fxml loader
	
	/* constructor for different parameters */
	public GUI(int w , int h , int name){
		WIDTH = w; 
		HEIGHT = h;
		NAME = name;
	}
	public GUI(int w , int h){
		WIDTH = w;
		HEIGHT = h;

	}
	public GUI(){}

	// functions
	public void setFxmlTemplatePath(String path){
		// assume to the fxml template for this GUI
		this.FXML = path;
		// verift if exists or if there is no error
		this._verify_path(path);
	}

	public Scene getScene(){
		this.ROOT = FXMLLoader.load(Main.class.getClass().getResource(this.FXML)); 	
		this.SCENE = new Scene(ROOT); // apply the template to the scene to see if it works
		return this.SCENE;
	}

	private void _verify_path(String path){
		try {
			this.ROOT = FXMLLoader.load(Main.class.getClass().getResource(this.FXML)); 	
			System.out.printf("%s FXML loaded successfully \n",path);
		}
		except {
			// print the banner so i notice it
			System.out.println("==========================\n ==========================\n");
			System.out.printf("|| FXML_ERROR : Failed to load fxml from '%s' , try to  : \n\t - Verify FXML template or syntaxe \n\t - Verify the if path is correct ",path);
			System.out.println("==========================\n ==========================\n");
		}
	}

}
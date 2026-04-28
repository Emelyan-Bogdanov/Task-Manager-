
/*

    Cette class est consaré seulement pour créer et gérer les fichiers .properties
*/

public class Prop {
    public String path
    
    public Prop(String path){
        this.path =  path;
    }
    public void readFile(){
        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream(self.path); // incase of errror => try split filename and path

            // load a properties file
            prop.load(input);
            
            prop.getProperty("database");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

import java.io.FileWriter;
import java.io.IOException;

class JsonBuilder {
    private StringBuilder output;
    private boolean hasEntries;

    public JsonBuilder() {
        this.output = new StringBuilder();
        this.output.append("{");
        this.hasEntries = false;
    }

    public void add(String key, String value) {
        if (hasEntries) {
            output.append(", ");
        }
        output.append("\"").append(key).append("\": \"").append(value).append("\"");
        hasEntries = true;
    }

    public void addLast() {
        output.append("}");
    }

    public String toJson() {
        return output.toString();
    }
}

public class Main {
    public static void  saveAsJSON(String filename){
		JsonBuilder json = new JsonBuilder();
			// create the JSON form 
			  json.add("ID", "this.id");
			  json.add("TITLE", "this.title");
			  json.add("DESCRIPTION","this.description");
			  json.add("SHEDULE","this.this.sheduled");
			  json.add("CREATED_AT","this.createAt");
			  json.add("STATUS","this.status");
			  json.add("IMPORTANCE","this.importance");
			  json.addLast();
			  json.toJson();
			// convert json object to file
		try (FileWriter file = new FileWriter(filename)) {
			file.write(json.toJson());
			System.out.printf("[SUCCESS] : Fichier %s sauvegardé avec succés" , filename);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.printf("ERROR : Impossible de sauvegarder : %s ",filename);
		}

	}
    public static void main(String[] args){
        saveAsJSON("test");
    }
}
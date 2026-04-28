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
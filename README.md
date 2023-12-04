# MyGardenBackend
Backend code for MyGarden
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) throws Exception {
        // Example field string: "Field1[x].Field2 = Y"
        String fieldString = "Field1[x].Field2 = Y";

        // Convert to JSON
        JsonNode jsonNode = convertToJSON(fieldString);

        // Convert JSON to string for display
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);

        System.out.println(json);
    }

    private static JsonNode convertToJSON(String fieldString) {
        String[] parts = fieldString.split("\\s*=\\s*");
        String fieldsPart = parts[0];
        String valuePart = parts[1];

        String[] fieldNames = fieldsPart.split("\\.");
        JsonNode result = null;
        JsonNode currentNode = null;

        for (String fieldName : fieldNames) {
            String[] fieldParts = fieldName.split("\\[|\\]");
            String fieldNameWithoutIndex = fieldParts[0];
            int index = (fieldParts.length > 1) ? Integer.parseInt(fieldParts[1]) : 0;

            if (currentNode == null) {
                currentNode = createNode(fieldNameWithoutIndex, index);
                result = currentNode;
            } else {
                currentNode = createNode(fieldNameWithoutIndex, index);
                currentNode = currentNode.path(fieldNameWithoutIndex);
            }
        }

        // Set the value at the final node
        if (currentNode != null) {
            ((com.fasterxml.jackson.databind.node.ObjectNode) currentNode).put("value", valuePart.trim());
        }

        return result;
    }

    private static JsonNode createNode(String fieldName, int index) {
        ObjectMapper objectMapper = new ObjectMapper();
        if (index == 0) {
            return objectMapper.createObjectNode().put(fieldName, "");
        } else {
            return objectMapper.createArrayNode();
        }
    }
}

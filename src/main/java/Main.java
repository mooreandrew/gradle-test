import static spark.Spark.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

public class Main {
    public static void main(String[] args) {
        port(9090); // Spark will run on port 9090, as opposed to 4567 which it will default to if not specified

        get("/hello", (req, res) -> "Hello World");

        get("/method", (req, res) -> methodRoute());

        get("/method/:param", (req, res) -> methodRoute(req.params(":param")));

        // you can test this route using the following curl
        // curl -X POST -d "hello world" http://localhost:9090/postit
        post("/postit", (req, res) -> postIt(req.body()));

        // curl -X POST -d '{"data" : "this is data", "dog" : "This is dog"}' http://localhost:9090/postJSON
        post("/postJSON", (req, res) -> parseJSON(req.body(), "data"));
    }

    private static String methodRoute(){
        return "The method route was hit";
    }

    private static String methodRoute(String param){
        return "Hello, you sent the method route the word " + param;
    }

    private static String postIt(String bodyText){
        return bodyText;
    }

    private static String parseJSON(String bodyText, String fieldName){
        String fieldValue = "";
        JSONParser parser = new JSONParser();

        try{
            JSONObject obj2=(JSONObject)parser.parse(bodyText);
            fieldValue = (String)obj2.get(fieldName);
            System.out.println("==========field " + fieldName + "==========");
            System.out.println(fieldValue);

        }catch(ParseException pe){

            System.out.println("position: " + pe.getPosition());
            System.out.println(pe);
        }

        return fieldValue;
    }
}
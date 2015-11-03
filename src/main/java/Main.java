import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");

        get("/method", (req, res) -> methodRoute());

        get("/method/:param", (req, res) -> methodRoute(req.params(":param")));

        // you can test this route using the following curl
        // curl -X POST -d "hello world" http://localhost:4567/postit
        post("/postit", (req, res) -> postIt(req.body()));
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
}
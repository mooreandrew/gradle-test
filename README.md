# Simple Spark app
This code was tested in IntelliJ on a Mac, to get it working you may need to do the following:

- Install the latest version of Java
- Download json-simple-1.1.1.jar (https://code.google.com/p/json-simple/)
- Copy to /Library/Java/Extensions/json-simple-1.1.1.jar
- Add to CLASSPATH (export CLASSPATH=$CLASSPATH:/Library/Java/Extensions/json-simple-1.1.1.jar)
- In IntelliJ, right click project and select “Open Module Settings (F4)"
- Click + button
- Select “1 JARs or Directories”
- Navigate to folder and select json-simple-1.1.1.jar

# Running the server
Either run the Main.java file in src/main/java, or if using IntelliJ you can just right-click on it and select "run Main.main()"

With the server running, you can hit the GET routes either in a browser or with a curl. The routes are:

- (GET) http://localhost:9090/hello - A simple test to return "hello world"
- (GET) http://localhost:9090/method - A route to demonstrate running functionality from a method
- (GET) http://localhost:9090/method/[anything] - A route to show how to add variables to routes
- (POST) http://localhost:9090/postit - A route to receive a simple text post, test with:

curl -X POST -d "hello world" http://localhost:9090/postit
- (POST) http://localhost:9090/postJSON - A route to receive a JSON object and parse it, test with:

curl -X POST -d '{"data" : [{"line" : "This is a line"}, {"line" : "This is also a line"}]}' http://localhost:9090/postJSON


## First homework pt. 1
#### Compilation and running
* Compile `.java` classes using command `javac -d ./bin ./src/com/bekh/*`
* Run compiled `Main.class` file using command `java -classpath ./bin com.bekh.Main`
#### Building executable .jar
* Create `manifest.mf` file with the following content
```
main-class: com.bekh.Main
class-path: bin/
```
* Create `example.jar` file using command `jar -cmf manifest.mf example.jar -C bin .`
* Use command `java -jar example.jar` to execute `example.jar` archive
### Additional task
* Download `java-util-1.65.0.jar` library
* Compile `.java` classes using command `javac -d bin -classpath ./src;./lib/java-util-1.65.0.jar src/com/bekh/Main.java`
* Run compiled `Main.class` file using command `java -classpath ./bin;./lib/java-util-1.65.0.jar com.bekh.Main`
* Create `manifest2.mf` file with the following content
```
main-class: com.bekh.Main
class-path: bin/ lib/java-util-1.65.0.jar
```
* Create `example-2.jar` file using command `jar -cmf manifest-2.mf example-2.jar -C bin .`
* Use command `java -jar example-2.jar` to execute `example-2.jar` archive
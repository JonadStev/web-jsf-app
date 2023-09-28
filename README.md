# web-jsf-app
Se debe descargar servidor de aplicaciones wildfly-23.0.0.Final
En la clase src\main\java\com\demo\app\RegistroService mapear la URL de consumo al microservicio

```java
public class RegistroService {
    private static final String BASE_URL = "http://localhost:8080/ms-demo-0.0.1-SNAPSHOT/usuarios/";
    ...
}
```

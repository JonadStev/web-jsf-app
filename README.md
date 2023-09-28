# web-jsf-app
Se debe descargar servidor de aplicaciones wildfly-23.0.0.Final. Lo puede hacer en el sitio oficial: https://www.wildfly.org/downloads/

Para probarlo localmente debe instalar un IDE de desarrollo que le permita agregar un servidor de aplicaciones como wildfly, recomiendo usar Netbeans y lo puede descargar en el sitio oficial: https://netbeans.apache.org/download/nb19/

# Configuracion de URL microservicio
En la clase src\main\java\com\demo\app\RegistroService mapear la URL de consumo al microservicio

```java
public class RegistroService {
    private static final String BASE_URL = "http://localhost:8080/ms-demo-0.0.1-SNAPSHOT/usuarios/";
    ...
}
```
Si usa netbeans, luego de hacer todo los cambios solo ejecute:

run and build

para generar su archvo .war y desplegarlo en el servidor de aplicaciones. Tambien lo puede hacer ejecutando el proyecto desde netbean en la opcion run server, y seleccione el servidor de aplicaciones wildfly

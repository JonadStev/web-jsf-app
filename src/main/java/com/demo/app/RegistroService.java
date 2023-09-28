package com.demo.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class RegistroService {
    private static final String BASE_URL = "http://localhost:8081/usuarios";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public Registro crearRegistro(Registro registro) throws IOException {
        String url = BASE_URL + "/";
        HttpPost httpPost = new HttpPost(url);
        String registroJson = objectMapper.writeValueAsString(registro);
        StringEntity entity = new StringEntity(registroJson);
        httpPost.setEntity(entity);
        System.out.println("JSON REQUEST: "+registroJson);
        httpPost.setHeader("Content-Type", "application/json");

        HttpClient httpClient = HttpClients.createDefault();
        HttpResponse response = httpClient.execute(httpPost);

        if (response.getStatusLine().getStatusCode() == 201 || response.getStatusLine().getStatusCode() == 200) {
            return objectMapper.readValue(response.getEntity().getContent(), Registro.class);
        }

        return null; // Manejar el error de creación aquí
    }

    public List<Registro> listarRegistros() throws IOException {
        String url = BASE_URL + "/";
        HttpGet httpGet = new HttpGet(url);

        HttpClient httpClient = HttpClients.createDefault();
        HttpResponse response = httpClient.execute(httpGet);

        if (response.getStatusLine().getStatusCode() == 200) {
            Registro[] registros = objectMapper.readValue(response.getEntity().getContent(), Registro[].class);
            System.out.println("SI DEVOLVIO DATOS");
            return Arrays.asList(registros);
        }
        System.out.println("NO DEVOLVIO DATOS");
        return null; // Manejar el error de listar aquí
    }

    public void eliminarRegistro(int registroId) throws IOException {
        String url = BASE_URL + "/" + registroId;
        HttpDelete httpDelete = new HttpDelete(url);

        HttpClient httpClient = HttpClients.createDefault();
        HttpResponse response = httpClient.execute(httpDelete);

        if (response.getStatusLine().getStatusCode() != 204) {
            System.out.println("ELIMINADO "+response.getStatusLine().getStatusCode());
        }
    }
}

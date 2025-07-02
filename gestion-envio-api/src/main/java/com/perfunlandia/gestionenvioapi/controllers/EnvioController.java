package com.perfunlandia.gestionenvioapi.controllers;

import com.perfunlandia.gestionenvioapi.models.entities.Envio;
import com.perfunlandia.gestionenvioapi.services.EnvioService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/envios")
@RequiredArgsConstructor
public class EnvioController {

    private final EnvioService envioService;

    // MÉTODOS CON HATEOAS 
    
    @PostMapping
    public ResponseEntity<Envio> crearEnvio(@RequestBody Envio envio) {
        Envio envioGuardado = envioService.guardarEnvio(envio);
        agregarEnlacesHateoas(envioGuardado);
        return ResponseEntity.ok(envioGuardado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Envio> obtenerPorId(@PathVariable Integer id) {
        Envio envio = envioService.obtenerPorId(id);
        agregarEnlacesHateoas(envio);
        return ResponseEntity.ok(envio);
    }

    @GetMapping("/venta/{idVenta}")
    public ResponseEntity<Envio> obtenerPorIdVenta(@PathVariable Integer idVenta) {
        Envio envio = envioService.obtenerPorIdVenta(idVenta);
        agregarEnlacesHateoas(envio);
        return ResponseEntity.ok(envio);
    }

    @PutMapping
    public ResponseEntity<Envio> actualizarEnvio(@RequestBody Envio envio) {
        Envio envioActualizado = envioService.actualizarEnvio(envio);
        agregarEnlacesHateoas(envioActualizado);
        return ResponseEntity.ok(envioActualizado);
    }

    @GetMapping
    public ResponseEntity<List<Envio>> listarTodos() {
        List<Envio> envios = envioService.listarTodos();
        envios.forEach(this::agregarEnlacesHateoas);
        return ResponseEntity.ok(envios);
    }

    //  MÉTODO PRIVADO PARA AGREGAR ENLACES HATEOAS
    
    private void agregarEnlacesHateoas(Envio envio) {
        // Enlaces que apuntan al API Gateway en puerto 8888
        envio.add(Link.of("http://localhost:8888/api/envios/" + envio.getIdEnvio(), "self"));
        envio.add(Link.of("http://localhost:8888/api/envios", "all-envios"));
        envio.add(Link.of("http://localhost:8888/api/envios/venta/" + envio.getIdVenta(), "by-venta"));
        envio.add(Link.of("http://localhost:8888/api/envios", "create-envio").withRel("create"));
        envio.add(Link.of("http://localhost:8888/api/envios", "update-envio").withRel("update"));
    }
}
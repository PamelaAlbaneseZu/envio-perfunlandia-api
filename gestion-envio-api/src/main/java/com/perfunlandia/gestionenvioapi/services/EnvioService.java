package com.perfunlandia.gestionenvioapi.services;

import com.perfunlandia.gestionenvioapi.models.entities.Envio;
import com.perfunlandia.gestionenvioapi.repositories.EnvioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnvioService {

    private final EnvioRepository envioRepository;

    // Guardar un nuevo envío
    public Envio guardarEnvio(Envio envio) {
        return envioRepository.save(envio);
    }

    // Obtener envío por ID
    public Envio obtenerPorId(Integer id) {
        return envioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Envío no encontrado con ID: " + id));
    }

    // Obtener envío por ID de venta
    public Envio obtenerPorIdVenta(Integer idVenta) {
        return envioRepository.findByIdVenta(idVenta)
                .orElseThrow(() -> new RuntimeException("No hay envío para la venta ID: " + idVenta));
    }

    // Actualizar un envío
    public Envio actualizarEnvio(Envio envioActualizado) {
        if (!envioRepository.existsById(envioActualizado.getIdEnvio())) {
            throw new RuntimeException("El envío a actualizar no existe con ID: " + envioActualizado.getIdEnvio());
        }
        return envioRepository.save(envioActualizado);
    }

    // (Opcional) Listar todos los envíos
    public List<Envio> listarTodos() {
        return envioRepository.findAll();
    }
}
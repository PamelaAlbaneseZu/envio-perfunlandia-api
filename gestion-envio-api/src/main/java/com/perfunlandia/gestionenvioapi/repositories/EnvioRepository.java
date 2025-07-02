package com.perfunlandia.gestionenvioapi.repositories;

import com.perfunlandia.gestionenvioapi.models.entities.Envio;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EnvioRepository extends JpaRepository<Envio, Integer> 
{
    Optional<Envio> findByIdVenta(Integer idVenta);
}
package com.perfunlandia.gestionenvioapi.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "envio")
public class Envio extends RepresentationModel<Envio> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_envio")
    private Integer idEnvio;

    @Column(name = "id_venta", nullable = false)
    private Integer idVenta;

    @Column(name = "estado_envio", nullable = false, length = 30)
    private String estadoEnvio;

    @Column(name = "fecha_envio", nullable = false)
    private LocalDate fechaEnvio;

    @Column(name = "fecha_entrega", nullable = false)
    private LocalDate fechaEntrega;

    @Column(name = "id_direccion", nullable = false)
    private Integer idDireccion;
}

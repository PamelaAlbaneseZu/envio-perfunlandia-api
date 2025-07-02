package com.perfunlandia.gestionenvioapi.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
public class EnvioDTO extends RepresentationModel<EnvioDTO>
{
    private Integer idEnvio;
    private Integer idVenta;
    private String estadoEnvio;
    private LocalDate fechaEnvio;
    private LocalDate fechaEntrega;
    private Integer idDireccion;
}
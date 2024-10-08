package com.keysolbo.coreservice.model;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ArchivosCargados {
    private int nsArchivosCargadosId;
    private String nombreArchivo;
    private Integer cantidadFilaArchivo;
    private String serviceComplain;
    private String status;
    private Timestamp recordDate;
}

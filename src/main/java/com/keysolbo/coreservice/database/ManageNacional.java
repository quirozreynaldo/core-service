package com.keysolbo.coreservice.database;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.keysolbo.coreservice.model.ArchivosCargados;
import com.keysolbo.coreservice.model.Procesos;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ManageNacional {
    @Autowired
    @Qualifier("coreTemplate")
    private JdbcTemplate jdbcTemplate;

    public List<ArchivosCargados> retrieveArchivosCargados() {
        String sqlSelect = "SELECT ns_archivos_cargos_id, nombre_archivo, cantidad_fila_archivo, service_complain, status, record_date "
                +
                " FROM deaxs_record.ns_archivos_cargados " +
                " WHERE status!= 'I' " +
                " ORDER BY record_date DESC";
        List<ArchivosCargados> result = new ArrayList<>();
        try {
            result = jdbcTemplate.query(sqlSelect, (rs, row) -> new ArchivosCargados(rs.getInt("ns_archivos_cargos_id"),
                    rs.getString("nombre_archivo"),
                    rs.getInt("cantidad_fila_archivo"),
                    rs.getString("service_complain"),
                    rs.getString("status"),
                    rs.getTimestamp("record_date")), new String[] {});
        } catch (Exception ex) {
            log.error("retrieveArchivosCargados fail", ex);
        }
        return result;
    }

    public List<ArchivosCargados> retrieveArchivosCargados(String serviceComplain) {
        String sqlSelect = "SELECT ns_archivos_cargos_id, nombre_archivo, cantidad_fila_archivo, service_complain, status, record_date "
                +
                " FROM deaxs_record.ns_archivos_cargados " +
                " WHERE status!= 'I' " +
                " AND service_complain = ? " +
                " ORDER BY record_date DESC";
        List<ArchivosCargados> result = new ArrayList<>();
        try {
            result = jdbcTemplate.query(sqlSelect, (rs, row) -> new ArchivosCargados(rs.getInt("ns_archivos_cargos_id"),
                    rs.getString("nombre_archivo"),
                    rs.getInt("cantidad_fila_archivo"),
                    rs.getString("service_complain"),
                    rs.getString("status"),
                    rs.getTimestamp("record_date")), new String[] { serviceComplain });
        } catch (Exception ex) {
            log.error("retrieveArchivosCargados(serviceComplain) fail", ex);
        }
        return result;
    }

    public List<Procesos> retrieveAllServiceComplain() {
        String sqlSelect = "SELECT DISTINCT service_complain " +
                " FROM deaxs_record.ns_archivos_cargados " +
                " WHERE status != 'I' " +
                " ORDER BY 1 ASC";

        List<Procesos> serviceComplainList = new ArrayList<>();

        try {
            serviceComplainList = jdbcTemplate.query(
                    sqlSelect,
                    (rs, rowNum) -> new Procesos(rs.getString("service_complain")), // Mapeo a objetos Procesos
                    new String[] {}); // Parámetros adicionales, en este caso no hay ninguno
        } catch (Exception ex) {
            log.error("retrieveAllServiceComplain fail", ex);
        }

        return serviceComplainList;
    }

}

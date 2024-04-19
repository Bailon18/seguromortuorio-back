package com.seguro.app.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.seguro.app.model.entidad.Aportacion;
import com.seguro.app.model.servicio.AportacionService;
import com.seguro.app.model.servicio.SocioService;
import com.seguro.app.util.DTO.ReporteDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apifm/aportaciones")
@CrossOrigin(origins = "*")
public class AportacionController {

    @Autowired
    private AportacionService aportacionService;

    @Autowired
    private SocioService socioService;

    @GetMapping
    public ResponseEntity<List<Aportacion>> getAllAportaciones() {
        List<Aportacion> aportaciones = aportacionService.findAllAportaciones();
        if (aportaciones.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(aportaciones, HttpStatus.OK);
        }
       
    }

    @GetMapping("/{aportacionId}")
    public ResponseEntity<Optional<Aportacion>> getAportacionById(@PathVariable Long aportacionId) {
        Optional<Aportacion> aportacion = aportacionService.findAportacionById(aportacionId);
        if (aportacion.isPresent()) {
            return new ResponseEntity<>(aportacion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Aportacion> createAportacion(@RequestBody Aportacion aportacion) {
        Aportacion nuevaAportacion = aportacionService.saveAportacion(aportacion);
        return new ResponseEntity<>(nuevaAportacion, HttpStatus.CREATED);
    }

    @DeleteMapping("/{aportacionId}")
    public ResponseEntity<Void> deleteAportacion(@PathVariable Long aportacionId) {
        aportacionService.deleteAportacion(aportacionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("/aportacion-aho")
    public List<Integer> findDistinctYearsBySocioId(@RequestParam Long socioId) {
        return aportacionService.findDistinctYearsBySocioId(socioId);
    }
    
    @GetMapping("/por-ano-y-socio")
    public List<Aportacion> getAportacionesPorAnioYIdSocio(
            @RequestParam Integer year,
            @RequestParam Long socioId
    ) {
        return aportacionService.getAportacionesPorAnioYIdSocio(year, socioId);
    }


    @GetMapping("/reportes")
    public List<ReporteDTO> getReportes() {

        double ingresosTotalesMensuales = aportacionService.obtenerIngresosTotalesMensuales();
        double ingresosTotalesAnuales = aportacionService.obtenerIngresosTotalesAnuales();
        long totalAportacionesRealizadas = aportacionService.obtenerTotalAportacionesRealizadas();
        long numeroSociosActivosTotales = socioService.obtenerNumeroSociosActivosTotales();

        ReporteDTO reporteDTO = new ReporteDTO();
        reporteDTO.setIngresosTotalesMensuales(ingresosTotalesMensuales);
        reporteDTO.setIngresosTotalesAnuales(ingresosTotalesAnuales);
        reporteDTO.setTotalAportacionesRealizadas(totalAportacionesRealizadas);
        reporteDTO.setNumeroSociosActivosTotales(numeroSociosActivosTotales);

        return List.of(reporteDTO);
    }

    @GetMapping("/montos-por-mes")
    public ResponseEntity<List<Object[]>> obtenerMontosPorMesyAhoActual() {
        List<Object[]> montosPorMes = aportacionService.obtenerMontosPorMesyAhoActual();
        return ResponseEntity.ok(montosPorMes);
    }
    

    @GetMapping("/filtro/{socioId}")
    public ResponseEntity<List<Aportacion>> findAportacionesBySocioAndDateRange(
            @PathVariable Long socioId,
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate) {

        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);

        List<Aportacion> aportaciones = aportacionService.findAportacionesBySocioAndDateRange(socioId, start, end);

        return new ResponseEntity<>(aportaciones, HttpStatus.OK);
    }
}

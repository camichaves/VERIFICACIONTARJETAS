package validaciontarjetas.web.rest;

import validaciontarjetas.domain.*;
import validaciontarjetas.repository.TarjetaRepository;
import validaciontarjetas.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Annotation;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import java.time.*;
import java.time.format.DateTimeFormatter;


/**
 * REST controller for managing {@link validaciontarjetas.domain.Tarjeta}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class TarjetaResource {

    private final Logger log = LoggerFactory.getLogger(TarjetaResource.class);

    private static final String ENTITY_NAME = "verificacionTarjeta";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final TarjetaRepository tarjetaRepository;

    public TarjetaResource(TarjetaRepository tarjetaRepository) {
        this.tarjetaRepository = tarjetaRepository;
    }

    /**
     * {@code POST  /tarjetas} : Create a new tarjeta.
     *
     * @param tarjeta the tarjeta to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new tarjeta, or with status {@code 400 (Bad Request)} if the tarjeta has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
     /*
    @PostMapping("/tarjetas")
    public ResponseEntity<Tarjeta> createTarjeta(@RequestBody Tarjeta tarjeta) throws URISyntaxException {
        log.debug("REST request to save Tarjeta : {}", tarjeta);
        if (tarjeta.getId() != null) {
            throw new BadRequestAlertException("A new tarjeta cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Tarjeta result = tarjetaRepository.save(tarjeta);
        return ResponseEntity.created(new URI("/api/tarjetas/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }
    */
    /**
     * {@code PUT  /tarjetas} : Updates an existing tarjeta.
     *
     * @param tarjeta the tarjeta to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated tarjeta,
     * or with status {@code 400 (Bad Request)} if the tarjeta is not valid,
     * or with status {@code 500 (Internal Server Error)} if the tarjeta couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
     /*
    @PutMapping("/tarjetas")
    public ResponseEntity<Tarjeta> updateTarjeta(@RequestBody Tarjeta tarjeta) throws URISyntaxException {
        log.debug("REST request to update Tarjeta : {}", tarjeta);
        if (tarjeta.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Tarjeta result = tarjetaRepository.save(tarjeta);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, tarjeta.getId().toString()))
            .body(result);
    }
    */
    /**
     * {@code GET  /tarjetas} : get all the tarjetas.
     *

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of tarjetas in body.
     */

     /*
    @GetMapping("/tarjetas")
    public List<Tarjeta> getAllTarjetas() {
        log.debug("REST request to get all Tarjetas");
        return tarjetaRepository.findAll();
    }

    */
    /**
     * {@code GET  /tarjetas/:id} : get the "id" tarjeta.
     *
     * @param id the id of the tarjeta to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the tarjeta, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/tarjetas/{id}")
    public ResponseEntity<Tarjeta> getTarjeta(@PathVariable Long id) {
        log.debug("REST request to get Tarjeta : {}", id);
        Optional<Tarjeta> tarjeta = tarjetaRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(tarjeta);
    }

    @PostMapping("/tarjeta")
    public ResponseEntity<Object> validarTarjeta(@RequestBody Tarjeta tarjetaId){

        System.out.println(tarjetaId.toString());

         Optional<Tarjeta> tarjeta = tarjetaRepository.findById(tarjetaId.getId());

        if (tarjeta.isPresent()){
            LocalDate today = LocalDate.now();
            String formato = today.format(DateTimeFormatter.ofPattern("yyyyMM"));
                System.out.println(formato);
                System.out.println(tarjeta);
                 if(tarjeta.get().getFechaVencimiento() >= Integer.parseInt(formato)){
                     // responder HTTP 201
                     System.out.println("todo ok");
                     Respuesta rta = new Respuesta(21, "Tarjeta valida" );
                     return ResponseEntity.status(201).body(rta);
                 }
                 else{
                     System.out.println("tarjeta vencida");
                     RespuestaError re = new RespuestaError(21, "Tarjeta vencida" );
                     return ResponseEntity.status(306).body(re);
                 }
        }else{
            //HTTP 403

            RespuestaError re = new RespuestaError(20, "No existe la tarjeta" );
            System.out.println("No existe la tarjeta");
            //return ResponseEntity.status(403).body(re);
            return ResponseEntity.status(306).body(re);
        }
         
    }



    @PostMapping("/monto")
    public ResponseEntity<Object> validarMonto(@RequestBody Map<String,String> requestParams){


        Optional<Tarjeta> tarjeta = tarjetaRepository.findById(Long. parseLong(requestParams.get("id")));
        if (tarjeta.isPresent()){

            if(tarjeta.get().getMontoMax()>Double.parseDouble(requestParams.get("monto"))|| Double.parseDouble(requestParams.get("monto"))<5000){
                // responder HTTP 201
                System.out.println("todo ok");
                Respuesta rta = new Respuesta(22, "Monto valido" );
                return ResponseEntity.status(201).body(rta);
            }
            else{
                System.out.println("Monto maximo superado");
                RespuestaError re = new RespuestaError(30, "Monto maximo superado" );

                return ResponseEntity.status(306).body(re);
            }
        }else{
            //HTTP 403

            RespuestaError re = new RespuestaError(20, "No existe la tarjeta" );
            System.out.println("No existe la tarjeta");
            return ResponseEntity.status(306).body(re);
        }
    }
    /**
     * {@code DELETE  /tarjetas/:id} : delete the "id" tarjeta.
     *
     * @param id the id of the tarjeta to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */


  /*  @DeleteMapping("/tarjetas/{id}")
    public ResponseEntity<Void> deleteTarjeta(@PathVariable Long id) {
        log.debug("REST request to delete Tarjeta : {}", id);
        tarjetaRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
 */
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oilcol.rest.resources;

import dto.CampoDTO;
import dto.PozoDTO;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import models.Competitor;
import dto.CompetitorDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import models.CampoEntity;
import models.PozoEntity;
import oilcol.providers.StatusCreated;
import org.codehaus.jettison.json.JSONObject;
import org.example.api.IOilcolService;

/**
 *
 * @author Mauricio
 */
@Path("oilcol")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OilcolService {

    @Inject
    private IOilcolService oilcolServiceLogic;
    

    /* @PostConstruct
    public void init() {
        try {
            entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } */
    
   @GET
    @Path("/getCampos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return oilcolServiceLogic.getAll();
    } 
    
    @POST
    @StatusCreated
    @Path("/addCampo")
    public CampoDTO createCampo(CampoDTO campo) {
      return oilcolServiceLogic.createCampo(campo);
    } 
    
    @GET
    @Path("/getPozos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPozos() {
    return oilcolServiceLogic.getAllPozos();
    }
    
    @POST
    @StatusCreated
    @Path("/addCampoYpozos")
    public CampoDTO createCampo2(CampoDTO campo) {
       return oilcolServiceLogic.createCampo2(campo);
    }
    
    
    @GET
    @Path("/getPozo/{id: \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPozo(@PathParam("id") Long id) {
       
    return oilcolServiceLogic.getPozo(id);
    } 
    
    @DELETE
    @Path("/deleteCampo/{id: \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCampo(@PathParam("id") Long id) {
    return oilcolServiceLogic.deleteCampo(id);
    }
    
    @GET
    @Path("/getCampo/{id: \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCampo(@PathParam("id") Long id) {
      return oilcolServiceLogic.getCampo(id);
    }
    
    
    @POST
    @Path("/addPozo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPozo(PozoDTO pozo) {
        return oilcolServiceLogic.createPozo(pozo);
    } 
    
    /*
    
    @GET
    @Path("/filtroPozos/{id: \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFiltroPozos(@PathParam("id") String id) {
    return oilcolServiceLogic.getFiltroPozos(id);
    }
    
     
    
    @GET
    @Path("/getPozo/{id: \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPozo(@PathParam("id") Long id) {
       
    return oilcolServiceLogic.getPozo(id);
    } 
    
    @DELETE
    @Path("/deleteCampo/{id: \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCampo(@PathParam("id") Long id) {
    return oilcolServiceLogic.deleteCampo(id);
    }
    
    
    @GET
    @Path("/getCampo/{id: \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCampo(@PathParam("id") Long id) {
      return oilcolServiceLogic.getCampo(id);
    }

   
    
   
    
    
    @POST
    @Path("/addCampoYpozos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCampo2(CampoDTO campo) {
       return oilcolServiceLogic.createCampo2(campo);
    } 
    
    
    @POST
    @Path("/addPozo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPozo(PozoDTO pozo) {
        return oilcolServiceLogic.createPozo(pozo);
    } 
    
    
    
    
    @PUT
    @Path("/editPozo/{id: \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePozo(@PathParam("id") Long id, PozoDTO pozo) {
    
      return oilcolServiceLogic.updatePozo(id, pozo);
    }
    
    
    @DELETE
    @Path("/deletePozo/{id: \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePozo(@PathParam("id") Long id) {
        return oilcolServiceLogic.deletePozo(id);
    }
    
     /*@POST
    @Path("/addCampo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCampo(CampoDTO campo) {
      return oilcolServiceLogic.createCampo(campo);
    } */
    
}

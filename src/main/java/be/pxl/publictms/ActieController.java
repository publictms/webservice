/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms;

import be.pxl.publictms.pojo.Actie;
import be.pxl.publictms.service.ActieService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller actie CRUD
 * @author Stijn Ceunen
 */
@Controller
@RequestMapping("actie")
public class ActieController {
    
    private static final Logger logger = LoggerFactory.getLogger(ActieController.class);
    
    @Autowired
    private ActieService actieService;
    /**
     * Voegt een actie toe aan de database
     * @param actie 
     */
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public @ResponseBody void add(@RequestBody Actie actie){
        actieService.addActie(actie);
    }
    /**
     * Geeft een actie terug aan de hand van zijn index.
     * @param id
     * @return List Actie
     */
    /*@RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List> getActiesVanOpdracht(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response){
        List<Actie> json = actieService.getActiesVanOpdracht(id);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<List>(json, responseHeaders, HttpStatus.CREATED);
    }*/
    /**
     * Geeft alle acties per opdracht zonder indexen maar als bruikbaar gegeven.
     * @param id
     * @return List<Actie>
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List> getActiesPerOpdracht(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response){
        List<Actie> json = actieService.getActiesPerOpdracht(id);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<List>(json, responseHeaders, HttpStatus.CREATED);
    }
    /**
     * Delete een actie in de database aan de hand van zijn index.
     * @param id 
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public @ResponseBody void delete(@PathVariable("id") int id){
        actieService.deleteActie(id);
    }
    /**
     * Bewerkt een actie in de database.
     * @param actie 
     */
    @RequestMapping(value = "/",method = RequestMethod.PUT)
    public @ResponseBody void update(@RequestBody Actie actie){
        actieService.updateActie(actie);
    }
    /**
     * Verander de status van een actie
     * @param opdracht 
     */
    @RequestMapping(value = "/{id}/{klaar}", method = RequestMethod.GET)
    public @ResponseBody void updateStatus(@PathVariable("klaar") int klaar,@PathVariable("id") int id){
        if(klaar == 1){
            actieService.setKlaar(true, id);
        }else if(klaar == 0){
            actieService.setKlaar(false, id);
        }
    }
    /**
     * Geeft foutmeldingen terug
     * @param ex
     * @return String
     */
    @ExceptionHandler(Exception.class)
    public @ResponseBody String handleUncaughtException(Exception ex){
        System.out.println(ex.toString());
        return ex.toString();
    }  
}

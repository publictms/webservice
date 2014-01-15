/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms;

import be.pxl.publictms.pojo.Opdracht;
import be.pxl.publictms.service.OpdrachtService;
import be.pxl.publictms.view.OpdrachtView;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller voor het verwerken van een opdracht. 
 * @author Stijn Ceunen, Laurens Putseys
 */
@Controller
@RequestMapping("opdracht")
public class OpdrachtController {
    
    private static final Logger logger = LoggerFactory.getLogger(OpdrachtController.class);
    
    @Autowired
    private OpdrachtService opdrachtService;
    
    /**
     * Geeft een lijst terug met opdrachten.
     * @return 
     */
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public @ResponseBody List<OpdrachtView> getOpdracht(){
        return opdrachtService.getOpdrachten();
    }
    /**
     * Geeft een lijst met opdrachten terug, in deze methoden zijn de indexen 
     * veranderd met de werkelijke waarde. 
     * @return List
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public @ResponseBody List<OpdrachtView> getOpdrachten(@PathVariable("id") int id){
        return opdrachtService.getOpdrachtenWerknemer(id);
    }
    /**
     * Voeg een nieuwe opdracht aan de databank.
     * @param opdracht 
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody void addOpdracht(@RequestBody Opdracht opdracht){
        opdrachtService.addOpdracht(opdracht);
    }
    /**
     * Verwijder een opdracht aan de hand van zijn index.
     * @param id 
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void deleteOpdracht(@PathVariable("id") int id){
        opdrachtService.deleteOpdracht(id);
    }
    /**
     * Bewerk een bestaande opdracht.
     * @param opdracht 
     */
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public @ResponseBody void updateOpdracht(@RequestBody Opdracht opdracht){
        opdrachtService.updateOpdracht(opdracht);
    }
    
    /**
     * Verander de status van een opdracht
     * @param opdracht 
     */
    @RequestMapping(value = "/{id}/{klaar}", method = RequestMethod.GET)
    public @ResponseBody void updateStatus(@PathVariable("klaar") int klaar,@PathVariable("id") int id){
        if(klaar == 1){
            opdrachtService.setKlaar(true, id);
        }else if(klaar == 0){
            opdrachtService.setKlaar(false, id);
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

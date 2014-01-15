/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.pojo.Transportadres;

/**
 * Interface dat de methodes voor AdresServiceImpl declareert.
 * Deze zijn voor het toevoegen, verwijderen, updates en ophalen
 * van data uit de tabel "Transportadres".
 * 
 * @author Stijn
 */
public interface TransportadresService {
    
    /**
     * Declaratie van de methode voor het toevoegen van data aan de tabel Transportadres.
     * 
     * @param transportadres     POJO representatie van de data die toegevoegd wordt.
     */
    public void addTransportadres(Transportadres transportadres);
    
    /**
     * Declaratie van de methode voor het ophalen van een record uit de tabel
     * Transportadres met een bepaald id.
     * 
     * @param id    Het transportadresid van het record dat opgehaald moet worden.
     * @return      POJO van het opgehaalde data.
     */
    public Transportadres getTransportadres(int id);
    
    /**
     * Declaratie van de methode voor het verwijderen van een record uit de
     * tabel Transportadres.
     * 
     * @param id    Het transportadresid van het record dat verwijderd moet worden.
     */
    public void deleteTransportadres(int id);
    
    /**
     * Declaratie van de methode voor het updaten van een record uit de 
     * tabel Transportadres.
     * 
     * @param transportadres     POJO van de ge�pdate data.
     */
    public void updateTransportadres(Transportadres transportadres);
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.pojo.Werknemer;
import java.util.List;

/**
 * interface die methoden voorziet om werknemers toe te voegen, bewerken, 
 * verwijderen of op te vragen.
 * @author Laurens Putseys
 */
public interface WerknemerDAO {
    /**
     * Voeg een werknemer toe aan de hand van een werknemer object.
     * @param werknemer 
     */
    public void addWerknemer(Werknemer werknemer);
    /**
     * Geef een lijst terug met alle werknemers.
     * @return List Werknemer
     */
    public List<Werknemer> getWerknemers();
    /**
     * Verwijder een werknemer aan de hand van zijn index.
     * @param id 
     */
    public void deleteWerknemer(int id);
    /**
     * Bewerk een werknemer aan de hand van een werknmer object.
     * @param werknemer 
     */
    public void updateWerknemer(Werknemer werknemer);
}

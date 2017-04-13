/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.negocio;

import duoc.cl.entidades.Region;
import duoc.cl.persistencia.RegionDAO;
import java.util.List;

/**
 *
 * @author Mario
 */
public class RegionBO {
     private RegionDAO  objRegionDAO;
    
    public RegionBO() {
        this.objRegionDAO = new RegionDAO();
    }
    
    public List<Region> getAllRegiones() {
        return this.objRegionDAO.readElementos();
    }
    
   
}

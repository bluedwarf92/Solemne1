/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.negocio;

import duoc.cl.entidades.Ciudad;
import duoc.cl.persistencia.CiudadDAO;
import java.util.List;

/**
 *
 * @author Mario
 */
public class CiudadBO {
    private CiudadDAO  objCiudadDAO;
    
    public CiudadBO() {
        this.objCiudadDAO = new CiudadDAO();
    }
    
    public List<Ciudad> getAllCiudades() {
        return this.objCiudadDAO.readElementos();
    }
    
}

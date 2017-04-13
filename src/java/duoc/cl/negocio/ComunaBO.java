/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.negocio;

import duoc.cl.entidades.Comuna;
import duoc.cl.persistencia.ComunaDAO;
import java.util.List;

/**
 *
 * @author Mario
 */
public class ComunaBO {
    private ComunaDAO  objComunaDAO;
    
    public ComunaBO() {
        this.objComunaDAO = new ComunaDAO();
    }
    
    public List<Comuna> getAllComuna() {
        return this.objComunaDAO.readElementos();
    }
    
    public Comuna getComunaXcodigo(int codigo){
        return this.objComunaDAO.getComunaxCodigo(codigo);
    }
    
}

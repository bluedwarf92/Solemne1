/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.negocio;

import duoc.cl.entidades.Obra;
import duoc.cl.persistencia.ObraDAO;
import java.util.List;

/**
 *
 * @author Mario
 */
public class ObraBO {
    private ObraDAO  objObraDAO;
    
    public ObraBO() {
        this.objObraDAO = new ObraDAO();
    }
    
    public List<Obra> getAllObra() {
        return this.objObraDAO.readElementos();
    }
    
     public boolean addObra(Obra objObra){
        return this.objObraDAO.addElemento(objObra);
    }
     
    public boolean deleteObra(int codigo){
        return this.objObraDAO.deleteElemento(codigo);
    }
    
     public boolean update(Obra objObra){
        return this.objObraDAO.updateElemento(objObra);
    }
    
    
}

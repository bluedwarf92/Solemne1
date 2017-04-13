/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.negocio;

import duoc.cl.entidades.Tipo_Obra;
import duoc.cl.persistencia.Tipo_ObraDAO;
import java.util.List;

/**
 *
 * @author Mario
 */
public class TipoObraBO {
   private Tipo_ObraDAO  objTipoObraDAO;
   
    public TipoObraBO() {
        this.objTipoObraDAO = new Tipo_ObraDAO();
    }

    public List<Tipo_Obra> getAllTipoObra() {
        return this.objTipoObraDAO.readElementos();
    }
    
    public boolean addTipoObra(Tipo_Obra objTipoObra){
        return this.objTipoObraDAO.addElemento(objTipoObra);
    }
   
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.negocio;

import duoc.cl.entidades.Perfil;
import duoc.cl.persistencia.PerfilDAO;
import java.util.List;

/**
 *
 * @author Cami
 */
public class PerfilBO {

    private PerfilDAO objPerfilDAO;

    public PerfilBO() {
        this.objPerfilDAO = new PerfilDAO();
    }

    public List<Perfil> getAllPerfil() {
        return this.objPerfilDAO.readElementos();
    }
}

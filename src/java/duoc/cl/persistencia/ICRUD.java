/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.persistencia;

import java.util.List;

/**
 *
 * @author Cami
 */
public interface ICRUD {

    public boolean addElemento(Object objetoInsert);

    public List readElementos();

    public boolean updateElemento(Object objetoUpdate);

    public boolean deleteElemento(int codigo);
}

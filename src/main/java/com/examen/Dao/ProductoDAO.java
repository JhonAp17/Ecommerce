
package com.examen.Dao;

import com.examen.clases.Producto;
import org.springframework.data.repository.CrudRepository;


public interface ProductoDAO  extends CrudRepository<Producto, Long>{
    
}

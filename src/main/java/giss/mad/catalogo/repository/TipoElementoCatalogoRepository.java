package giss.mad.catalogo.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import giss.mad.catalogo.model.TipoElementoCatalogo;

@Repository
public interface TipoElementoCatalogoRepository extends
    JpaRepository<TipoElementoCatalogo, Integer> {

    List<TipoElementoCatalogo> findAllByDeletedIsNull();

    List<TipoElementoCatalogo> findAllByDeletedIsNull(Sort sort);

    TipoElementoCatalogo findByIdAndDeletedIsNull(Integer id);

    @Query("SELECT new giss.mad.catalogo.model.TipoElementoCatalogo (id) FROM TipoElementoCatalogo "
            + "WHERE deleted IS NULL")
    List<TipoElementoCatalogo> findAllTypes();

    @Query("SELECT new giss.mad.catalogo.model.TipoElementoCatalogo (id, name) FROM TipoElementoCatalogo "
            + "WHERE deleted IS NULL ORDER BY hierarchyLevel ASC")
    List<TipoElementoCatalogo> findOnlyTypes();


}

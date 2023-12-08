package giss.mad.catalogo.repository;

import giss.mad.catalogo.model.TipoUnidadOrganizativa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TipoUnidadOrganizativaRepository extends  JpaRepository<TipoUnidadOrganizativa, Integer> {

}

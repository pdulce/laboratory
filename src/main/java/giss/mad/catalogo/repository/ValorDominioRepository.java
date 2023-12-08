package giss.mad.catalogo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;

import giss.mad.catalogo.model.ValorDominio;

@Repository
public interface ValorDominioRepository extends JpaRepository<ValorDominio, Integer> {

    List<ValorDominio> findByName(String name);

    Page<ValorDominio> findAllByDeletedIsNull(Pageable pager);

    @Query("SELECT NEW giss.mad.catalogo.model.ValorDominio(v.id, v.name, '(' || a.code || ') ' "
            + "|| a.name, v.forCatalogue, v.forDelivery, v.deleted) FROM ValorDominio v "
            + "JOIN AtributoEje a ON v.axisAttributeId = a.id WHERE "
            + "(:name IS NULL OR v.name = :name)"
    )
    Page<ValorDominio> findAllHistoric(String name, Pageable pageable);

    List<ValorDominio> findAllByNameIsNotNullAndDeletedIsNull(Sort sort);

    ValorDominio findByIdAndDeletedIsNull(Integer id);

    ValorDominio findByIdAndNameIsNotNull(Integer id);

    ValorDominio findByAxisAttributeIdAndNameAndDeletedIsNull(Integer axisAttributeId, String name);

    List<ValorDominio> findAllByAxisAttributeId(Integer axisAttributeId);


}


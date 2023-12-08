package giss.mad.catalogo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import giss.mad.catalogo.model.AtributoEje;

@Repository
public interface AtributoEjeRepository extends JpaRepository<AtributoEje, Integer> {

    AtributoEje findByCodeAndDeletedIsNull(String code);

    List<AtributoEje> findByAxisAndDeletedIsNull(Integer axis, Sort sort);

    List<AtributoEje> findAllByDeletedIsNull();

    @Query("SELECT NEW giss.mad.catalogo.model.AtributoEje(a.id || '|' || a.multiple || '|' || a.regex, a.name, "
            + "a.code, a.axis, a.mandatory, a.deleted, a.creationDate) FROM AtributoEje a WHERE a.deleted IS NULL "
            + "ORDER BY a.name ASC"
    )
    List<AtributoEje> findAllActive();
    @Query("SELECT NEW giss.mad.catalogo.model.AtributoEje(a.id || '|' || a.multiple || '|' || a.regex, a.name, "
            + "a.code, a.axis, a.mandatory, a.deleted, a.creationDate) FROM AtributoEje a")
    Page<AtributoEje> findAllWithoutDomainValues(Pageable pageable);

    AtributoEje findByIdAndDeletedIsNull(Integer id);

    @Query("SELECT id FROM AtributoEje WHERE deleted IS NULL")
    List<Integer> findAllAttributesIds();

    List<AtributoEje> findAllByAxisAttributeCollateralIdAndDeletedIsNull(Integer axisAttributeCollateralId);

}


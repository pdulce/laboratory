package giss.mad.catalogo.repository;

import java.util.List;

import giss.mad.catalogo.model.filters.UnidadOrganizativaMinimal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import giss.mad.catalogo.model.Grupo;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Integer> {

    @Query("SELECT NEW giss.mad.catalogo.model.Grupo(gr.id, tu.name, gr.codigo, gr.name, parent.name, gr.deleted, "
            + "gr.creationDate) FROM Grupo gr "
            + "LEFT JOIN TipoUnidadOrganizativa tu ON gr.tipoId = tu.id "
            + "LEFT JOIN Grupo parent ON gr.parentGroupId = parent.id")
    Page<Grupo> findAllWithoutChildren(Pageable pageable);

    @Query("SELECT NEW giss.mad.catalogo.model.Grupo(gr.id, gr.tipoId, gr.codigo, gr.name, parent.id, parent.name) "
            + "FROM Grupo gr "
            + "LEFT JOIN Grupo parent ON gr.parentGroupId = parent.id WHERE "
            + "gr.id= :id"
    )
    Grupo getByIdWithoutChildren(Integer id);

    /***
     * final Integer id, final Integer tipo, final String codigo, final String name,
     *                  String parentGroupName, Integer deleted, Timestamp creationDate
     * @param order
     * @param direction
     * @return
     */

    @Query("SELECT new giss.mad.catalogo.model.filters.UnidadOrganizativaMinimal(gr.id, gr.codigo, gr.name, tu.name) "
            + "FROM Grupo gr LEFT JOIN TipoUnidadOrganizativa tu ON gr.tipoId = tu.id "
            + " WHERE gr.deleted IS NULL ORDER BY "
            + "CASE WHEN :order = 'codigo' AND :direction = 'DESC' THEN gr.codigo END DESC,"
            + "CASE WHEN :order = 'codigo' AND :direction = 'ASC' THEN gr.codigo END ASC,"
            + "CASE WHEN :order = 'name' AND :direction = 'DESC' THEN gr.name END DESC,"
            + "CASE WHEN :order = 'name' AND :direction = 'ASC' THEN gr.name END ASC")
    List<UnidadOrganizativaMinimal> findAllGroups(String order, String direction);

    @Query("SELECT new giss.mad.catalogo.model.Grupo(id, codigo, name, parentGroupId, tipoId, creationDate) "
            + "FROM Grupo WHERE deleted IS NULL ORDER BY codigo ASC")
    List<Grupo> findAllActiveGroups();

    @Query("SELECT name FROM TipoUnidadOrganizativa WHERE id = :id")
    String getTypeOfUnidadOrg(Integer id);

    Grupo findByCodigoAndDeletedIsNull(String codigo);

    Grupo findByIdAndDeletedIsNull(Integer id);
    List<Grupo> findAllByDeletedIsNull();

    @Query("SELECT g.id FROM Grupo g WHERE g.parentGroupId = :id")
    List<Integer> getAllChildrenIdsByParent(Integer id);

}


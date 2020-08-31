package lt.kb.que.dao;

import lt.kb.que.model.Specialist;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SpecialistDao extends JpaRepository<Specialist,Integer> {
    @Override
    @EntityGraph(attributePaths = {"tickets"})
    List<Specialist> findAll();

    @EntityGraph(attributePaths = {"tickets"})
    Optional<Specialist> findById(int id);
    @Query("select s from Specialist s where s.speciality= :filter")
    List<Specialist> findBySpeciality(@Param("filter") Enum filter);

    @Query("select s from Specialist s where s.userName= :filter")
    List<Specialist> findByUserName(@Param("filter") String filter);


}

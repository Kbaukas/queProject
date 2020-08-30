package lt.kb.que.service;

import lt.kb.que.dao.SpecialistDao;
import lt.kb.que.model.Specialist;
import lt.kb.que.util.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialistService {
    @Autowired
    SpecialistDao specialistDao;
    public List<Specialist> findAll(){
        return specialistDao.findAll();
    }

    public Optional<Specialist> findById(int id) {
        return specialistDao.findById(id);
    }
    public List<Specialist> findBySpeciality(Enum speciality) {
        return specialistDao.findBySpeciality(speciality);
    }
    public void addNewSpecialis(Specialist specialist){
        specialist.setRole(Role.WORKER);
        specialistDao.save(specialist);

    }
    public Specialist getSpecialistByUserName(String username){
      return   specialistDao.findByUserName(username).get(0);

    }

}

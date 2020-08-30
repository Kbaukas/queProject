package lt.kb.que.service;

import lt.kb.que.dao.SpecialistDao;
import lt.kb.que.model.Specialist;
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

}

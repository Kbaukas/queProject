package lt.kb.que.security;

import lt.kb.que.dao.SpecialistDao;
import lt.kb.que.model.Specialist;
import lt.kb.que.service.SpecialistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class SpecialistDetailsServiceImpl implements UserDetailsService {
    @Autowired
    SpecialistService specialistService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      Specialist specialist= specialistService.getSpecialistByUserName(username);
      if (specialist==null){
          throw new UsernameNotFoundException("No such User");
      }
      return new SpecialistDetails(specialist);
            }
}

package lt.kb.que.security;

import lt.kb.que.model.Specialist;
import lt.kb.que.util.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class SpecialistDetails implements UserDetails {
private Specialist specialist;

    public SpecialistDetails(Specialist specialist) {
        this.specialist = specialist;
    }

    @Override

    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities=new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(specialist.getRole().name()));
        return authorities;
    }

    @Override
    public String getPassword() {
        return specialist.getPassword();
    }

    @Override
    public String getUsername() {
        return specialist.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

package com.harish.assignment.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.harish.assignment.dao.UserRepository;

@Service
public class BankUserDetailsService implements UserDetailsService {
    
	@Autowired
    private UserRepository userRepo;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findOne(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        Set<UserRole> permissions = user.getUserRole();
        for (UserRole permission : permissions) {
            grantedAuthorities.add(new SimpleGrantedAuthority(permission.getRole()));
        }

        return new BankUserDetails(user, grantedAuthorities);
    }
}

package com.workintech.bankAuth.service;

import com.workintech.bankAuth.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    private MemberDao memberDao;
@Autowired
    public UserService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return memberDao.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("Member is not valid"));
    }
}

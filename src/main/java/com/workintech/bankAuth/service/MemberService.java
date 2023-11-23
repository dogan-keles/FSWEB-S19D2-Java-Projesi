package com.workintech.bankAuth.service;

import com.workintech.bankAuth.dao.MemberDao;
import com.workintech.bankAuth.dao.RoleDao;
import com.workintech.bankAuth.entity.Member;
import com.workintech.bankAuth.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private MemberDao memberDao;
    private RoleDao roleDao;

    private PasswordEncoder passwordEncoder;
@Autowired
    public MemberService(MemberDao memberDao, RoleDao roleDao, PasswordEncoder passwordEncoder) {
        this.memberDao = memberDao;
        this.roleDao = roleDao;
        this.passwordEncoder = passwordEncoder;
    }
    public Member register(String email, String password){
    Optional<Member> foundMember = memberDao.findByEmail(email);
    if(foundMember.isPresent()){
        throw new RuntimeException("User with given email is already exist, please log in.");
    }
    String encodedPasword = passwordEncoder.encode(password);
    Role userRole = roleDao.findByAuthority("User").get();
    List<Role> roleList = new ArrayList<>();
    roleList.add(userRole);
    Member member = new Member();
    member.setEmail(email);
    member.setPassword(encodedPasword);
    member.setAuthorities(roleList);
    return memberDao.save(member);


    }
}

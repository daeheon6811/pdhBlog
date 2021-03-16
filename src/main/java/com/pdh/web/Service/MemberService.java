package com.pdh.web.Service;

import com.pdh.web.Dto.MemberDto;
import com.pdh.web.domain.Role;
import com.pdh.web.entity.MemberEntity;
import com.pdh.web.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberService implements UserDetailsService {

    private MemberRepository memberRepository;
    /*회원 가입 */
    @Transactional
    public String joinUser(MemberDto memberDto) {

        Optional<MemberEntity> userEntityWrapper = memberRepository.findByEmail(memberDto.getEmail());


        if (userEntityWrapper.isEmpty()) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));
            //System.out.println(memberDto.toEntity().getBoardcount();
            return memberRepository.save(memberDto.toEntity()).getEmail();
        } else {

            return "존재";
        }
    }

    /*이메일 검색*/
    @Transactional
    public String searchemail(MemberDto memberDto) {
        Optional<MemberEntity> userEntityWrapper = memberRepository.findByEmail(memberDto.getEmail());
        if (userEntityWrapper.isEmpty()) {
            return "존재";
        } else {
            return "이메일성공";
        }
    }

    /*패스워드 새로 생성*/
    @Transactional
    public void rename_password(MemberDto memberDto) {

            Optional<MemberEntity> userEntityWrapper = memberRepository.findByEmail(memberDto.getEmail());
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));
            memberRepository.save(memberDto.toEntity());
    }

    /*유저 업데이트*/
    @Transactional
    public MemberDto update_user(MemberDto memberDto) {

        Optional<MemberEntity> userEntityWrapper = memberRepository.findByEmail(memberDto.getEmail());


        memberRepository.save(memberDto.toEntity());
        return memberDto;
    }

    @Transactional
    public int CheckPassword(MemberDto memberDto) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


        Optional<MemberEntity> userEntityWrapper = memberRepository.findByEmail(memberDto.getEmail());

        System.out.println("엔티티1" + userEntityWrapper.get().getEmail());

        if (userEntityWrapper.isPresent()) {

            System.out.println("엔티티2" + userEntityWrapper.get().getPassword());
            boolean result = passwordEncoder.matches(memberDto.getPassword(), userEntityWrapper.get().getPassword());

            if (result) {
                System.out.println(result);
                return 65536;
            } else {
                System.out.println(result);
                return 13132;
            }
        } else {
            System.out.println("존재하지 않는 아이뒤");
            return 88889;
        }
    }

    /*내 정보*/
    @Transactional
    public MemberDto MyInformation(User user) {
        Optional<MemberEntity> userEntityWrapper = memberRepository.findByEmail(user.getUsername());
        MemberEntity userEntity = userEntityWrapper.get();
        String email = userEntity.getEmail();
        String password = userEntity.getPassword();
        int warning = userEntity.getWarning();
        LocalDateTime createyear = userEntity.getCreateyear();
        String firstname = userEntity.getFirstname();
        String lastname = userEntity.getLastname();
        String phone = userEntity.getPhone();
        String location = userEntity.getLocation();
        return new MemberDto(email, password, warning, createyear, firstname, lastname, phone, location);

    }


    /*로그인 시도*/
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String Id) throws UsernameNotFoundException {
        Optional<MemberEntity> userEntityWrapper = memberRepository.findByEmail(Id);
        if (userEntityWrapper.isEmpty()) {
            System.out.println("유저 정보가 존재 하지 X");
            throw new UsernameNotFoundException(Id);
        }


        MemberEntity userEntity = userEntityWrapper.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        if (("admin@example.com").equals(Id)) {
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
        }
        return new User(userEntity.getEmail(), userEntity.getPassword(), authorities);
    }
}

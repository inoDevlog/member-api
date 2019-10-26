package ino.codelabs.member.sevice;

import ino.codelabs.member.entity.Member;
import ino.codelabs.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public List<Member> getAllMembers(){
        return memberRepository.findAll();
    }

    public Member getMember(Long id) {
        Member member = memberRepository.findById(id).orElse(null);

        if (member == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Member not found");
        } else {
            return member;
        }
    }
}



package ino.codelabs.member.controller;

import ino.codelabs.member.entity.Member;
import ino.codelabs.member.sevice.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MemberController {

    private MemberService memberService;

    @GetMapping("/members")
    public ResponseEntity<?> getAllMembers(){
        List<Member> members = memberService.getAllMembers();

        return ResponseEntity.ok(members);
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<?> getMember(@PathVariable Long id){
        Member member = memberService.getMember(id);

        return ResponseEntity.ok(member);
    }
}

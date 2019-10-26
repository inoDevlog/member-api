package ino.codelabs.member.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Table(name = "member")
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(name = "department_id")
    private Long departmentId;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Collection<Member> members;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "created_at")
    private LocalDateTime createAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "updated_at")
    private LocalDateTime updateAt;

    public void setCurrentTime() {
        this.createAt = LocalDateTime.now();
        this.updateAt = LocalDateTime.now();
    }

    public void update(Member member){
        this.name = member.getName();
        this.updateAt = LocalDateTime.now();
    }
}
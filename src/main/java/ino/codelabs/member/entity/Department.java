package ino.codelabs.member.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "department")
@Getter //추가할 변수들에 대해서 자동으로 getter를 만들어준다.
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(name = "create_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createAt;

    @Column(name = "update_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateAt;

    public void setCurrentTime(){
        this.createAt = LocalDateTime.now();
        this.updateAt = LocalDateTime.now();
    }

    public void update(Department department){
        this.name = department.getName();
        this.updateAt = LocalDateTime.now();
    }
}
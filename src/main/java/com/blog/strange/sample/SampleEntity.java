package com.blog.strange.sample;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
//@Entity // 좌측 어노테이션은 pom.xml 의 jpa 관련 dependency를 기반으로 한것이다. 만약 jdbc, mybatis 등 다른 DB접근 기술을 쓴다면 불필요하다.
//@NoArgsConstructor
@AllArgsConstructor
public class SampleEntity {
}

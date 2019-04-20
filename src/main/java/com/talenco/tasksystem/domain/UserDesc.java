package com.talenco.tasksystem.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * 用户描述信息
 *
 * @author echcz
 * @date 2019-04-16 22:29:00
 */
@Getter
@Setter
@NoArgsConstructor
@Document(collection = "userDesc")
public class UserDesc {
    /**
     * id
     */
    @Id
    private String id;
    /**
     * 名称
     */
    @Indexed(unique = true)
    private String name;
    /**
     * 描述
     */
    private String desc;
    /**
     * 标签s
     */
    private List<String> labels;
}

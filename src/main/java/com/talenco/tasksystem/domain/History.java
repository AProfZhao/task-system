package com.talenco.tasksystem.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 历史记录
 *
 * @author echcz
 * @date 2019-04-20 22:45:43
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "history")
public class History {
    public static final Integer TYPE_USER = 1;
    public static final Integer TYPE_SPACE = 2;
    public static final Integer TYPE_TASK = 3;
    public static final Integer TYPE_OTHER = 4;

    /**
     * id
     */
    @Id
    private String id;
    /**
     * 类型 1:用户管理，2:空间操作，3:任务处理，0:其它
     */
    @Indexed
    private Integer type;
    /**
     * 拥有者，是什么内容产生的此历史，或一些历史以什么做为关联
     * 可能是task，space，user
     */
    @Indexed
    private String owner;
    /**
     * 内容
     */
    private String content;
}

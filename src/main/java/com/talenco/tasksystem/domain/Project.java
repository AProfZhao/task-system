package com.talenco.tasksystem.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

/**
 * 项目
 * 包含模块(Module)
 *
 * @author echcz
 * @date 2019-04-22 09:54:44
 */
@Getter
@Setter
@NoArgsConstructor
@Document(collection = "project")
public class Project {
    public static final Integer STATE_READY = 1;
    public static final Integer STATE_ACTIVATE = 2;
    public static final Integer STATE_REVIEW = 3;
    public static final Integer STATE_DONE = 4;
    public static final Integer STATE_CLOSE = 5;
    public static final Integer STATE_EXCEPTION = 6;

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
     * 状态 1:待命，2:激活，3:审核，4:完成，5:关闭，6:异常
     */
    @Indexed
    private Integer state;
    /**
     * 状态描述
     */
    private String stateDesc;
    /**
     * 负责人ids
     */
    private List<String> principals;
    /**
     * 创建时间
     */
    private Long createTm;
    /**
     * 创建人
     */
    private String creator;
    /**
     * 预期完成时间
     */
    private Long tobeTm;
    /**
     * 实际完成时间
     */
    private Long doneTm;
    /**
     * 优先级
     * 值越大优先级越高
     */
    private Integer priority;
    /**
     * 拥有模块s
     * 模块名: 模块
     */
    private Map<String, Module> modules;
}

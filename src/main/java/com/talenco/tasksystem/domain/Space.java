package com.talenco.tasksystem.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 空间
 *
 * @author echcz
 * @date 2019-04-20 22:45:35
 */
@Getter
@Setter
@NoArgsConstructor
@Document(collection = "space")
public class Space {
    public static final int STATE_READY = 1;
    public static final int STATE_ACTIVATE = 2;
    public static final int STATE_REVIEW = 3;
    public static final int STATE_DONE = 4;
    public static final int STATE_CLOSE = 5;
    public static final int STATE_EXCEPTION = 6;
    /**
     * id
     */
    @Id
    private String id;
    /**
     * 父空间id,项目的父空间id为''
     */
    @Indexed
    private String pId;
    /**
     * 名称
     */
    private String name;
    /**
     * 描述
     */
    private String desc;
    /**
     * 状态 1:待命，2:激活，3:审核，4:完成，5:关闭，6:异常
     */
    @Indexed
    private int state;
    /**
     * 状态描述
     */
    private String stateDesc;
    /**
     * 负责人
     */
    @Indexed
    private String principal;
    /**
     * 创建时间
     */
    private long createTm;
    /**
     * 创建人
     */
    private String creator;
}

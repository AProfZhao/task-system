package com.talenco.tasksystem.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * 任务
 *
 * @author echcz
 * @date 2019-04-20 22:45:28
 */
@Getter
@Setter
@NoArgsConstructor
@Document(collection = "task")
public class Task {
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
     * 所属空间id
     */
    @Indexed
    private String space;
    /**
     * 标题
     */
    private String title;
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
     * 负责人id
     */
    @Indexed
    private String principal;
    /**
     * 管理人id列表
     */
    @Indexed
    private List<String> managers;
    /**
     * 处理人id列表
     */
    @Indexed
    private List<String> processors;
    /**
     * 处理信息id列表
     */
    private List<String> processInfos;
    /**
     * 创建时间
     */
    private long createTm;
    /**
     * 创建人
     */
    private String creator;
}

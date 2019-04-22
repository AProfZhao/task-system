package com.talenco.tasksystem.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 任务处理信息
 *
 * @author echcz
 * @date 2019-04-20 22:30:19
 */
@Getter
@Setter
@Document(collection = "taskProcessInfo")
public class TaskProcessInfo {
    public static final Integer STATE_PENDING = 1;
    public static final Integer STATE_PASS = 2;
    public static final Integer STATE_NOPASS = 3;

    /**
     * id
     */
    @Id
    private String id;
    /**
     * 所属任务id
     */
    @Indexed
    private String task;
    /**
     * 状态 1:待审核 2:通过 3:未通过
     */
    private Integer state;
    /**
     * 发送人/处理人id
     */
    private String sender;
    /**
     * 发送信息
     */
    private String sendInfo;
    /**
     * 发送时间
     */
    private Long sendTm;
    /**
     * 审核人/管理人id
     */
    private String reviewer;
    /**
     * 审核信息
     */
    private String reviewInfo;
    /**
     * 审核时间
     */
    private String reviewTm;
}

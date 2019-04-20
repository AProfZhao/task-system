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
    private long sendTm;
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

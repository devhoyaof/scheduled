package com.thread.scheduled.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardVO {

    private int no;
    private String type;
    private String title;
    private String contents;
    private String writer;
    private String createdTime;
    private String updatedTime;
    private int likes;
    private int counts;

}

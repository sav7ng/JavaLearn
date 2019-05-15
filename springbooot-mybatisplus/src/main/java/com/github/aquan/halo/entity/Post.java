package com.github.aquan.halo.entity;

import com.github.aquan.common.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
* <p>
    * 
    * </p>
*
* @author jobob
* @since 2019-05-15
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("halo_post")
public class Post extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long postId;

    private Integer allowComment;

    private String postContent;

    private String postContentMd;

    private LocalDateTime postDate;

    private Integer postStatus;

    private String postSummary;

    private String postThumbnail;

    private String postTitle;

    private String postType;

    private LocalDateTime postUpdate;

    private String postUrl;

    private Long postViews;

    private Long userId;

    private String customTpl;


}

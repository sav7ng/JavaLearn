package com.github.aquan.halo.service.impl;

import com.github.aquan.halo.entity.Post;
import com.github.aquan.halo.mapper.PostMapper;
import com.github.aquan.halo.service.IPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-05-15
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements IPostService {

}

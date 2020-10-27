package com.wj.blog.dao;

import com.wj.blog.po.Tag;
import com.wj.blog.po.Type;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description:
 * @author: WangJun
 * @time: 2020/10/27 14:53
 */
public interface TagRepository extends JpaRepository<Tag,Long> {
    Tag getTagByName(String name);
}


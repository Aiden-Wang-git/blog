package com.wj.blog.service;

import com.wj.blog.po.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: WangJun
 * @time: 2020/10/27 14:52
 */
public interface TagService {
    Page<Tag> listTag(Pageable pageable);

    Tag getTag(Long id);

    Tag getTagByName(String name);

    Tag saveTag(Tag tag);

    void deleteTag(Long id);

    Tag updateTag(Long id, Tag tag);
}

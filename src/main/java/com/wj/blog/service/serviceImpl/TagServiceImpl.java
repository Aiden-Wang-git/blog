package com.wj.blog.service.serviceImpl;

import com.wj.blog.NotFoundException;
import com.wj.blog.dao.TagRepository;
import com.wj.blog.dao.TypeRepository;
import com.wj.blog.po.Tag;
import com.wj.blog.po.Type;
import com.wj.blog.service.TagService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @description:
 * @author: WangJun
 * @time: 2020/10/27 14:52
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Transactional
    @Override
    public Page<Tag> listTag(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public Tag getTag(Long id) {
        return tagRepository.getOne(id);
    }

    @Transactional
    @Override
    public Tag getTagByName(String name) {
        return tagRepository.getTagByName(name);
    }

    @Transactional
    @Override
    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Transactional
    @Override
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Tag updateTag(Long id, Tag tag) {
        Tag t = tagRepository.findById(id).get();
        if (t==null){
            throw new NotFoundException("不存在该标签");
        }
        BeanUtils.copyProperties(tag,t);
        return tagRepository.save(t);
    }
}

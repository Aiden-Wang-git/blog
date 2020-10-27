package com.wj.blog.service;

import com.wj.blog.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: WangJun
 * @time: 2020/10/23 13:28
 */
public interface TypeService {
    Type saveType(Type type);
    Type getType(Long id);
    Page<Type> listType(Pageable pageable);
    Type updateType(Long id,Type type);
    void deleteType(Long id);
    Type getTypeByName(String name);
}

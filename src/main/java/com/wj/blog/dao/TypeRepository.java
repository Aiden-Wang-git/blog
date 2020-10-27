package com.wj.blog.dao;

import com.wj.blog.po.Type;
import org.aspectj.apache.bcel.util.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description:
 * @author: WangJun
 * @time: 2020/10/23 13:34
 */
public interface TypeRepository extends JpaRepository<Type,Long> {

    Type getTypeByName(String name);
}

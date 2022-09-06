package com.cn.wbg.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BaseMapper<T> {



    /**
     * 查询所有
     *
     * @return
     */
    List<T> getAll();

    /**
     * 通过 id 查询
     *
     * @param id
     * @return
     */
    T getById(Integer id);

    /**
     * 修改
     *
     * @param t
     * @return
     */
    Integer update(T t);

    /**
     * 添加
     *
     * @param t
     * @return
     */
    Integer add(T t);

    /**
     * 根据 id 删除
     *
     * @param id
     * @return
     */
    Integer remove(Integer id);
}

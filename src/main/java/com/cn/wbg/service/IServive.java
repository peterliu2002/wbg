package com.cn.wbg.service;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IServive<T> {

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

package com.cn.wbg.service.impl;

import com.cn.wbg.mapper.BaseMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiaoliu
 * @ClassName BaseServiceImpl
 * @date 2021/11/1 11:25
 */
@Service
public abstract class ServiceImpl<T> implements BaseMapper<T> {




    /**
     * 定义抽象方法，要求子类必须实例化 baseMapper
     *
     * @return
     */
    protected abstract BaseMapper<T> baseMapper();

    /**
     * 获取所有
     *
     * @return
     */
    @Override
    public List<T> getAll() {
        return baseMapper().getAll();
    }

    /**
     * 通过 id 获取
     *
     * @param id
     * @return
     */
    @Override
    public T getById(Integer id) {
        return baseMapper().getById(id);
    }

    /**
     * 修改
     *
     * @param t
     * @return
     */
    @Override
    public Integer update(T t) {
        return baseMapper().update(t);
    }

    /**
     * 添加
     *
     * @param t
     * @return
     */
    @Override
    public Integer add(T t) {
        return baseMapper().add(t);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    public Integer remove(Integer id) {
        return baseMapper().remove(id);
    }
}

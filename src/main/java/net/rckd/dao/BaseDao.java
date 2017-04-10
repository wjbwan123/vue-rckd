package net.rckd.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author hanyia
 * @date 2017年04月08日
 */
public interface BaseDao<T> {
    void save(T t);

    void save(Map<String, Object> map);

    void saveBatch(List<T> list);

    int update(T t);

    int update(Map<String, Object> map);

    int delete(Object id);

    int delete(Map<String, Object> map);

    int deleteBatch(Object[] id);

    T queryById(@Param("id") Object id);

    List<T> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    int queryTotal();
}

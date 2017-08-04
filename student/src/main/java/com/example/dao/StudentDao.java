package com.example.dao;

import com.example.entity.Student;

/**
 * Created by shengliyi on 2017/4/2.
 */
public interface StudentDao {
    /**
     * 添加
     * @param student
     * @return
     */
    int save(Student student);

    /**
     * 删除
     * @param id
     * @return
     */
    int remove(long id);

    /**
     * 修改
     * @param student
     * @return
     */
    int update(Student student);

    /**
     * 通过 id 查询
     * @param id
     * @return
     */
    Student getStudentById(long id);
}

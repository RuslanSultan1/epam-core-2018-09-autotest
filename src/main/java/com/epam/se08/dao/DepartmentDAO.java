package com.epam.se08.dao;

import com.epam.se08.model.Department;

import java.util.Collection;

public interface DepartmentDAO {

    void create(Department department);

    Department get(int id);

    Collection<Department> getAll();

    void update(Department department);

    void delete(Department department);
}

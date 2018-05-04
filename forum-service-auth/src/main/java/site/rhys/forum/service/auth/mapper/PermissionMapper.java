package site.rhys.forum.service.auth.mapper;


import site.rhys.forum.common.pojo.Permission;

public interface PermissionMapper {

    Permission selectById(Long id);

    void add(Permission permission);
}
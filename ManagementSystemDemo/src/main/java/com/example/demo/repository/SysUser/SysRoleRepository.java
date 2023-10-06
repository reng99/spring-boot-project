package com.example.demo.repository.SysUser;

import com.example.demo.entity.sysuser.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysRoleRepository extends JpaRepository<SysRole, Long> {
    SysRole findByRole(String name);
}

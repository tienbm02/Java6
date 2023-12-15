package BMTJ6_ASM.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import BMTJ6_ASM.entity.Role;

public interface RoleDAO extends JpaRepository<Role, String> {
	

}

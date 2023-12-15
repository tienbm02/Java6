package BMTJ6_ASM.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import BMTJ6_ASM.entity.TaiKhoan;

@Repository
public interface TaiKhoanDAO extends JpaRepository<TaiKhoan, String>{

}
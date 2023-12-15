package BMTJ6_ASM.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import BMTJ6_ASM.entity.DonHang;

public interface DonHangDAO extends JpaRepository<DonHang, Integer> {
//	@Query("SELECT o FROM Order o WHERE o.account.username=?1")
//	List<DonHang> findByUsername(String username);
}
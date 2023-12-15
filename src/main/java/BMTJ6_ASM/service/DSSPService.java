package BMTJ6_ASM.service;

import java.util.List;

import BMTJ6_ASM.entity.DSSP;

public interface DSSPService {

	List<DSSP> findAll();

	DSSP findById(Integer IDSP);

	DSSP create(DSSP sanpham);

	DSSP update(DSSP sanpham);

	void delete(Integer id);

}

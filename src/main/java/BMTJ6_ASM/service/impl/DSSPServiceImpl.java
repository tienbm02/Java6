package BMTJ6_ASM.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BMTJ6_ASM.entity.DSSP;
import BMTJ6_ASM.dao.DSSPDAO;
import BMTJ6_ASM.service.DSSPService;

@Service
public class DSSPServiceImpl implements DSSPService {
	@Autowired
	DSSPDAO dsspDao;

	@Override
	public List<DSSP> findAll() {
		return dsspDao.findAll();
	}

	@Override
	public DSSP findById(Integer IDSP) {
		return dsspDao.findById(IDSP).get();
	}

	@Override
	public DSSP create(DSSP sanpham) {
		return dsspDao.save(sanpham);
	}

	@Override
	public DSSP update(DSSP sanpham) {
		return dsspDao.save(sanpham);
	}

	@Override
	public void delete(Integer id) {
		 dsspDao.deleteById(id);
	}

}

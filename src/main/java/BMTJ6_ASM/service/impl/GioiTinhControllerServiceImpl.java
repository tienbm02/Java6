package BMTJ6_ASM.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BMTJ6_ASM.entity.GioiTinh;
import BMTJ6_ASM.dao.GioiTinhDAO;
import BMTJ6_ASM.service.GioiTinhControllerService;

@Service
public class GioiTinhControllerServiceImpl implements GioiTinhControllerService {
	@Autowired
	GioiTinhDAO GTDao;

	@Override
	public List<GioiTinh> fillAll() {
		return GTDao.findAll();
	}

}

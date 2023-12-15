package BMTJ6_ASM.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BMTJ6_ASM.entity.Size;
import BMTJ6_ASM.dao.SizeDAO;
import BMTJ6_ASM.service.SizeControllerService;

@Service
public class SizeControllerServiceImpl implements SizeControllerService {
	@Autowired
	SizeDAO sizeDao;

	@Override
	public List<Size> fillAll() {	
		return sizeDao.findAll();
	}

}

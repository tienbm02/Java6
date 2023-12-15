package BMTJ6_ASM.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BMTJ6_ASM.entity.ThuongHieu;
import BMTJ6_ASM.dao.ThuongHieuDAO;
import BMTJ6_ASM.service.ThuongHieuService;

@Service
public class ThuongHieuServicelmpl implements ThuongHieuService {
	@Autowired
	ThuongHieuDAO thuongHieuDAO;

	@Override
	public List<ThuongHieu> findAll() {
		return thuongHieuDAO.findAll();
	}
	
}

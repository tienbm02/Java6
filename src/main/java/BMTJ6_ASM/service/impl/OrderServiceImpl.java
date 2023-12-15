package BMTJ6_ASM.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import BMTJ6_ASM.entity.ChiTietDonHang;
import BMTJ6_ASM.entity.DonHang;
import BMTJ6_ASM.dao.ChiTietDonHangDAO;
import BMTJ6_ASM.dao.DonHangDAO;
import BMTJ6_ASM.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	DonHangDAO dao;

	@Autowired
	ChiTietDonHangDAO ddao;
	
	@Override
	public DonHang create(JsonNode orderData) {
		ObjectMapper mapper = new ObjectMapper(); //nhận chuyển đổi json thành đối tượng cần thiết
		DonHang order = mapper.convertValue(orderData, DonHang.class);
		dao.save(order);
		
		TypeReference<List<ChiTietDonHang>> type = new TypeReference<List<ChiTietDonHang>>(){};
		List<ChiTietDonHang> details = mapper.convertValue(orderData.get("chitietdonhang"), type)// lấy chiTietDonHang bên trong orderData 
				//convertValue để đọc json chuyển sang list chitietDonhang
		.stream().peek(d -> d.setDONHANG(order)).collect(Collectors.toList());
		ddao.saveAll(details);
		return order;
	}
	
	@Override
	public DonHang findById(Integer IDDonHang) {
		return dao.findById(IDDonHang).get();
	}
	
}
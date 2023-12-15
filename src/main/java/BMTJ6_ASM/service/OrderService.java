package BMTJ6_ASM.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import BMTJ6_ASM.entity.DonHang;

public interface OrderService {
	DonHang create(JsonNode orderData);
	DonHang findById(Integer IDDonHang);
	
//	List<DonHang> findByUsername(String username);
}

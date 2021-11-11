package com.amazon.market.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.amazon.market.user.dto.BuyerDTO;
import com.amazon.market.user.dto.SellerDTO;
import com.amazon.market.user.entity.Buyer;
import com.amazon.market.user.entity.Seller;
import com.amazon.market.user.exception.AmazonMarketException;
import com.amazon.market.user.repository.BuyerRepository;
import com.amazon.market.user.repository.SellerRepository;
import com.amazon.market.user.service.BuyerService;
import com.amazon.market.user.service.SellerService;

@RunWith(SpringRunner.class)
//@SpringBootConfiguration
@SpringBootTest
public class UserMicroserviceApplicationTests {

//	
//		@Test
//		public void contextLoads() {
//		}
		@Mock
		BuyerRepository buyerRepository;
		@Mock
		SellerRepository sellerRepository;
		@InjectMocks
		BuyerService buyerService = new BuyerService();
		@InjectMocks
		SellerService sellerService = new SellerService();

		// Test for valid data
		@Test
		public void authenticateBuyerValid() throws AmazonMarketException {
			List<Buyer> buyerList = new ArrayList<Buyer>();

			Buyer buyerEntity = new Buyer();
			buyerEntity.setBuyerid("B100");
			buyerEntity.setEmail("sri@gmail.com");
			buyerEntity.setName("sri");
			buyerEntity.setPassword("Sri@9009");
			buyerEntity.setPhoneno("9009009001");
			buyerEntity.setIsprivileged(true);
			buyerEntity.setIsactive(true);
			buyerEntity.setRewardpoints(10000);
		//	Optional opt = Optional.of(buyerEnti);// Valid
			buyerList.add(buyerEntity);
			//Optional opt = Optional.of(buyerEntity);// Valid
			Optional buyerlist = Optional.of(buyerList);
			Mockito.when(buyerRepository.findAll()).thenReturn(buyerList);
			List<BuyerDTO> rePlans = buyerService.getAllBuyer();
			Assertions.assertEquals(rePlans.isEmpty(), buyerList.isEmpty());
		}

	// Test for Invalid data
	@Test
	public void authenticateBuyerInvalid() throws AmazonMarketException {
		List<Buyer> buyerList = new ArrayList<Buyer>();

		Buyer buyerEntity = new Buyer();

//
		buyerEntity.setBuyerid("B100");
		buyerEntity.setEmail("sri@gmail.com");
		buyerEntity.setName("sri");
		buyerEntity.setPassword("Sri@9009");
		buyerEntity.setPhoneno("9009009001");
		buyerEntity.setIsprivileged(true);
		buyerEntity.setIsactive(true);
		buyerEntity.setRewardpoints(10000);
	//	Optional opt = Optional.of(buyerEnti);// Valid
		buyerList.add(buyerEntity);
//		buyerEntity.setBuyerid("B10");
//		buyerEntity.setEmail("madhuri");
//		buyerEntity.setName("Madhi");
//		buyerEntity.setPassword("adhu@123");
//		buyerEntity.setPhoneno("909009001");
//		buyerEntity.setIsprivileged(true);
//		buyerEntity.setIsactive(true);
//		buyerEntity.setRewardpoints(20000);
//		
//		buyerList.add(buyerEntity);
		Optional opt = Optional.of(buyerEntity);// Valid

		Optional opt1 = Optional.empty();// Invalid

		Mockito.when(buyerRepository.findById(Mockito.anyString())).thenReturn(opt1);

//		Mockito.when(buyerRepository.findAll()).thenReturn(buyerList);
		List<BuyerDTO> rePlans = buyerService.getAllBuyer();
		Assertions.assertEquals(rePlans.isEmpty(), buyerList.isEmpty());
	}
}
//	}
//
//	@Test
//	public void authenticateSellerValid() throws InfyMarketException {
//		List<Seller> sellerList = new ArrayList<Seller>();
//
//		Seller sellerEntity = new Seller();
//		sellerEntity.setSellerid("1");
//		sellerEntity.setEmail("madhuri@gmail.com");
//		sellerEntity.setName("Madhuri");
//		sellerEntity.setPassword("Madhu@123");
//		sellerEntity.setPhoneno("7007007001");;
//		sellerEntity.setIsactive(true);
//
//		sellerList.add(sellerEntity);
//
//		Mockito.when(sellerRepository.findAll()).thenReturn(sellerList);
//		List<SellerDTO> rePlans = sellerService.getAllSeller();
//		Assertions.assertEquals(rePlans.isEmpty(), sellerList.isEmpty());
//	}
//	
//	@Test
//	public void authenticateSellerInValid() throws InfyMarketException {
//		List<Seller> sellerList = new ArrayList<Seller>();
//
//		Seller sellerEntity = new Seller();
//		sellerEntity.setSellerid("123");
//		sellerEntity.setEmail("madhuri@gmail.com");
//		sellerEntity.setName("Madhuri");
//		sellerEntity.setPassword("Madhu@123");
//		sellerEntity.setPhoneno("7007007001");;
//		sellerEntity.setIsactive(true);
//
//		Optional opt = Optional.of(sellerEntity);// Valid
//
//		Optional opt1 = Optional.empty();// Invalid
//
//		Mockito.when(buyerRepository.findById(Mockito.anyString())).thenReturn(opt);
//
//		Mockito.when(sellerRepository.findAll()).thenReturn(sellerList);
//		List<SellerDTO> rePlans = sellerService.getAllSeller();
//		Assertions.assertEquals(rePlans.isEmpty(), sellerList.isEmpty());
//	}
	
//	@Test
//	public void authenticateBuyerByIdValid() throws InfyMarketException {
////		List<Buyer> buyerList = new ArrayList<Buyer>();
//
//		Buyer buyerEntity = new Buyer();
//		String id = buyerEntity.getBuyerid();
//
////		buyerList.add(buyerEntity);
//
//		Mockito.when(buyerRepository.findById()).thenReturn(buyerList);
//		List<BuyerDTO> rePlans = buyerService.getAllBuyer();
//		Assertions.assertEquals(rePlans.isEmpty(), buyerList.isEmpty());
		
//		Buyer buyers = new Buyer();
//		buyers.setBuyerid("B100");
//		
//		Mockito.when(buyerRepository.findById("B100")).thenReturn(buyers);
//		BuyerDTO actual = buyerService.getBuyerById("B100");
//		Assertions.assertEquals("SUCCESS", actual);
//	}
	


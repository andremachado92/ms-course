package com.andremachado.hrpayrol.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andremachado.hrpayrol.entities.Payment;


@Service
public class PaymentService {
	
//	@Autowired
//	private WorkerFeignClient workerFeignClient;

	public Payment getPayment(long workerId, int days) {
				
//		Worker worker = workerFeignClient.findById(workerId).getBody();
		return new Payment("Bob",200.0,days);
	}
}
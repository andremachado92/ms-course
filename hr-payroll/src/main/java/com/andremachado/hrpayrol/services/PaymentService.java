package com.andremachado.hrpayrol.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.andremachado.hrpayrol.entities.Payment;
import com.andremachado.hrpayrol.entities.Worker;


@Service
public class PaymentService {
	
	@Value("${hr-worker.host}")
	private String workerHost;
	
	@Autowired
	private RestTemplate restTemplate;

	public Payment getPayment(long workerId, int days) {
		
		Worker worker = restTemplate.getForObject(workerHost +"/workers/"+workerId, Worker.class);
		return new Payment(worker.getName(),worker.getDailyInCome(),days);
	}
}
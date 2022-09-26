package com.andremachado.hrpayrol.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andremachado.hrpayrol.entities.Payment;
import com.andremachado.hrpayrol.entities.Worker;
import com.andremachado.hrpayrol.feignClients.WorkerFeignClients;


@Service
public class PaymentService {
		
	@Autowired
	private WorkerFeignClients workerFeignClients;

	public Payment getPayment(long workerId, int days) {
		
		Worker worker = workerFeignClients.findById(workerId).getBody();
		return new Payment(worker.getName(),worker.getDailyInCome(),days);
	}
}
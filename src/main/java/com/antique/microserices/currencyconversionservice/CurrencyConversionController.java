package com.antique.microserices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
//@Autowired
//private Environment environment;

@Autowired
private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;
private Logger logger = LoggerFactory.getLogger(this.getClass());

//@GetMapping("/currency-exchange/from/{from}/to/{to}/quantity/{quantity}")
//public CurrencyConversionBean getCurrencyConvertedValue(@PathVariable String from,
//		@PathVariable String to,
//		@PathVariable BigDecimal quantity) {
//	CurrencyConversionBean convertedValue = new CurrencyConversionBean(1000L, from, to, BigDecimal.valueOf(65), quantity, quantity.multiply(BigDecimal.valueOf(65)));
//	convertedValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
//	return convertedValue;
//	
//}

@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
public CurrencyConversionBean getCurrencyConvertedValue(@PathVariable String from,
		@PathVariable String to,
		@PathVariable BigDecimal quantity) {
	Map<String, String> uriVariables = new HashMap<>();
	uriVariables.put("from", from);
	uriVariables.put("to", to);
	ResponseEntity<CurrencyConversionBean> forEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, uriVariables);
	
	CurrencyConversionBean convertedValue = forEntity.getBody();
	convertedValue.setQuantity(quantity);
	convertedValue.setTotalCalculatedAmount(quantity.multiply(convertedValue.getConversionMultiplte()));
	return convertedValue;
	
}
//By Feign Client calling the Rest Services in Reusable manner i.e. currencyExchangeServiceProxy
@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
public CurrencyConversionBean getCurrencyConvertedValueByFeign(@PathVariable String from,
		@PathVariable String to,
		@PathVariable BigDecimal quantity) {
	
	CurrencyConversionBean convertedValue = currencyExchangeServiceProxy.retrieveExchangeValue(from, to);
	convertedValue.setQuantity(quantity);
	convertedValue.setTotalCalculatedAmount(quantity.multiply(convertedValue.getConversionMultiplte()));
	logger.info("{}",convertedValue);
	return convertedValue;
	
}
}

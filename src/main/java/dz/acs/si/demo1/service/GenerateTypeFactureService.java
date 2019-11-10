package dz.acs.si.demo1.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import dz.acs.si.demo1.model.TypeFacture;
import lombok.Getter;

@Component("generateTypeFactureService")
public class GenerateTypeFactureService {

	@Getter
	@Value("${typefacture.format.sep}")
	public String separ;

	@Getter
	@Value("${typefacture.idx.label}")  
	public int idxLabel;

	@Getter
	@Value("${typefacture.idx.value}")  
	private int idxValue;

	@Getter
	@Value("${typefacture.format.label.filter}")
	private String labelFilter;

	@Getter
	@Value("${typefacture.channel.ok}")
	private String channelTFOk;

	@Getter
	@Value("${typefacture.channel.ko}")
	private String channelTFKo;

	@Getter
	@Value("${typefacture.format.size}")  
	private int size;

	/**
	 * generate
	 * @param test
	 * @return TypeFacture
	 */
	public TypeFacture generate(String test) {
		TypeFacture tf = TypeFacture.NULL;
		//id, name, gender, dateOfBirth
		//String[] res = StringUtils.split(test, separ);
		String[] res = test.split(separ);
		if(res.length<size) {
			return TypeFacture.ERROR;
		}
		try {
			String label = res[idxLabel];
			String value = res[idxValue];
			if (label.startsWith(labelFilter)){
				tf = new TypeFacture(label, value);	
			}
		} catch (Exception e) {
			return TypeFacture.ERROR;
		}
		System.out.println("ACTIVATOR JMS!!! "+tf);
		return tf;
	}

	/**
	 * route
	 * @param tf
	 * @return string
	 */
	public String route(TypeFacture tf) {
		if(tf.equals(TypeFacture.ERROR) || tf.equals(TypeFacture.NULL)) {
			System.out.println("GenerateTypeFactureService.route() --> KO");
			return channelTFKo;
		}else {
			System.out.println("GenerateTypeFactureService.route()-->  OK");
			return channelTFOk;
		}		
	}
	public void out(Message<?> msg) {
		System.out.println("Messages --> "+msg);	
	}
	
	
	/**
	 * output ...
	 * @param tf
	 */
	public void out(TypeFacture tf) {
		System.out.println("PBs --> "+tf);	
	}
}

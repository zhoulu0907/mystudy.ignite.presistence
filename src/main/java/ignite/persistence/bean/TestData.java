package ignite.persistence.bean;

import lombok.Data;

@Data
public class TestData {
	private String name;
	private String value;
	
	public TestData(String name, String value) {
		this.name = name;
		this.value = value;
	}
}

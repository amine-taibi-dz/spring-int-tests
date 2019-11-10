package dz.acs.si.demo1.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeFacture implements Serializable{

	private static final long serialVersionUID = -941392945358588237L;
	public final static TypeFacture NULL = new TypeFacture(Integer.MAX_VALUE, "NULL_LABEL", "NULL_VALUE",0 );
	public final static TypeFacture ERROR = new TypeFacture(Integer.MIN_VALUE, "ERROR_LABEL", "ERROR_VALUE",0);
	private int id;
	private String label;
	private String value;
	private int done;
	public TypeFacture(String label, String value) {
		super();
		this.label = label;
		this.value = value;
	}
}

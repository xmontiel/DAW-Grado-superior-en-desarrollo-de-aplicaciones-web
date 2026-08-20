package javabean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "nombre")
@ToString(exclude = "direccion")
public class Contacto {
	
	private String nombre;
	private String telefono;
	private String direccion;
	

}

package rsvier;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Hond {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
//	@ManyToOne(fetch=FetchType.LAZY)
	@ManyToOne
	private Baas baas;



	@Override
	public String toString() {
//		return "Hond [id=" + id + ", baas=" + baas + "]";
		return "Hond [id=" + id + "]";
	}


	public void setBaas(Baas baas) {
		this.baas = baas;
	}
	
}

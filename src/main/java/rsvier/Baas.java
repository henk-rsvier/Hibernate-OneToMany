package rsvier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Baas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false, length=30)
	private String naam;
	
	@OneToMany(mappedBy="baas")
	private List<Hond> hondList = new ArrayList<>();
	

	public Baas() {}
	
	public Baas(String naam) {
		this.naam = naam;
	}
	
	public void addHond(Hond hond) {
		hondList.add(hond);
	}

	@Override
	public String toString() {
		// Als hondList ook wordt geprint 'ziet' EntityManager dat de honddata ook nodig is en haalt deze op 
//		return "Baas [id=" + id + ", naam=" + naam +  ", hondList=" + hondList +"]";
		return "Baas [id=" + id + ", naam=" + naam + "]";
	}


}
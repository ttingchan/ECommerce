package module;

import java.util.List;
import java.util.Objects;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="album")
public class Album {

	@ManyToOne
	@Column(name="authorId")
	private Author author;
	@OneToMany (mappedBy="song", fetch= FetchType.LAZY)
	private List<Song> songs;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Date issuing_date;
	private int price;
	private int num_like;
	private  String description;
	
	Album(Integer id, String name, Date issuing_date, int price, int num_like, String description)
	{
		this.id = id;
		this.name = name;
		this.issuing_date = issuing_date;
		this.price = price;
		this.num_like = num_like;
		this.description = description;
	}
	
	Integer getId()
	{
		return this.id;
	}
	
	String getName()
	{
		return this.name;
	}
	
	Date getIssuingDate()
	{
		return this.issuing_date;
	}
	
	int getPrice()
	{
		return this.price;
	}
	
	int getNumLike()
	{
		return this.num_like;
	}
	
	String getDescription()
	{
		return this.description;
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(this.id,this.name,this.issuing_date,this.price,this.num_like,this.description) ;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj == null)
		{
			return false;
		}
		
		if(getClass() != obj.getClass())
		{
			return false;
		}
		final Album other = (Album)obj;
		return Objects.equals(this.id, other.id)
				&& Objects.equals(this.name, other.name)
				&& Objects.equals(this.issuing_date, other.issuing_date)
				&& Objects.equals(this.price, other.price)
				&& Objects.equals(this.num_like, other.num_like)
				&& Objects.equals(this.description, other.description); 
						
	}
}

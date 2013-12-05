package module;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="author")
public class Author {
	
	@OneToMany(mappedBy="authorId",fetch=FetchType.LAZY)
	private List<Album> cds;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	Author(int id, String name)
	{
		this.id = id;
		this.name = name;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public String getname()
	{
		return this.name;
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(id,name);
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
		final Author other = (Author)obj;
		
		return Objects.equals(this.id, other.id)
				&& Objects.equals(this.name, other.name);
	}
}

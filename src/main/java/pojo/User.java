package pojo;

import java.util.List;
import java.util.Objects;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Entity;


@Entity
@Table(name="user")
public class User {

	@OneToMany(mappedBy="userId")
	private List<Comment> comments;
	@Id
	private int id;
	private String name;
	private String psw;
	
	User(int id, String name, String password)
	{
		this.id = id;
		this.name = name;
		this.psw = password;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getPsw()
	{
		return this.psw;
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(this.id,this.name,this.psw) ;
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
		final User other = (User)obj;
		return Objects.equals(this.id, other.id)
				&& Objects.equals(this.name, other.name)
				&& Objects.equals(this.psw, other.psw); 
						
	}
}

package pojo;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="type")
public class Type {

	@ManyToMany (fetch=FetchType.LAZY)
	@JoinTable(name="song", joinColumns = {
			@JoinColumn (name="song_id", nullable= false, updatable = false)},
			inverseJoinColumns ={@JoinColumn(name="id", nullable = false, updatable =false)})
	private List<Song> songs;
	@Id
	private int id;
	private String type;
	
	Type(int id, String type)
	{
		this.id = id;
		this.type = type;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public String getType()
	{
		return this.type;
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(id,type);
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj ==null)
		{
			return false;
		}
		if(getClass() != obj.getClass())
		{
			return false;
		}
		final Type other = (Type)obj;
		return Objects.equals(this.id, other.id)
				&& Objects.equals(this.type, other.type);
	}
}

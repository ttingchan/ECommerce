package module;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="song")
public class Song {

	@ManyToOne
	@Column(name="albumId")
	private Album album;
	
	@ManyToMany (fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable (name="Type", joinColumns ={
		@JoinColumn(name="typeId", nullable = false,updatable = false)},
		inverseJoinColumns ={@JoinColumn(name="id", nullable= false, updatable = false)})
	private List<Type> types;
	@OneToMany(mappedBy="Comment", fetch = FetchType.LAZY)
	private List<Comment> comments;
	@Id
	private int id;
	private String name;
	private int num_like;
	private String description;
}

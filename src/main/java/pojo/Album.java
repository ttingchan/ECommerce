package pojo;

import java.util.List;
import java.util.Objects;
import java.sql.Date;
import java.sql.Types;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private int id;
	private String name;
	private Date issuing_date;
	private int price;
	private int num_like;
	private  String description;
	
}

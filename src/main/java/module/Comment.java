package module;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class Comment {
	
	@ManyToOne
	@Column(name ="userId")
	private User user;
	@ManyToOne
	@Column(name="songId")
	private Song song;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String content;
	private Date dateComm;
	
	
	Comment(Integer id, String content, Date dateComm)
	{
		this.id = id;
		this.content = content;
		this.dateComm = dateComm;
	}

	Integer getId()
	{
		return this.id;
	}
	
	String getContent()
	{
		return this.content;
	}
	
	Date getDateComm()
	{
		return this.dateComm;
	}
	
}

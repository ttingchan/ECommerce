package pojo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	private int id;
	private String content;
	private Date dateComm;
	

}

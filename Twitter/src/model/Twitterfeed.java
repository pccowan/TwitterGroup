package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the TWITTERFEEDS database table.
 * 
 */
@Entity
@Table(name="TWITTERFEEDS", schema="testuserdb")
@NamedQuery(name="Twitterfeed.findAll", query="SELECT t FROM Twitterfeed t")
public class Twitterfeed implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long postid;

	private String post;

	@Temporal(TemporalType.DATE)
	@Column(name="POST_DATE")
	private Date postDate;

	private BigDecimal userid;

	private String username;

	public Twitterfeed() {
	}

	public long getPostid() {
		return this.postid;
	}

	public void setPostid(long postid) {
		this.postid = postid;
	}

	public String getPost() {
		return this.post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public Date getPostDate() {
		return this.postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public BigDecimal getUserid() {
		return this.userid;
	}

	public void setUserid(BigDecimal userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TWITTERUSERS database table.
 * 
 */
@Entity
@Table(name="TWITTERUSERS", schema="testuserdb")
@NamedQuery(name="Twitteruser.findAll", query="SELECT t FROM Twitteruser t")
public class Twitteruser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_USER")
    @SequenceGenerator(schema="testuserdb", name="SEQ_USER", sequenceName="SEQ_USER", allocationSize=1)
	private long userid;

	private String pwd;

	private String username;

	public Twitteruser() {
	}

	public long getUserid() {
		return this.userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
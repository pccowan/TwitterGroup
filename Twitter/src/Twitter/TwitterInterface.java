package Twitter;

import java.util.ArrayList;

import model.Twitterfeed;
import model.Twitteruser;

public class TwitterInterface {
	TwtDB db = new TwtDB();
	
	public boolean isUserExist(String userName){
		boolean isExist = false;
		
		Twitteruser t = db.getProfile(userName);
		if (t != null){
			isExist = true;
		}
		
		return isExist;
	}
	
	public boolean isUserMatching(String userName, String pwd)
	{
		boolean isExist = false;
		
		Twitteruser t = db.getProfile(userName, pwd);
		if (t != null){
			isExist = true;
		}
		
		return isExist;
	}
	
	
	public boolean createNewAccount(String userName, String password){
		boolean isSuccess = false;
		
		//check whether the user exists
		if(isUserMatching(userName, password)){
			return isSuccess;
		}
		
		//create new account
		if(db.createNewUser(userName, password)){
			isSuccess = true;
		}
		
		return isSuccess;
		
	}
	
	
	public ArrayList<TwtData> pullProfile(String userName){
		ArrayList<TwtData> twt = null;
		
		return twt;
		
	}
	
	public boolean addNewFeed(String userName, String feed){
		boolean isSuccess = false;
		
		return isSuccess;
		
	}
	
	public ArrayList<TwtDataDetail> pullFeeds(int count){
		ArrayList<TwtDataDetail> twt = null;
		
		return twt;
	}
	
	public ArrayList<Twitterfeed> pullFeeds(){
		return db.getAllFeeds();
	}

}

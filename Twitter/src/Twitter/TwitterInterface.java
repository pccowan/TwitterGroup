package Twitter;

import java.util.ArrayList;

import model.Twitterfeed;
import model.Twitteruser;

public class TwitterInterface {
	TwtDB db = new TwtDB();
	
	public boolean IsUserExist(String userName, String pwd)
	{
		boolean isExist = false;
		
		ArrayList<Twitteruser> info = db.getUserInfo(userName, pwd);
		if(!info.isEmpty() && info !=null){
			isExist = true;
		}
		
		return isExist;
	}
	
	
	public boolean CreateNewAccount(String userName, String password){
		boolean isSuccess = false;
		
		return isSuccess;
		
	}
	
	
	public ArrayList<TwtData> PullProfile(String userName){
		ArrayList<TwtData> twt = null;
		
		return twt;
		
	}
	
	public boolean AddNewFeed(String userName, String feed){
		boolean isSuccess = false;
		
		return isSuccess;
		
	}
	
	public ArrayList<TwtDataDetail> PullFeeds(int count){
		ArrayList<TwtDataDetail> twt = null;
		
		return twt;
	}
	
	public ArrayList<Twitterfeed> PullFeeds(){
		return db.getAllFeeds();
	}

}

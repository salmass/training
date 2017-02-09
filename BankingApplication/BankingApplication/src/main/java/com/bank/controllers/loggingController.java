package com.bank.controllers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bank.configuration.HibernateConfiguration;
import com.bank.dao.UserInfoDao;
import com.bank.model.UserInfo;
import com.bank.utils.JsonMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
@Controller
public class loggingController {
	@Autowired
UserInfoDao userInfoDao;
	@RequestMapping(value="/login",method=RequestMethod.GET)
	private String loggingPage(HttpServletRequest request,HttpServletResponse response){
		return "login";
	
	}
	UserInfo Userinfo=new UserInfo();
	
	@RequestMapping(value="/signin",method=RequestMethod.POST)
	private String signIn(HttpServletRequest request,HttpServletResponse response){
		Session session=HibernateConfiguration.getSession();
		String emailId=request.getParameter("email");
		String password=request.getParameter("password");
		Criteria cr =session.createCriteria(UserInfo.class);
		List <UserInfo> data=cr.list();
		for(int i=0;i<data.size();i++)
		{
			if((data.get(i).getEmail().equals(emailId))&&data.get(i).getPassword().equals(password))
			{
				return "HomePage";
			}
		}
					
				return "SigninFailedPage";
		}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	private String sigup(HttpServletRequest request,HttpServletResponse response){
	String firstname=request.getParameter("firstname");	
	String lastname=request.getParameter("lastname");
	String emailId=request.getParameter("email");
	String password=request.getParameter("password");
	
	long timeSeed = System.nanoTime(); // to get the current date time value

    double randSeed = Math.random() * 1000; // random number generation

    long midSeed = (long) (timeSeed * randSeed); // mixing up the time and
                                                    // rand number.

                                                    // variable timeSeed
                                                    // will be unique


                                                   // variable rand will 
                                                   // ensure no relation 
                                                  // between the numbers

    String s = midSeed + "";
    String subStr = s.substring(0, 9);

    int accountnumber = Integer.parseInt(subStr);
	Userinfo.setFirstname(firstname);
	Userinfo.setEmail(emailId);
	Userinfo.setLastname(lastname);
	Userinfo.setPassword(password);
	Userinfo.setAccountNumber(accountnumber);
	
	userInfoDao.save(Userinfo);
	return "HomePage";
	
	
	}
	@RequestMapping(value="/get_AccountData",method=RequestMethod.GET)
	public void getAccountData(HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> model=new HashMap<String, Object>();
		ObjectMapper mapper= new ObjectMapper();
		try{
			model.put("accountdata", mapper.writeValueAsString(userInfoDao.getUserData()));
			JsonMessage msg=new JsonMessage(mapper.writeValueAsString(model));
			JSONObject obj=new JSONObject(msg);
			response.getWriter().write(obj.toString());
			
		}catch(Exception e){
			e.printStackTrace();
		
		
	}	}
	
}
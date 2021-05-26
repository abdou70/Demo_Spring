package com.example.demo;

import com.example.demo.dao.IRoles;
import com.example.demo.dao.IUser;
import com.example.demo.entities.Roles;
import com.example.demo.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args)
    {
		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);

       /* Roles roles = new Roles();
        roles.setId(1);
        roles.setNom("Roles_User");

		User user = new User();
		user.setId(1);
		user.setNom("niang");
		user.setPrenom("Abdou");
		user.setEmail("abdouniang@gmail.com");
		user.setPassword("passer2020");
		user.setEtat(1);
       List<Roles> roless = new ArrayList<Roles>();

       roless.add(roles);
       user.setRoles(roless);
        IUser iUser = ctx.getBean(IUser.class);*/

		/*List<User> users = new ArrayList<User>();
        users.add(user);
        roles.setUsers(users);*/


		/*try {
		    iUser.save(user);
        }catch (Exception e){
		    e.printStackTrace();
        }*/


		/*IUser iUser = ctx.getBean(IUser.class);

		User user = new User();
		user.setId(1);
		user.setNom("niang");
		user.setPrenom("Abdou");
		user.setEmail("abdouniang10@gmail.com");
		user.setPassword("passer2020");

		try {
			iUser.save(user);
		}catch (Exception e){
			 e.printStackTrace();
		}*/
	}

}

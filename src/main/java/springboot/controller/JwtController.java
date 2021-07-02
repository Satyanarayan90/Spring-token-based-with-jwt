package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.helper.Jwtutill;
import springboot.model.JwtRequest;
import springboot.model.JwtResponce;
import springboot.services.CustomUserDetailsService;

@RestController
public class JwtController {
	
	@Autowired
	public CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	public Jwtutill jwtutill;
	
	@Autowired
	public AuthenticationManager authenticationManager;
	 
	@PostMapping("/token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtrequest ) throws Exception{
		System.out.println(jwtrequest);
		
		
	try {
		this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtrequest.getUsername(), jwtrequest.getPassword()));
	}
		catch(UsernameNotFoundException e){
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		}
//	fine area
	UserDetails userDetails=this.customUserDetailsService.loadUserByUsername(jwtrequest.getUsername());
	String token=this.jwtutill.generateToken(userDetails);
	System.out.println("JW"+token);
	
//responce{token:value}
	return ResponseEntity.ok(new JwtResponce(token));
	
}
	
}

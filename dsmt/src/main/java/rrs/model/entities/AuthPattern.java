package rrs.model.entities;

import java.util.Set;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rrs.util.Random;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthPattern {
	
	private String id;
	private String name;
	private String email;
	private Set<String> roles;
	
	public AuthPattern(OAuth2AuthenticationToken token) {
		OAuth2User auth = token.getPrincipal();
		this.id = auth.getAttribute("id");
		this.name = auth.getAttribute("name");
		this.email = auth.getAttribute("email");
	}

	public Account toAccount() {
		return new Account(this.id, Random.NumUppLow("RRS", 9), this.email, this.name, "BUYER");
	}
}

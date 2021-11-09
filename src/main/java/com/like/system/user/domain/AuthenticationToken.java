package com.like.system.user.domain;

import java.io.Serializable;
import java.util.List;

import com.like.system.menu.domain.MenuGroup;

import lombok.Builder;
import lombok.Getter;

@Getter
public class AuthenticationToken implements Serializable {
		
	private static final long serialVersionUID = 7987811233360490990L;
	
	private String userId;
	private String userName;
	private String email;
	private String imageUrl;
	private String token;
	private String oAuthAccessToken;
    //private Collection<? extends GrantedAuthority> authorities;
	private List<String> authorities;
    private List<MenuGroup> menuGroupList;
    
       
    @Builder
    public AuthenticationToken(String userId
    						  ,String userName
    						  ,String imageUrl
    						  ,String email
    						  ,String token
    						  ,String oAuthAccessToken
    						  ,List<String> collection
    						  ,List<MenuGroup> menuGroupList) {
    	this.userId = userId;
        this.userName = userName;
        this.imageUrl = imageUrl;
        this.email = email;
        this.token = token;
        this.oAuthAccessToken = oAuthAccessToken;
        this.authorities = collection;
        this.menuGroupList = menuGroupList;
        
    }       
       
}

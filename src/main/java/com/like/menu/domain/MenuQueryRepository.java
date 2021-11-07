package com.like.menu.domain;

import java.util.List;

import com.like.menu.boundary.MenuDTO;
import com.like.menu.boundary.MenuGroupDTO;

public interface MenuQueryRepository {

	List<MenuGroup> getMenuGroupList(MenuGroupDTO.SearchMenuGroup condition);
	
	List<MenuGroup> getMenuGroupList(String likeMenuGroupName);
	
	List<Menu> getMenuList(MenuDTO.SearchMenu condition);
	
}

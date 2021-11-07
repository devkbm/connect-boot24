package com.like.menu.domain;

import java.util.List;

import com.like.menu.boundary.WebResourceDTO;

public interface WebResourceQueryRepository {

	List<WebResource> getResourceList(WebResourceDTO.SearchWebResource condition);
}

package com.like.file.domain;

import java.util.List;

public interface FileRepository {
	
	FileInfo getFileInfo(String id);
	
	List<FileInfo> getFileInfoList(List<String> id);
	
	List<FileInfo> getFileInfoList();
	
	void delete(String id);
	
	FileInfo save(FileInfo fileInfo);
}

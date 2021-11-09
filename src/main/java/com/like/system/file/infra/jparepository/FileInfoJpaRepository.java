package com.like.system.file.infra.jparepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.like.system.file.domain.FileInfo;
import com.like.system.file.domain.FileRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class FileInfoJpaRepository implements FileRepository {
	
	@Autowired
	private JPAQueryFactory  queryFactory;

	@Autowired
	private JpaFileInfo jpaFileInfo;
	
	@Override
	public FileInfo getFileInfo(String id) {				
		return jpaFileInfo.findById(id).orElse(null);
	}
	
	@Override
	public List<FileInfo> getFileInfoList(List<String> id) {
		return jpaFileInfo.findAllById(id);
	}

	@Override
	public List<FileInfo> getFileInfoList() {
		return jpaFileInfo.findAll();
	}

	public void delete(String id) {
		jpaFileInfo.deleteById(id);
	}
	
	public FileInfo save(FileInfo fileInfo) {
		return jpaFileInfo.saveAndFlush(fileInfo);		
	}
	

}

package kh.spring.chazazo.admin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.chazazo.admin.model.dao.AdminDao;
import kh.spring.chazazo.admin.model.dto.AdminMemberRespDto;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao dao;
	
	@Override
	public List<AdminMemberRespDto> selectMemberList() {
		return dao.selectMemberList();
	}

}
package kh.spring.chazazo.member.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.spring.chazazo.member.model.dao.MemberDao;
import kh.spring.chazazo.member.model.dto.MemberReqDto;
import kh.spring.chazazo.member.model.dto.MemberInfoReqDto;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	private MemberDao dao;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;

	@Override
	@Transactional
	public int insert(MemberReqDto memberDto, MemberInfoReqDto memberInfoDto) {
		String encodingPass = bcryptPasswordEncoder.encode(memberDto.getPassword());
		memberDto.setPassword(encodingPass);
		int result = dao.insert(memberDto);
		if(result == 1) {
			dao.insertInfo(memberInfoDto);
		}
		return result;	
	}

	@Override
	public int checkDup(String username) {
		return dao.checkDup(username);
	}

	@Override
	public List<String> findId(String email) {
		return dao.findId(email);
	}

}

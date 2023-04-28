package kh.spring.chazazo.admin.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.chazazo.admin.model.dao.AdminDao;
import kh.spring.chazazo.admin.model.dto.AdminCouponInsertReqDto;
import kh.spring.chazazo.admin.model.dto.AdminCouponManageRespDto;
import kh.spring.chazazo.admin.model.dto.AdminCouponUpdateReqDto;
import kh.spring.chazazo.admin.model.dto.AdminLocationOneRespDto;
import kh.spring.chazazo.admin.model.dto.AdminLocationRespDto;
import kh.spring.chazazo.admin.model.dto.AdminMemberRespDto;
import kh.spring.chazazo.admin.model.dto.AdminNoticeInsertReqDto;
import kh.spring.chazazo.admin.model.dto.AdminNoticeOneRespDto;
import kh.spring.chazazo.admin.model.dto.AdminNoticeRespDto;
import kh.spring.chazazo.admin.model.dto.AdminNoticeUpdateReqDto;
import kh.spring.chazazo.admin.model.dto.AdminReportRespDto;
import kh.spring.chazazo.admin.model.dto.AdminRequestOneRespDto;
import kh.spring.chazazo.admin.model.dto.AdminRequestRespDto;
import kh.spring.chazazo.admin.model.dto.AdminReservByModelRespDto;
import kh.spring.chazazo.admin.model.dto.AdminReservRespDto;
import kh.spring.chazazo.admin.model.dto.AdminStatisticsRecentMonthDto;
import kh.spring.chazazo.admin.model.dto.AdminVehicleOneRespDto;
import kh.spring.chazazo.admin.model.dto.AdminVehicleRespDto;
import kh.spring.chazazo.common.Pagination;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao dao;
	
	// 회원
	@Override
	public int memberCount() {
		return dao.memberCount();
	}
	@Override
	public List<AdminMemberRespDto> selectMemberList(Pagination pagination) {
		return dao.selectMemberList(pagination);
	}
	@Override
	public AdminMemberRespDto selectMemberOne(String username) {
		return dao.selectMemberOne(username);
	}
	@Override
	public int deleteMember(String username) {
		int result = 0;
		if(dao.deleteMember(username) == 1) {
			result = dao.deleteMemberInfo(username);
		}
		return result;
	}
	
	// 신고
	@Override
	public int reportCount() {
		return dao.reportCount();
	}
	@Override
	public List<AdminReportRespDto> selectReportList(Pagination pagination) {
		return dao.selectReportList(pagination);
	}
	@Override
	public AdminReportRespDto selectReportOne(String idx) {
		return dao.selectReportOne(idx);
	}
	@Override
	public String selectReviewContent(String idx) {
		return dao.selectReviewContent(idx);
	}
	
	// 쿠폰
	@Override
	public int couponCount() {
		return dao.couponCount();
	}
	@Override
	public List<AdminCouponManageRespDto> selectCouponList(Pagination pagination) {
		return dao.selectCouponList(pagination);
	}
	@Override
	public AdminCouponManageRespDto selectCouponOne(String idx) {
		return dao.selectCouponOne(idx);
	}
	@Override
	public int insertCoupon(AdminCouponInsertReqDto data) {
		return dao.insertCoupon(data);
	}
	@Override
	public int updateCoupon(AdminCouponUpdateReqDto data) {
		return dao.updateCoupon(data);
	}
	@Override
	public int deleteCoupon(int idx) {
		return dao.deleteCoupon(idx);
	}
	
	// 1:1 문의
	@Override
	public int requestCount() {
		return dao.requestCount();
	}
	@Override
	public List<AdminRequestRespDto> selectRequestList(Pagination pagination) {
		return dao.selectRequestList(pagination);
	}
	@Override
	public List<AdminRequestRespDto> selectRequestList(Map<String, Integer> data) {
		return dao.selectRequestList(data);
	}
	@Override
	public AdminRequestOneRespDto selectRequestOne(String idx) {
		return dao.selectRequestOne(idx);
	}
	@Override
	public int insertAnswer(Map<String, String> data, String idx) {
		int result = dao.insertAnswer(data);
		if(result == 1) {
			dao.updateRequest(idx);
		}
		return result;
	}
	@Override
	public int updateAnswer(Map<String, String> data, String idx) {
		int result = dao.updateAnswer(data);
		if(result == 1) {
			dao.updateRequest(idx);
		}
		return result;
	}
	@Override
	public int deleteRequest(String idx) {
		int result = dao.deleteAnswer(idx);
		System.out.println(result);
		if(result == 1) {
			dao.deleteRequest(idx);
		}
		return result;
	}
	
	// 공지사항
	@Override
	public int noticeCount() {
		return dao.noticeCount();
	}
	@Override
	public List<AdminNoticeRespDto> selectNoticeList(Pagination pagination) {
		return dao.selectNoticeList(pagination);
	}
	@Override
	public AdminNoticeOneRespDto selectNoticeOne(String idx) {
		return dao.selectNoticeOne(idx);
	}
	@Override
	public int insertNotice(AdminNoticeInsertReqDto data) {
		return dao.insertNotice(data);
	}
	@Override
	public int updateNotice(AdminNoticeUpdateReqDto data) {
		return dao.updateNotice(data);
	}
	@Override
	public int deleteNotice(int idx) {
		return dao.deleteNotice(idx);
	}
	
	// 지점
	@Override
	public int locationCount() {
		return dao.locationCount();
	}
	@Override
	public List<AdminLocationRespDto> selectLocationList(Pagination pagination) {
		return dao.selectLocationList(pagination);
	}
	@Override
	public AdminLocationOneRespDto selectLocationOne(String idx) {
		return dao.selectLocationOne(idx);
	}
	
	// 차량
	@Override
	public int vehicleCount() {
		return dao.vehicleCount();
	}
	@Override
	public List<AdminVehicleRespDto> selectVehicleList(Pagination pagination) {
		return dao.selectVehicleList(pagination);
	}
	@Override
	public AdminVehicleOneRespDto selectVehicleOne(String idx) {
		return dao.selectVehicleOne(idx);
	}
	
	// 예약
	@Override
	public List<AdminReservRespDto> selectReservList(Pagination pagination) {
		return dao.selectReservList(pagination);
	}
	
	// 통계
	@Override
	public List<AdminReservByModelRespDto> selectByModel() {
		return dao.selectByModel();
	}
	@Override
	public List<AdminStatisticsRecentMonthDto> recentMonth() {
		return dao.recentMonth();
	}
	@Override
	public int reservCount() {
		return dao.reservCount();
	}
	@Override
	public List<String> selectLocNameList() {
		return dao.selectLocNameList();
	}
	@Override
	public List<String> monthList() {
		return dao.monthList();
	}
	@Override
	public int dayReservCount() {
		return dao.dayReservCount();
	}	
	@Override
	public int dayReservSum() {
		return dao.dayReservSum();
	}
	@Override
	public int dayRegiCount() {
		return dao.dayRegiCount();
	}

}

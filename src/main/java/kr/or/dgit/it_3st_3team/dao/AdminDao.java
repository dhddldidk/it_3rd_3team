package kr.or.dgit.it_3st_3team.dao;

import java.util.List;
import java.util.Map;

import kr.or.dgit.it_3st_3team.dto.Admin;

public interface AdminDao {
	Admin selectAdminByNo(Admin admin);
	Admin selectAdminById(Admin admin);
	Admin selectAdminByLogin(Admin admin);
	List<Admin> selectAdminAll();
	List<Admin> selectAdminBySearch(Map<String, String> map);
	
	int insertAdmin(Admin admin);
	int updateAdmin(Admin admin);
	int deleteAdmin(Admin admin);
}

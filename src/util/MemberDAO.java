package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vo.MemberVO;

// Member Table CRUD
public class MemberDAO {
	Connection cn = DBConnection.getConnection();
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	String sql;
	
	// selectList
	public List<MemberVO> selectList() {
		sql="select * from member order by id";
		List<MemberVO> list = new ArrayList<>();
		try {
			st=cn.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next()) {
				do {
					// 서로다른 주소를 정해야 여러 값을 담을 수 있으므로 생성문을 do while안에 넣는다.
					MemberVO vo = new MemberVO(); 
					// row의 index가1 부터임
					vo.setId(rs.getString(1)); 
					vo.setPassword(rs.getString(2));
					vo.setName(rs.getString(3));
					vo.setLev(rs.getString(4));
					vo.setBirthd(rs.getString(5));
					vo.setPoint(rs.getInt(6));
					vo.setWeight(rs.getDouble(7));
					vo.setRid(rs.getString(8));
					list.add(vo);
				} while (rs.next());
			}else {
				System.out.println("출력할 Data가 없습니다 ~~");
				list=null;
			}
		} catch (Exception e) {
			System.out.println("selectList Exception => "+e.toString());
			list=null;
		}
		return list;
	}//selectList
	
	// selectOne
	public MemberVO selectOne(MemberVO vo) {
		sql="select * from member where id=?";
		try {
			pst=cn.prepareStatement(sql); // sql을 미리 담아보내 줘야 밑줄에서 설정가능
			pst.setString(1,vo.getId());
			rs=pst.executeQuery();
			if (rs.next()) {
				vo.setPassword(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setLev(rs.getString(4));
				vo.setBirthd(rs.getString(5));
				vo.setPoint(rs.getInt(6));
				vo.setWeight(rs.getDouble(7));
				vo.setRid(rs.getString(8));
			}else {
				System.out.println("** Member NotFound **");
				vo = null;
			}
		} catch (Exception e) {
			System.out.println("selectOne Exception => "+e.toString());
			vo = null;
		}
		return vo;
	}// selectOne
	
	// Join -> Insert
	public int insert(MemberVO vo) {
		sql="insert into member(id,password,name,lev,birthd,point,weight,rid)"
				+ " values(?,?,?,?,?,?,?,?)";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, vo.getId());
			pst.setString(2, vo.getPassword());
			pst.setString(3, vo.getName());
			pst.setString(4, vo.getLev());
			pst.setString(5, vo.getBirthd());
			pst.setInt(6, vo.getPoint());
			pst.setDouble(7, vo.getWeight());
			pst.setString(8, vo.getRid());
			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("insert Exception => "+e.toString());
			return 0;
		}// Join
	}// Join

	// Update
	public int update(MemberVO vo) {
		sql="update member set password=?, name=?, lev=?, birthd=?, "+
				"point=?, weight=?, rid=? where id=?";
		try {
			pst=cn.prepareStatement(sql);
			pst.setString(1, vo.getPassword());
			pst.setString(2, vo.getName());
			pst.setString(3, vo.getLev());
			pst.setString(4, vo.getBirthd());
			pst.setInt(5, vo.getPoint());
			pst.setDouble(6, vo.getWeight());
			pst.setString(7, vo.getRid());
			pst.setString(8, vo.getId());
			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("update Exception => "+e.toString());
			return 0;
		}// catch
	}// Update

	// Delete
	public int delete(MemberVO vo) {
		sql="delete from member where id=?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, vo.getId());
			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("delete Exception => "+e.toString());
			return 0;
		}// catch
	}// Delete
}// class

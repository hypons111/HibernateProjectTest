package tw.hibernateproject.member.model;

import java.util.List;

public interface IMemberDao {
	public List<Member> selectAll();
	public List<Member> selectByName(String name);
	public Member selectById(int memberid);
	public Member insert(Member mBean);
	public boolean delete(int memberid);
}

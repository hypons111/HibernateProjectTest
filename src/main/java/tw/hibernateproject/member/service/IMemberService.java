package tw.hibernateproject.member.service;

import java.util.List;

import tw.hibernateproject.member.model.Member;

public interface IMemberService {
	public List<Member> selectAll();
	public List<Member> selectByName(String name);
	public Member selectById(int memberid);
	public Member insert(Member mBean);
	public boolean delete(int memberid);
}

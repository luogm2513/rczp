package luo.rczp.colla.dao;

import java.util.List;

import luo.rczp.base.BaseDao;
import luo.rczp.colla.model.Invite;

public interface InviteDao extends BaseDao<Invite,java.lang.Long> {
	public List<Invite> getInviteListByCompId(Long userId);
	public List<Invite> getInviteListByUserId(Long userId);
	public Integer count(Integer inviteType, Long targetUserId, Long userId);
}
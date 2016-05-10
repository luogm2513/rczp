package luo.rczp.colla.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import luo.common.hibernate3.Finder;
import luo.rczp.base.BaseDaoImpl;
import luo.rczp.colla.dao.InviteDao;
import luo.rczp.colla.model.Invite;

@Repository
public class InviteDaoImpl extends BaseDaoImpl<Invite,java.lang.Long>
	implements InviteDao{
	
	@SuppressWarnings("unchecked")
	public Class getEntityClass() {
		return Invite.class;
	}
	
	public String getMapperName() {
		return "rczp.mapper.InviteMapper";
	}

	public List<Invite> getInviteListByCompId(Long userId) {
		Finder f = Finder.create("from Invite i where i.userId = :rId and i.isDisabled =0 order by i.sentTime desc");
		f.setParam("rId", userId);
		return find(f);
	}
	
	public List<Invite> getInviteListByUserId(Long userId) {
		Finder f = Finder.create("from Invite i where i.targetUserId = :rId and i.isDisabled =0 and i.isDeleted =0 order by i.sentTime desc");
		f.setParam("rId", userId);
		return find(f);
	}
	
    public Integer count(Integer inviteType, Long targetUserId, Long userId){
		Finder f = Finder.create("from Invite i where i.inviteType =:type and i.targetUserId= :tUId and i.userId = :uId");
		f.setParam("tUId", targetUserId);
		f.setParam("uId", userId);
		f.setParam("type", inviteType);
		return countQueryResult(f);
    }
}
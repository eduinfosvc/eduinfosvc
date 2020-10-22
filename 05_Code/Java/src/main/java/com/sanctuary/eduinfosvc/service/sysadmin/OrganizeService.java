package com.sanctuary.eduinfosvc.service.sysadmin;

import com.sanctuary.eduinfosvc.dao.sysadmin.OrganizeDao;
import com.sanctuary.eduinfosvc.domain.Organize;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrganizeService {
    @Autowired
    OrganizeDao organizeDao;

    // 组织：查询总量 (查询全部父组)
    public int queryOrganizesNum(String name){
        return organizeDao.queryOrganizesNum(name);
    }

    // 组织：查询指定页数父组-及相关组织
    public List<Organize> queryOrganizes(Map<String,Object> map){
        List<Organize> organizeFathers = organizeDao.queryOrganizes(map);
        for(Organize organizeFather: organizeFathers){

            organizeFather.setChildren(
                    organizeDao.getOrganizeChildren(organizeFather.getOrganizeId()));
            organizeFather.setUsers(
                    organizeDao.getUsers(organizeFather.getOrganizeId())
            );

            for(Organize organizeSon: organizeFather.getChildren()){

                organizeSon.setChildren(
                        organizeDao.getOrganizeChildren(organizeSon.getOrganizeId()));
                organizeSon.setUsers(
                        organizeDao.getUsers(organizeSon.getOrganizeId())
                );

                for(Organize organizeGrandson: organizeSon.getChildren()){

                    organizeGrandson.setUsers(organizeDao.getUsers(organizeGrandson.getOrganizeId()));

                }
            }
        }
        return organizeFathers;
    }

    // 组织：查询指定页数和名称父组-及相关组织
    public List<Organize> queryOrganizesByName(Map<String,Object> map){
        List<Organize> organizeFathers = organizeDao.queryOrganizesByName(map);
        for(Organize organizeFather: organizeFathers){
            organizeFather.setChildren(
                    organizeDao.getOrganizeChildren(organizeFather.getOrganizeId()));
            organizeFather.setUsers(
                    organizeDao.getUsers(organizeFather.getOrganizeId())
            );
            for(Organize organizeSon: organizeFather.getChildren()){
                organizeSon.setChildren(
                        organizeDao.getOrganizeChildren(organizeSon.getOrganizeId()));
                organizeSon.setUsers(
                        organizeDao.getUsers(organizeSon.getOrganizeId())
                );
                for(Organize organizeGrandson: organizeSon.getChildren()){
                    organizeGrandson.setUsers(organizeDao.getUsers(organizeGrandson.getOrganizeId()));
                }
            }
        }
        return organizeFathers;
    }

    // 组织：增加组织
    public boolean addOrganize(Organize organize){
        if(organizeDao.addOrganize(organize) > 0)    return true;
        else    return false;
    }

    // 组织：修改组织
    public boolean alterOrganize(Organize organize){
        if(organizeDao.alterOrganize(organize) > 0)    return true;
        else    return false;
    }

    // 组织：删除组织
    public boolean deleteOrganize(int organizeId){
        if(organizeDao.deleteOrganize(organizeId) > 0)    return true;
        else    return false;
    }

    // 组织：查询指定ID组织
    public Organize queryOrganizeById(int organizeId){
        return organizeDao.queryOrganizeById(organizeId);
    }

    // 组织：查询指定ID组织及其相关组织
    public Organize queryOrganizesById(int organizeId){
        Organize organizeFather = organizeDao.queryOrganizeById(organizeId);
        organizeFather.setChildren(
                organizeDao.getOrganizeChildren(organizeFather.getOrganizeId()));
        for(Organize organizeSon: organizeFather.getChildren()){
            organizeSon.setChildren(
                    organizeDao.getOrganizeChildren(organizeSon.getOrganizeId()));
        }
        return organizeFather;
    }
}

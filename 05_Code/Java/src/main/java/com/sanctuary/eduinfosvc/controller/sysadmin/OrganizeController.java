package com.sanctuary.eduinfosvc.controller.sysadmin;

import com.sanctuary.eduinfosvc.domain.Organize;
import com.sanctuary.eduinfosvc.domain.Page;
import com.sanctuary.eduinfosvc.service.sysadmin.OrganizeService;
import com.sanctuary.eduinfosvc.util.ErrorInfo;
import com.sanctuary.eduinfosvc.util.Info;
import com.sanctuary.eduinfosvc.util.SuccessInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
@RequestMapping("/api/")
public class OrganizeController {

    @Autowired
    OrganizeService organizeService;

    // 组织：查询组织（页数限定+全部 / 页数限定+名字模糊）
    @RequestMapping(value="/organizes", method = RequestMethod.GET)
    @ResponseBody
    public Info queryOrganizes(String name, Page page){
        // 名字模糊限定 or not的查询记录 if判断可推迟到mapper文件里进行(但为了功能点在本层就可体现，故在此冗余书写)
        // 名字模糊限定 or not的查询记录条数 if判单已推迟到mapper文件
        if(name == null){
            System.out.println("*** 组织：查询指定页数父组-及相关组织 ***");
            page.setBegin( (page.getPageNum()-1) * page.getPageSize());
            System.out.println(page);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("page", page);

            List<Organize> organizes = organizeService.queryOrganizes(map);
            if(!organizes.isEmpty()){
                for(Organize organize: organizes) System.out.println(organize);
            }

            Map<String,Integer> nums = new HashMap<String,Integer>();
            nums.put("total", organizeService.queryOrganizesNum(name));
            System.out.println(nums.get("total"));

            Object[] data = new Object[]{nums, organizes};
            SuccessInfo successInfo = new SuccessInfo(data);
            return successInfo;
        }else{
            System.out.println("*** 组织：查询指定页数和名称父组-及相关组织 ***");
            page.setBegin( (page.getPageNum()-1) * page.getPageSize());
            System.out.println(page);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("name", name);
            map.put("page", page);

            List<Organize> organizes = organizeService.queryOrganizesByName(map);
            if(!organizes.isEmpty()){
                for(Organize organize: organizes) System.out.println(organize);
            }

            Map<String,Integer> nums = new HashMap<String,Integer>();
            nums.put("total", organizeService.queryOrganizesNum(name));
            System.out.println(nums.get("total"));

            Object[] data = new Object[]{nums, organizes};
            SuccessInfo successInfo = new SuccessInfo(data);
            return successInfo;
        }
    }

    // 组织：增加组织
    @RequestMapping(value="/organize", method = RequestMethod.POST)
    @ResponseBody
    public Info addOrganize(@RequestBody Organize organize){
        System.out.println("*** 组织：新增组织 ***");
        System.out.println(organize);

        if(organizeService.addOrganize(organize)){
            return new SuccessInfo();
        }else{
            return new ErrorInfo(500, "新增失败");
        }
    }

    // 组织：修改组织
    @RequestMapping(value="/organize", method = RequestMethod.PUT)
    @ResponseBody
    public Info alterOrganize(@RequestBody Organize organize){
        System.out.println("*** 组织：修改组织 ***");
        System.out.println(organize);

        if(organizeService.alterOrganize(organize)){
            return new SuccessInfo();
        }else{
            return new ErrorInfo(500, "修改失败");
        }
    }

    // 组织：删除组织
    @RequestMapping(value="/organize/{id}/{topId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Info deleteOrganize(@PathVariable("id") int organizeId, @PathVariable("topId") int topId){
        System.out.println("*** 组织：删除组织 ***");
        System.out.println(organizeId);

        if(organizeService.deleteOrganize(organizeId)){
            Organize organize = organizeService.queryOrganizesById(topId);
            System.out.println(organize);
            Object[] data = new Object[]{organize};
            SuccessInfo successInfo = new SuccessInfo(data);
            return successInfo;
        }else{
            return new ErrorInfo(500, "删除失败");
        }
    }

    // 组织：查询指定ID组织
    @RequestMapping(value="/organize/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Info queryOrganizeById(@PathVariable("id") int organizeId){
        System.out.println("*** 组织：查询指定ID组织 ***");
        System.out.println(organizeId);

        Organize organize = organizeService.queryOrganizeById(organizeId);
        if(organize != null){
            System.out.println(organize);
            Object[] data = new Object[]{organize};
            SuccessInfo successInfo = new SuccessInfo(data);
            return successInfo;
        }else{
            return new ErrorInfo(500, "无此组织");
        }

    }
}

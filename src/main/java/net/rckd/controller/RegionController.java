package net.rckd.controller;

import net.rckd.entity.Region;
import net.rckd.service.RegionService;
import net.rckd.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @author hanyi
 * @date 2017年04月14日
 */
@RestController
@RequestMapping("region")
public class RegionController {
    @Autowired
    private RegionService regionService;
    @RequestMapping("/getTreeList")
    public R aaa (){
        List<Region> list = regionService.getRegionTree();
        return  R.ok().put("treeList", list);
    }
}

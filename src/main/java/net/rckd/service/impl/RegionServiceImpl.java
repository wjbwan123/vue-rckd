package net.rckd.service.impl;

import net.rckd.dao.RegionDao;
import net.rckd.entity.Region;
import net.rckd.service.RegionService;
import net.rckd.utils.RegionType;
import net.rckd.utils.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hanyi
 * @date 2017年04月14日
 */
@Service
public class RegionServiceImpl implements RegionService {
    @Autowired
    private RegionDao regionDao;

    @Override
    public List<Region> getRegionTree() {
        //从缓存或数据库中查询全部
        List<Region> regionList = (List<Region>) ShiroUtils.getSessionAttribute("treeList");
        if (CollectionUtils.isEmpty(regionList)) {
            regionList = regionDao.queryAll();
            //取出所有根节点
            List<Region> roots = regionList.stream()
                    .filter(region -> (region.getType() == RegionType.PROVINCE.getValue()))
                    .collect(Collectors.toList());
            //取出所有非根节点
            List<Region> subs = regionList.stream()
                    .filter(region -> (region.getType() != RegionType.PROVINCE.getValue()))
                    .collect(Collectors.toList());
            //递归构建树结构的地区信息
            roots.forEach(root -> buildSubs(root, subs));
            ShiroUtils.setSessionAttribute("treeList", roots);
            return roots;
        }
        return regionList;
    }

    /**
     * 递归构建
     *
     * @param parent
     * @param subs
     */
    private void buildSubs(Region parent, List<Region> subs) {
        Integer parentCode = parent.getCode();
        List<Region> children = subs.stream()
                .filter(sub -> (sub.getParentCode().equals(parentCode)))
                .collect(Collectors.toList());
        //有子分类的情况
        if (!CollectionUtils.isEmpty(children)) {
            parent.setChildren(children);
            //再次递归构建
            children.forEach(child -> buildSubs(child, subs));
        }
    }
}

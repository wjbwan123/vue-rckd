package net.rckd.service;

import net.rckd.entity.Region;

import java.util.List;

/**
 * @author hanyi
 * @date 2017年04月14日
 */
public interface RegionService {
    /**
     *获得地区树结构
     */
    List<Region> getRegionTree();
}

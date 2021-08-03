package com.example.springboot_activiti.project.system.service.impl;

import com.example.springboot_activiti.framework.web.domain.TreeSelect;
import com.example.springboot_activiti.framework.web.service.BaseServiceImpl;
import com.example.springboot_activiti.project.system.domain.po.SMenu;
import com.example.springboot_activiti.project.system.mapper.SMenuMapper;
import com.example.springboot_activiti.project.system.service.SysMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SysMenuServiceImpl extends BaseServiceImpl implements SysMenuService {

    @Resource
    private SMenuMapper menuMapper;

    @Override
    public List<SMenu> selectList(SMenu menu) {
        List<SMenu> menus = menuMapper.selectList(menu);
        List<SMenu> menu_List =new ArrayList<>();
        Optional.ofNullable(menus).ifPresent(menuList -> {
           for(int i=0;i<menuList.size();i++){
               if("0".equals(menuList.get(i).getParentId().toString())){
                   menu_List.add(menuList.get(i));
               }
           }
           for(SMenu menu1:menu_List){
              menu1.setChildrens(getChildren(menu1.getMenuId().toString(),menus));
           }

        });
        return menu_List;
    }

    @Transactional
    @Override
    public void add(SMenu menu) {
        menuMapper.insertSelective(menu);
    }


    @Override
    public List<TreeSelect> buildMenuTreeSelect(List<SMenu> menus) {
        List<SMenu> menuTrees = buildMenuTree(menus);
        return menuTrees.stream().map(TreeSelect::new).collect(Collectors.toList());
    }

    /**
     * 构建前端所需要树结构
     *
     * @param menus 菜单列表
     * @return 树结构列表
     */

    public List<SMenu> buildMenuTree(List<SMenu> menus)
    {
        List<SMenu> returnList = new ArrayList<SMenu>();
        List<Long> tempList = new ArrayList<Long>();
        for (SMenu dept : menus)
        {
            tempList.add(dept.getMenuId().longValue());
        }
        for (Iterator<SMenu> iterator = menus.iterator(); iterator.hasNext();)
        {
            SMenu menu = (SMenu) iterator.next();
            // 如果是顶级节点, 遍历该父节点的所有子节点
            if (!tempList.contains(menu.getParentId()))
            {
                recursionFn(menus, menu);
                returnList.add(menu);
            }
        }
        if (returnList.isEmpty())
        {
            returnList = menus;
        }
        return returnList;
    }


    /**
     * 递归列表
     *
     * @param list
     * @param t
     */
    private void recursionFn(List<SMenu> list, SMenu t)
    {
        // 得到子节点列表
        List<SMenu> childList = getChildList(list, t);
        t.setChildrens(childList);
        for (SMenu tChild : childList)
        {
            if (hasChild(list, tChild))
            {
                recursionFn(list, tChild);
            }
        }
    }
    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<SMenu> list, SMenu t)
    {

        return getChildList(list, t).size() > 0 ? true : false;
    }
    /**
     * 得到子节点列表
     */
    private List<SMenu> getChildList(List<SMenu> list, SMenu t)
    {
        List<SMenu> tlist = new ArrayList<SMenu>();
        Iterator<SMenu> it = list.iterator();
        while (it.hasNext())
        {
            SMenu n = (SMenu) it.next();
            if (n.getParentId().longValue() == t.getMenuId().longValue())
            {
                tlist.add(n);
            }
        }
        return tlist;
    }
}

package com.example.springboot_activiti.framework.web.service;

import com.example.springboot_activiti.project.system.domain.po.SMenu;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BaseServiceImpl {

    //获取菜单项
    public List<SMenu> getChildren(String id, List<SMenu> menus) {
        List<SMenu> children = new ArrayList<>();
        for (SMenu menu : menus) {
            if (menu.getParentId().toString().equals(id)) {
                children.add(menu);
            }
        }

        for (SMenu menu : children) {
            menu.setChildrens(getChildren(menu.getMenuId().toString(), menus));
        }
        return children;
    }


}

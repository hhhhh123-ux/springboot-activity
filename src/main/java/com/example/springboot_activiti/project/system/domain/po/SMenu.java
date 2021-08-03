package com.example.springboot_activiti.project.system.domain.po;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.example.springboot_activiti.framework.web.domain.po.BasePO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * s_menu
 * @author 
 */
@Data
public class SMenu extends BasePO {
    private Integer menuId;

    private String menuName;

    private String menuUrl;

    private Integer parentId;

    private Integer orderNum;

    private String menuType;

    private String status;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SMenu> childrens;

}
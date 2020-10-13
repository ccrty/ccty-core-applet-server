package com.ccty.noah.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author 缄默
 * @date   2020/09/24
 */
@ApiModel("角色资源对象")
@Data
@NoArgsConstructor
public class RoleResourcesDTO extends BaseDTO {

    @NotNull(message = "角色id不能为空")
    @ApiModelProperty(value = "角色id")
    private Long roleId;

    @NotEmpty(message = "资源id集合不能为空")
    @ApiModelProperty(value = "资源id集合")
    private List<Long> resourcesIdList;

    @ApiModelProperty(value = "选中的资源")
    private List<Long> checkedList;

    @ApiModelProperty(value = "默认展开的资源")
    private List<Long> expandedList;


}

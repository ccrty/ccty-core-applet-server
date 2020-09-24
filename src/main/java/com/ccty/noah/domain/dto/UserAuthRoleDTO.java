package com.ccty.noah.domain.dto;

import com.ccty.noah.aop.target.NoahController;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author 缄默
 * @date   2020/09/24
 */
@ApiModel("用户授权角色对象")
@Data
@NoahController
public class UserAuthRoleDTO extends BaseDTO {

    @NotNull(message = "角色id不能为空")
    @ApiModelProperty(value = "角色id",example = "0")
    public Long roleId;

    @NotEmpty(message = "用户id集合不能为空")
    @ApiModelProperty("用户id集合")
    public List<Long> userList;
}

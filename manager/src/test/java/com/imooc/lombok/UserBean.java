package com.imooc.lombok;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBean {

    //名称
    private @Getter @Setter String name;
    //年龄
    private int age;
    //家庭住址
    private String address;

}

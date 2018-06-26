package com.imooc.lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Data 中包含了 @Getter @Setter @ToString @EqualsAndHashCode @RequiredArgsConstructor 这几个注解
 * @Getter 表示为当前类的属性自动生成 Getter 方法
 * @Setter 表示为当前类的属性自动生成 Setter 方法
 * @ToString 表示为当前类的属性自动生成 ToString 方法
 * @ToString 表示为当前类的属性自动生成 ToString 方法
 * @EqualsAndHashCode 表示为当前类的属性自动生成 EqualsAndHashCode 方法
 * @RequiredArgsConstructor 生成一个包含必填参数的构造函数, 要与@NonNull 搭配使用，该注解修饰的属性就是必填参数
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleUser {

    private String username;
    private String password;
    private Integer age;

}
